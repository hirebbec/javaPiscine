#удаление папки если она уже существует
rm -rf target;
mkdir target;

#compile
javac  src/java/edu/school21/printer/*/*.java -d ./target/ ;

# copy resources
cp -R ./src/resources ./target/resources;

# create jar
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target . ;

#run program
java -jar target/images-to-chars-printer.jar . O ;