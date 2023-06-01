package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class contactsDAO {
	private static Connection connection;
	private static Scene2 scene2;
	 public contactsDAO(Scene2 scene2) {
	        try {
	            connection = DatabaseConnection.getConnection();
	            this.scene2 = scene2;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	public  contactsDAO() {
		try { 
			connection= DatabaseConnection.getConnection();
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	    public static List<contacts> getAllContacts(){
		List<contacts> contactList = new ArrayList<>();
		//select
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT *FROM contacts");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				contacts theContact = new contacts();
				theContact.setId(resultSet.getInt("id"));
				theContact.setFullName(resultSet.getString("fullName"));
				theContact.setNumberPhone(resultSet.getLong("numberPhone"));
				theContact.setEmail(resultSet.getString("email"));
				theContact.setSocialMedia(resultSet.getString("socialMedia"));
				theContact.setAdress(resultSet.getString("adress"));
				theContact.setRelationship(resultSet.getString("relationship"));
				theContact.setDates(resultSet.getString("dates"));
				theContact.setNotes(resultSet.getString("notes"));
				
				contactList.add(theContact);				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return contactList;
		}	   

	    //insert
	    public void insert(contacts contact) {
	        try {
	            PreparedStatement statement = connection.prepareStatement(
	                "INSERT INTO contacts(fullName, numberPhone, email, socialMedia, adress, relationship, dates, notes) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
	            );
	            
	            statement.setString(1, contact.getFullName());
	            statement.setLong(2, contact.getNumberPhone());
	            statement.setString(3, contact.getEmail());
	            statement.setString(4, contact.getSocialMedia());
	            statement.setString(5, contact.getAdress());
	            statement.setString(6, contact.getRelationship());
	            statement.setString(7, contact.getDates());
	            statement.setString(8, contact.getNotes());
	            
             

	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Contact inserted successfully.");
					scene2.updateTable(contact);
	            } else {
	                System.out.println("Failed to insert contact.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	    }

	    public void delete(contacts contact) {
	        try {
	            PreparedStatement statement = connection.prepareStatement(
	                    "DELETE FROM contacts WHERE id = ?");
	            statement.setInt(1, contact.getId());

	            // Exécuter la requête de suppression
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    

	    
	    ///UPDAAATE
	   
	    public static void update(contacts contact, String fullName, long numberPhone, String email, String socialMedia, String adress,
	            String relationship, String dates, String notes) {
	    	  try {
	    	 PreparedStatement statement = connection.prepareStatement(
	                 "UPDATE contacts SET fullName = ?, numberPhone = ?, email = ?, socialMedia = ?,"
	                 + " adress = ?, relationship = ?, dates = ?, notes = ? WHERE id = ?");

			// Définir les paramètres de la requête d'update
	    	 statement.setString(1, fullName);
			 statement.setLong(2, numberPhone);
	         statement.setString(3, email);
	         statement.setString(4, socialMedia);
	         statement.setString(5, adress);
	         statement.setString(6, relationship);
	         statement.setString(7, dates);
	         statement.setString(8, notes);
	         statement.setInt(9, contact.getId());
	         


        // Exécuter la requête d'update
        statement.executeUpdate();
		ResultSet resultSet = statement.executeQuery();

        contact.setId(resultSet.getInt("id"));
        contact.setFullName(resultSet.getString("fullName"));
        contact.setNumberPhone(resultSet.getLong("numberPhone"));
        contact.setEmail(resultSet.getString("email"));
        contact.setSocialMedia(resultSet.getString("socialMedia"));
        contact.setAdress(resultSet.getString("adress"));
        contact.setRelationship(resultSet.getString("relationship"));
        contact.setDates(resultSet.getString("dates"));
        contact.setNotes(resultSet.getString("notes"));        
       


    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}








		


