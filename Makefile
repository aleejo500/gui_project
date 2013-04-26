BIN = bin
SRC = src
HTML = html
PROP = properties
JDBC = jar/jdbc4.jar

all : create_bin
	javac -encoding UTF-8 -d $(BIN) -classpath $(SRC):$(JDBC) \
	$(SRC)/Gui/Main.java

create_bin :
	mkdir -p $(BIN)

create_html :
	mkdir -p $(HTML)

javadoc : create_html
	javadoc -docencoding "UTF-8" -charset "UTF-8" \
	 -d $(HTML) -sourcepath $(SRC) \
	Gui

clean :
	rm -rf $(BIN) $(HTML)

exec :
	java -cp $(BIN):$(PROP):$(JDBC) Gui.Main
