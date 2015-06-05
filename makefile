JC=javac -Xlint
JR=java
SDIR=src
ODIR=obj

all :
	$(JC) -d $(ODIR) src/Main.java src/Login.java src/GuiPOS.java src/POS.java

clean :
	rm -f $(ODIR)/*.class

test : clean all run

run : 
	$(JR) -classpath $(ODIR) Main
