package pkg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg.connection.*;

public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract void create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract void delete(int id);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract void update(String table, String colonne, Object champs, int id);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
   
   /**
  * Méthode de recherche de toutes les informations
  * @return List<T>
  */
  public abstract List<T> findAll();
}
