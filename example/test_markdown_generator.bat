:: Compile UTILS 
javac utils\*.java -d classes

:: Compile NOUN generators
javac NounDescriptor.java NounGenerator.java FileReaderGenerator.java -cp classes -d classes

:: Generate NOUN classes
java -cp classes NounGenerator Address
java -cp classes NounGenerator Partner
java -cp classes NounGenerator Customer
java -cp classes FileReaderGenerator Address
java -cp classes FileReaderGenerator Partner

:: Compile NOUN classes
javac gen\*.java -cp classes -d classes

:: Compile MARKDOWN generators
javac MarkdownGenerator.java -cp classes -d classes

:: Generate MARKDOWN documents
java -cp classes MarkdownGenerator partners