BIN = ./bin
SRC = ./src

all :
	javac -encoding UTF-8 -d $(BIN) -classpath $(SRC) $(SRC)/Gui/Main.java

clean : clean_gui

clean_gui :
	rm -rf ../bin/Gui/*

exec :
	java -cp ./bin Gui.Main
