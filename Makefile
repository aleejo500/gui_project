BIN = bin
SRC = src
PROP = properties
JDBC = jar/jdbc4.jar

all : create_bin compile

create_bin :
	mkdir -p $(BIN)

compile :
	javac -encoding UTF-8 -d $(BIN) -classpath $(SRC):$(JDBC) \
	$(SRC)/Gui/Main.java

clean :
	rm -rvf $(BIN)

exec :
	java -cp $(BIN):$(PROP):$(JDBC) Gui.Main
