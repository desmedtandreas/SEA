java -cp classes:utils NounGenerator Customer
java -cp classes:utils NounGenerator Order
java -cp classes:utils NounGenerator ProductVariant
java -cp classes:utils NounGenerator ProductVariant_Order
java -cp classes:utils NounGenerator Price

java -cp classes:utils FileReaderGenerator Customer
java -cp classes:utils FileReaderGenerator Order
java -cp classes:utils FileReaderGenerator ProductVariant
java -cp classes:utils FileReaderGenerator ProductVariant_Order
java -cp classes:utils FileReaderGenerator Price

java -cp classes:utils RepositoryGenerator

cd gen
javac -d classes *.java
cd ..