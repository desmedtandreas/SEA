# Assignment Document Generator

Next to creating a generator to generate code, you can also use the princples for the course Software Engineering and Architecture to develop a document generator.
In the lecture we explain how this can be done.
The code that was discussed, is included in the 'example' folder of this repository.

The goal of this assignment is to create a document generator that generates invoices using data that is available in your application.
These invoices should be made in the standard called [Markdown](https://en.wikipedia.org/wiki/Markdown).
You can consult the initial syntax of Markdown [here](https://daringfireball.net/projects/markdown/syntax).
But as you can read in the article in the first link, several extensions of the initial specification have been developed, each with its own additions to the syntax.
You can also use the syntax additions of these extension to design the document needed for this assignment.

In this exercise we continue to use the case of The Antwerp Company, a fictious company that provides services and sell products that are local to the Antwerp region.
The domain model that shows the structure is included below.

![domainClassModel_TAC](img/TAC_domainClassModel.png)

## Required functionality

To create a document generator, you first need to develop the Java files of the domain classes that contain the required data to include in the generated document.
To create an **invoice generator**, you need data from _at least_ these domain classes:

1. Customer
2. Order
3. ProductVariant_Order
4. ProductVariant
5. Price

If you have not yet developed Java classes for these domain classes in previous assignments, you first need to develop these.
You can do this manually, or write code generators to generate the code for these files. 

For each of these domain classes, you need to develop:

- A Java class that contains the **details** of the domain class and links to the associated class(es)
- A Java class to manage a **list** of instances of the domain class, including links to the associated class(es)
- A **reader** Java class to read data about instances of the domain class from a csv file
- A **csv file** containing the data of 10 instances

In addition to this, you need to develop:

- A **mirror class** that reads the data from each domain class from its csv file
- A **document generator** that generates an invoice document for each order in the system, in a Markdown format. An invoice should include all required and relevant information that is available in the system. This includes:
  - Information about the customer
  - Information about the order
  - Information about the products that are part of the order
  - Invoice amount for each order line, and the total invoice amount (both excluding and including VAT)
  - ...

## Learning objectives

- Develop a generator that generates Markdown documents containing data from application memory