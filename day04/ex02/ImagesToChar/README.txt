#удаление папки если она уже существует
rm -rf target lib;
mkdir target lib;

# download libs
curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar;
curl -o lib/JColor-5.5.1.jar https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar;

# compile
javac -cp ".:./lib/JColor-5.5.1.jar:./lib/jcommander-1.82.jar" -d ./target/ src/java/edu/school21/printer/*/*.java;

# copy resources
cp -rf ./src/resources ./target;

# unzip
cd target ; jar xf ../lib/JColor-5.5.1.jar com ; jar xf ../lib/jcommander-1.82.jar com ; cd .. ;

# create jar
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target . ;

#run program
java -cp ./target edu.school21.printer.app.Main --white=RED --black=GREEN;
