import java.io.*;
import java.util.*;

public class InvoiceGenerator {

  String orderCsvFile = "";
  String customerCsvFile = "";
  String priceCsvFile = "";
  String productVariant_OrderCsvFile = "";
  String productVariantCsvFile = "";

  CustomerList customers = new CustomerList("customers");
  OrderList orders = new OrderList("orders");
  PriceList prices = new PriceList("prices");
  ProductVariant_OrderList productVariant_Orders = new ProductVariant_OrderList("productVariant_Orders");
  ProductVariantList productVariants = new ProductVariantList("productVariants");

  StringReader modelReader = new StringReader("models/");
  StringReader templateReader = new StringReader("resources/");
  StringWriter interimWriter = new StringWriter("temp/");
  StringHandler stringHandler = new StringHandler();

  public InvoiceGenerator(String csvFolderPath) {

    orderCsvFile = csvFolderPath + "/orders";
    customerCsvFile = csvFolderPath + "/customers";
    priceCsvFile = csvFolderPath + "/prices";
    productVariant_OrderCsvFile = csvFolderPath + "/productVariant_Orders";
    productVariantCsvFile = csvFolderPath + "/productVariants";

    OrderFileReader orderFileReader = new OrderFileReader();
    CustomerFileReader customerFileReader = new CustomerFileReader();
    PriceFileReader priceFileReader = new PriceFileReader();
    ProductVariant_OrderFileReader productVariant_OrderFileReader = new ProductVariant_OrderFileReader();
    ProductVariantFileReader productVariantFileReader = new ProductVariantFileReader();

    orders = orderFileReader.readCsvFile(orderCsvFile);
    customers = customerFileReader.readCsvFile(customerCsvFile);
    prices = priceFileReader.readCsvFile(priceCsvFile);
    productVariant_Orders = productVariant_OrderFileReader.readCsvFile(productVariant_OrderCsvFile);
    productVariants = productVariantFileReader.readCsvFile(productVariantCsvFile);
  }
 
  public static void main(String [] args) {
    String csvFolderPath = args[0];
    System.out.println("InvoiceGenerator for Orders in the system ;-)");
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator(csvFolderPath);
    StringWriter interimWriter = new StringWriter("temp/");
    StringWriter invoiceWriter = new StringWriter("gen/invoices/");

    for (Order order : invoiceGenerator.orders.getMembers()) {
      System.out.println("Generating invoice for Order ["+order.getOrderId()+"]");
      String invoiceCode = invoiceGenerator.generateSkeleton(order);
      invoiceCode = invoiceGenerator.addInvoiceLines(invoiceCode, order);
      invoiceWriter.writeFile(invoiceCode, order.getOrderId()+".md");
    }
  }

  public String generateSkeleton(Order order) {
    String template = templateReader.readFile("InvoiceMarkdownTemplate.tmpl");
    String orderCode = stringHandler.replaceAll(template, "%OrderId%", order.getOrderId());
    Customer customer = order.getCustomer();
    orderCode = stringHandler.replaceAll(orderCode, "%CustomerId%", customer.getCustomerId());
    orderCode = stringHandler.replaceAll(orderCode, "%FirstName%", customer.getFirstName());
    orderCode = stringHandler.replaceAll(orderCode, "%LastName%", customer.getLastName());
    orderCode = stringHandler.replaceAll(orderCode, "%BirthDate%", customer.getBirthDate());
    orderCode = stringHandler.replaceAll(orderCode, "%PhoneNumber%", customer.getPhoneNumber());
    interimWriter.writeFile(orderCode, order.getOrderId()+"-skeleton.md");
    return orderCode;
  }

  public String addInvoiceLines(String baseContent, Order order) {
    String result = baseContent;
    String invoiceLineTemplate = templateReader.readFile("InvoiceLineMarkdownTemplate.tmpl");

    float totalPrice = 0.0f;
    float totalPriceWithVat = 0.0f;

    for (ProductVariant_Order productVariant_Order : productVariant_Orders.getMembers()) {

      if (!productVariant_Order.getOrder().equals(order)) {
        continue;
      }
      float quantity = productVariant_Order.getQuantity();
      String invoiceLineCode = stringHandler.replaceAll(invoiceLineTemplate, "%Quantity%", String.valueOf(quantity));
      ProductVariant productVariant = productVariant_Order.getProductVariant();
      float vatRate = productVariant.getVatRate();
      invoiceLineCode = stringHandler.replaceAll(invoiceLineCode, "%ProductVariantId%", productVariant.getProductVariantId());
      invoiceLineCode = stringHandler.replaceAll(invoiceLineCode, "%VatRate%", String.valueOf(vatRate));

      for (Price price : prices.getMembers()) {
        float unitPrice = price.getUnitPrice();
        float unitPriceVat = unitPrice * (1 + vatRate / 100.0f);

        if (price.getProductVariant().equals(productVariant)) {
          invoiceLineCode = stringHandler.replaceAll(invoiceLineCode, "%UnitPrice%", String.valueOf(unitPrice));
          invoiceLineCode = stringHandler.replaceAll(invoiceLineCode, "%UnitPriceVat%", String.valueOf(unitPriceVat));
          totalPrice += unitPrice * quantity;
          totalPriceWithVat += unitPriceVat * quantity;
          break;
        }
      }
      result = stringHandler.injectBefore(result, "| **Total** |", invoiceLineCode);
    }

    result = stringHandler.replaceAll(result, "%TotalExcludingVat%", String.valueOf(totalPrice));
    result = stringHandler.replaceAll(result, "%TotalIncludingVat%", String.valueOf(totalPriceWithVat));

    interimWriter.writeFile(result, order.getOrderId()+"-with-invoice-lines.md");
    return result;
  }


}