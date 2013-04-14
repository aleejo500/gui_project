BIN = ./bin
SRC = ./src
PROP = ./properties

all :
	javac -encoding UTF-8 -d $(BIN) -classpath $(SRC) $(SRC)/Gui/Main.java

clean : clean_gui

clean_gui :
	rm -rvf $(BIN)/Gui/*

exec :
	java -cp $(BIN):$(PROP) Gui.Main
