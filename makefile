JC=javac -Xlint
JR=java
SDIR=src
ODIR=obj

all :
	$(JC) -d $(ODIR) src/pkg/connection/BDD.java src/Main.java src/Login.java src/GuiPOS.java src/POS.java src/BDD.java src/pkg/data/* src/pkg/dao/snackDAO.java

clean :
	rm -f $(ODIR)/*.class

test : clean all run

run : 
	cd $(ODIR) && $(JR) -classpath .:mysql-connector-java-5.1.36-bin.jar Main && cd ..

db :
	mysql -h 88.160.64.214 -u adem -p

# commandes utiles :
# show databases;
# use dbname
# show tables;
