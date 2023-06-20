#удаление папки если она уже существует
rm -rf target;
mkdir target;

#compile
javac  src/java/edu/school21/printer/*/*.java -d ./target;

#run program
java -cp ./target edu.school21.printer.app.Main
