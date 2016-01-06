package pkg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg.data.*;

public class utilisateurDAO {
   
  public utilisateurDAO(Connection conn){
    super(conn);
  }
   
  /**
  * Méthode de création
  * @param utilisateur
  * @return boolean 
  */
  public void create(Utilisateur utilisateur){
		/*try{
			PreparedStatement prepareStatement = this.connect.prepareStatement(
					"INSERT INTO 'brasserie' VALUES(?, ?, ? ,?);");
					prepareStatement.setInt(1, brasserie.getId());
					prepareStatement.setString(2, brasserie.getNom());
					prepareStatement.setString(3, brasserie.getVille());
					prepareStatement.setString(4, brasserie.getPays());
					prepareStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

  /**
  * Méthode pour effacer
  * @param utilisateur
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
  * @param utilisateur
  * @return boolean
  */
  public void update(String table, String colonne, Object champs, int id){
  }

  /**
  * Méthode de recherche des informations
  * @param id
  * @return Utilisateur
  */
  public Utilisateur find(int id){
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
  * @return List<Utilisateur>
  */
  public List<Utilisateur> findAll(){
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
