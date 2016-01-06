package pkg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg.data.*;

public class venteDAO {
   
  public venteDAO(Connection conn){
    super(conn);
  }
   
  /**
  * Méthode de création
  * @param vente
  * @return boolean 
  */
  public void create(Vente vente){
		try{
			PreparedStatement prepareStatement = this.connect.prepareStatement(
					"INSERT INTO 'vente' VALUES(?, NOW(), ? ,?);");
					prepareStatement.setInt(1, vente.getIdVente());
					prepareStatement.setInt(2, vente.getIdUser());
					prepareStatement.setString(3, vente.getIdSnack());
					prepareStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

  /**
  * Méthode pour effacer
  * @param vente
  * @return boolean 
  */
  public void delete(int id){
		/*try {
			this.connect.createStatement()
				.executeUpdate(
				"DELETE FROM 'brasserie' WHERE idBrasserie =" + id + "; " +
				"UPDATE 'breuvage' set idBrasserie = null where idBrasserie =" + id + "; ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
	}

  /**
  * Méthode de mise à jour
  * @param vente
  * @return boolean
  */
  public void update(String table, String colonne, Object champs, int id){
  }

  /**
  * Méthode de recherche des informations
  * @param id
  * @return Vente
  */
  public Vente find(int id){
		/*Brasserie brasserie = new Brasserie();      
      
		try {
			ResultSet result = this.connect.createStatement().executeQuery(
					"SELECT * FROM brasserie WHERE idBrasserie = " + id);
			brasserie = new Brasserie(
				result.getInt("idBrasserie"),
				result.getString("nom"),
				result.getString("ville"),
				result.getString("pays"));         
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return brasserie;*/
	}
   
   /**
  * Méthode de recherche de toutes les informations
  * @return List<Vente>
  */
  public List<Vente> findAll(){
		/*List<Brasserie> brasserie = new ArrayList<Brasserie>();      
      
		try {
			ResultSet result = this.connect.createStatement()
				.executeQuery("SELECT * FROM brasserie");
			while(result.next())
				brasserie.add(new Brasserie(
					result.getInt("idBrasserie"),
					result.getString("nom"),
					result.getString("ville"),
					result.getString("pays")));    
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return brasserie;*/
	}
}
