#!/bin/bash

echo ":: Compile UTILS"
javac utils/*.java -d classes

echo ":: Compile NOUN generators"
javac NounDescriptor.java NounGenerator.java FileReaderGenerator.java RepositoryGenerator.java -cp classes -d classes

echo ":: Generate NOUN classes"
java -cp classes NounGenerator Customer
java -cp classes NounGenerator Order
java -cp classes NounGenerator Price
java -cp classes NounGenerator ProductVariant
java -cp classes NounGenerator ProductVariant_Order
java -cp classes RepositoryGenerator

java -cp classes FileReaderGenerator Customer
java -cp classes FileReaderGenerator Order
java -cp classes FileReaderGenerator Price
java -cp classes FileReaderGenerator ProductVariant
java -cp classes FileReaderGenerator ProductVariant_Order

echo ":: Compile NOUN classes"
javac gen/*.java -cp classes -d classes

echo ":: Compile MARKDOWN generators"
javac InvoiceGenerator.java -cp classes -d classes

echo ":: Generate MARKDOWN documents"
java -cp classes InvoiceGenerator data
