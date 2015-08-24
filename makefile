JC=javac -Xlint
JR=java
SDIR=src
ODIR=obj

all :
	$(JC) -d $(ODIR) src/Main.java src/Login.java src/GuiPOS.java src/POS.java src/pkg/connection/Connexion.java

clean :
	rm -f $(ODIR)/*.class

test : clean all run

run : 
	cd $(ODIR) && $(JR) -classpath .:mysql-connector-java-5.1.36-bin.jar Main && cd ..
