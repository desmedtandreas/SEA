java -cp classes;utils NounGenerator Address
java -cp classes;utils NounGenerator Partner
java -cp classes;utils NounGenerator Customer
cd gen
javac -d classes *.java
cd ..