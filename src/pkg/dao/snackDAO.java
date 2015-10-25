package pkg.dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg.data.*;

public class snackDAO {
  /**
  * Méthode de création
  * @param snack
  * @return boolean 
  */
  public void create(Snack snack){
	  
		try{
			PreparedStatement prepareStatement = this.connect.prepareStatement(
					"INSERT INTO 'snack' VALUES(?, ?, ? ,? ,?);");
					prepareStatement.setInt(1, snack.getType());
					prepareStatement.setInt(2, snack.getId());
					prepareStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

  /**
  * Méthode pour effacer
  * @param snack
  * @return boolean 
  */
  public void delete(int id){
		try {
			this.connect.createStatement()
				.executeUpdate(
				"DELETE FROM 'snack' WHERE idSnack =" + id + "; ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

  /**
  * Méthode de mise à jour
  * @param snack
  * @return boolean
  */
   public void update(Snack snack){
	  
		try{
			PreparedStatement prepareStatement = this.connect.prepareStatement(
					"INSERT INTO 'snack' VALUES(?, ?, ? ,? ,?);");
					prepareStatement.setInt(1, snack.getType());
					prepareStatement.setInt(2, snack.getId());
					prepareStatement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

  /**
  * Méthode de recherche des informations
  * @param id
  * @return Snack
  */
  public Snack find(int id){
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
  * @return List<Snack>
  */
  public List<Snack> findAll(){
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
