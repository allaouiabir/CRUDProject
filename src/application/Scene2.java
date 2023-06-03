package application;

import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scene2 extends Application{
	private TableView<contacts> table = new TableView<contacts>();
	private contactsDAO studentsDAO = new contactsDAO();
	
	public void updateTable(contacts newContact) {
        table.getItems().add(newContact);
    }
	
	//textfield de formulaire
	public static TextField FnameField;
	public static TextField numField;
	public static TextField emailField;
	public static TextField mediaField;
	public static TextField adressField;
	public static TextField relationField;
	public static TextField dateField;
	public static TextField noteField;
    

	 public  void fillFieldsWithContact(contacts contact) {
        FnameField.setText(contact.getFullName());
        numField.setText(String.valueOf(contact.getNumberPhone()));
        emailField.setText(contact.getEmail());
        mediaField.setText(contact.getSocialMedia());
        adressField.setText(contact.getAdress());
        relationField.setText(contact.getRelationship());
        dateField.setText(contact.getDates());
        noteField.setText(contact.getNotes());
    }

	 public  void emptyFields() {
        FnameField.setText("");
        numField.setText("");
        emailField.setText("");
        mediaField.setText("");
        adressField.setText("");
        relationField.setText("");
        dateField.setText("");
        noteField.setText("");
    }

	public void start(Stage primaryStage) throws Exception {
		VBox root2=new VBox();
        root2.setAlignment(Pos.CENTER);
		Scene scene2 = new Scene(root2, 1280, 650);
		Main scene1=new Main();
		primaryStage.setScene(scene2);
		primaryStage.setTitle("Contact Management");
		
        //nom de l'appication et son style
		Text appName = new Text(50, 50, "MyContactKeeper");
        Font f = Font.font("Times New Roman", FontWeight.BOLD, 40);
        appName.setFont(f);
        appName.setFill( Color.MEDIUMBLUE );
        DropShadow shadow = new DropShadow(6, 3, 3,Color.BLACK);
        appName.setEffect(shadow);
        
        //formulaire
        VBox formBox = new VBox(10);
        formBox.setPadding(new Insets(10));
        
        // Ajoutez des éléments de formulaire tels que des étiquettes et des champs de texte ici
        Label FnameLabel = new Label("Full Name:");
        FnameField = new TextField();
        Label numLabel = new Label("Number Phone:");
         numField = new TextField();
        Label emailLabel = new Label("Email:");
         emailField = new TextField();
        Label mediaLabel = new Label("Social Media Profiles:");
         mediaField = new TextField();
        Label adressLabel = new Label("Adress:");
         adressField = new TextField();
        Label relationLabel = new Label("Relationship:");
        relationField = new TextField();
        Label dateLabel = new Label("Important dates:");
        dateField = new TextField();
        Label noteLabel = new Label("Notes:");
        noteField = new TextField();
                
        //lajout des champs et labels dune facon verticale
        formBox.getChildren().addAll(FnameLabel, FnameField,numLabel,numField,emailLabel
        		,emailField,mediaLabel,mediaField,adressLabel,adressField,relationLabel,relationField
        		,dateLabel,dateField,noteLabel,noteField);
        
        //pour poser le formulaire et table dune facon horizontale
        HBox tableFormBox = new HBox(200);
        tableFormBox.setPadding(new Insets(10));
        
        //les colonnes de la table
        TableColumn<contacts, Integer> idCol= new TableColumn<contacts, Integer>("ID");
		TableColumn<contacts, String> nameCol= new TableColumn<contacts, String>("Full Name");
		TableColumn<contacts, Long>   numCol= new TableColumn<contacts, Long>("Number Phone");
		TableColumn<contacts, String> emailCol= new TableColumn<contacts, String>("Email");
		TableColumn<contacts, String> mediaCol= new TableColumn<contacts, String>("Social Media Profiles");
		TableColumn<contacts, String> adressCol= new TableColumn<contacts, String>("Adress");
		TableColumn<contacts, String> relationCol= new TableColumn<contacts, String>("Relationship");
		TableColumn<contacts, String> dateCol= new TableColumn<contacts, String>("Important dates");
		TableColumn<contacts, String> noteCol= new TableColumn<contacts, String>("Notes");

        //l'ajout des colonnes dans la table
        table.getColumns().addAll(idCol,nameCol,numCol,emailCol,mediaCol
        		,adressCol,relationCol,dateCol,noteCol);
        
        tableFormBox.getChildren().addAll(formBox,table);
        
        idCol.setCellValueFactory(new PropertyValueFactory<contacts,Integer>("id"));
     	nameCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("fullName"));
     	numCol.setCellValueFactory(new PropertyValueFactory<contacts,Long>("numberPhone"));
     	emailCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("email"));
     	mediaCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("socialMedia"));
     	adressCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("adress"));
     	relationCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("relationship"));
     	dateCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("dates"));
     	noteCol.setCellValueFactory(new PropertyValueFactory<contacts,String>("notes"));

        
        //pour avoir le meme size pour tous les columns
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		//remplir la table
	 	table.getItems().addAll(contactsDAO.getAllContacts());
	 	
	 	table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	 	    if (newSelection != null) {
	 	        fillFieldsWithContact(newSelection);
	 	    }
	 	});

		
		
		
		
		List<contacts> contactList = contactsDAO.getAllContacts();
		for(contacts student : contactList){
			System.out.println("*************************************");
			System.out.println("Name:"+student.getFullName());
			System.out.println("Name:"+student.getNumberPhone());
			System.out.println("Email:"+student.getEmail());
			System.out.println("Name:"+student.getSocialMedia());
			System.out.println("Name:"+student.getAdress());
			System.out.println("Name:"+student.getRelationship());
			System.out.println("Name:"+student.getDates());
			System.out.println("Name:"+student.getNotes());
		}

       
		
		//les boutons 
        DropShadow shadowa = new DropShadow(10, 3, 3, Color.gray(0));
        
        
		//bouton retour
		Button returne =new Button("return");
		//le clique sur le bouton retour						
		returne.setOnAction((EventHandler<ActionEvent>)new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				scene1.start(primaryStage);

		}								
		});
		returne.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			returne.setEffect(shadowa);

         });

		returne.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			returne.setEffect(null);

         });
		
		returne.setTextFill(Color.WHITE);
		returne.setStyle("-fx-background-color: brown; ");
		
		//bouton quit
		Button quit =new Button("quit");
		//le clique sur le bouton quit						
		quit.setOnAction((EventHandler<ActionEvent>)new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				scene1.fermerprog();
			}								
		});
		quit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			quit.setEffect(shadowa);

         });

		quit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			quit.setEffect(null);

         });
		quit.setTextFill(Color.WHITE);
		quit.setStyle("-fx-background-color: black; ");
		
		//CRUD buttons
		//insert
		Button insert = new Button("New");
		insert.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			insert.setEffect(shadowa);

         });

		insert.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			insert.setEffect(null);

         });
		//changer la couleur du texte dans un bouton
		insert.setTextFill(Color.WHITE);
		//changer le background dun bouton
		insert.setStyle("-fx-background-color: green; ");
		
		insert.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                //  Contact avec les valeurs des champs
	                contacts newContact = new contacts();
	                newContact.setFullName(FnameField.getText());
	                
	                String phoneNumberString = numField.getText();
		            long phoneNumber = Long.parseLong(phoneNumberString);
		            newContact.setNumberPhone(phoneNumber);
	             
	                newContact.setEmail(emailField.getText());
	                newContact.setSocialMedia(mediaField.getText());
	                newContact.setAdress(adressField.getText());
	                newContact.setRelationship(relationField.getText());
	                newContact.setDates(dateField.getText());
	                newContact.setNotes(noteField.getText());

	                

	                // Appeler la méthode insert() de la classe contactsDAO
	                contactsDAO contacts = new contactsDAO();
	                contacts.insert(newContact);	
	                

		            table.getItems().clear();
		         	table.getItems().addAll(contactsDAO.getAllContacts());

	            }
	        });

		
		
		
		//update
		Button update = new Button("Modify");
		update.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			update.setEffect(shadowa);

         });

		update.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			update.setEffect(null);

         });
		
		//changer la couleur du texte dans un bouton
		update.setTextFill(Color.WHITE);
		//changer le background dun bouton
		update.setStyle("-fx-background-color: orange; ");
		
		update.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        // Récupérer le contact sélectionné dans la table
		        contacts selectedContact = table.getSelectionModel().getSelectedItem();
		        if (selectedContact == null) {
		            // Aucun contact sélectionné, 
		        	Alert alert = new Alert(AlertType.WARNING);
		        	alert.setTitle("No Contact Selected");
		            alert.setHeaderText("No Contact Selected");
		            alert.setContentText("Please select a contact to update.");
		            alert.showAndWait();
		        }
		        else {
		        	
		        	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			        alert.setTitle("Confirmation");
			        alert.setHeaderText("Update Contact");
			        alert.setContentText("Are you sure you want to update this contact?");
			        
			        alert.getButtonTypes().removeAll(ButtonType.OK,ButtonType.CANCEL);
					ButtonType btnOUI =new ButtonType("YES");
					ButtonType btnNON =new ButtonType("NO");
					
					alert.getButtonTypes().addAll(btnOUI,btnNON);

					Optional<ButtonType> resultat =alert.showAndWait();
					if (resultat.isPresent() && resultat.get()==btnOUI) {
						
						    String fullName = FnameField.getText();
				            long numberPhone = Long.parseLong(numField.getText());
				            String email = emailField.getText();
				            String socialMedia = mediaField.getText();
				            String adress = adressField.getText();
				            String relationship = relationField.getText();
				            String dates = dateField.getText();
				            String notes = noteField.getText();
				            contactsDAO.update(selectedContact, fullName, numberPhone, email, socialMedia, adress,
				                    relationship, dates, notes);
				            
				            table.getItems().clear();
				         	table.getItems().addAll(contactsDAO.getAllContacts());

				            
				           

			    }}}
			});
		
		///DELETE
		
		Button delete = new Button("Delete");
		delete.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			delete.setEffect(shadowa);

         });

		delete.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			delete.setEffect(null);

         });
		//changer la couleur du texte dans un bouton
		delete.setTextFill(Color.WHITE);
		//changer le background dun bouton
		delete.setStyle("-fx-background-color: red; ");
		
		delete.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        // Récupérer le contact sélectionné dans la table
		        contacts selectedContact = table.getSelectionModel().getSelectedItem();
		        if (selectedContact == null) {
		            // Aucun contact sélectionné, 
		        	Alert alert = new Alert(AlertType.WARNING);
		        	alert.setTitle("No Contact Selected");
		            alert.setHeaderText("No Contact Selected");
		            alert.setContentText("Please select a contact to delete.");
		            alert.showAndWait();
		        }
		        else {

		        // Afficher une boîte de dialogue de confirmation
		        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        alert.setTitle("Confirmation");
		        alert.setHeaderText("Delete Contact");
		        alert.setContentText("Are you sure you want to delete this contact?");
		        
		        alert.getButtonTypes().removeAll(ButtonType.OK,ButtonType.CANCEL);
				ButtonType btnOUI =new ButtonType("YES");
				ButtonType btnNON =new ButtonType("NO");
				
				alert.getButtonTypes().addAll(btnOUI,btnNON);

				Optional<ButtonType> resultat =alert.showAndWait();//stocker le resultat :ok ou cancel dans lobjet resultat 
				if (resultat.isPresent() && resultat.get()==btnOUI) {
					contactsDAO contacts = new contactsDAO();
		            contacts.delete(selectedContact);

		            // Supprimer le contact de la table
		            table.getItems().remove(selectedContact);			}		        
		       
		    }}
		});


		//bouton de supprimr le contenu des champs
		Button clearfields = new Button("clearfields");
		clearfields.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	emptyFields();           	           	
            }});
		
		clearfields.setTextFill(Color.WHITE);
		clearfields.setStyle("-fx-background-color: gray; ");
		
		clearfields.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			clearfields.setEffect(shadowa);

         });

		clearfields.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			clearfields.setEffect(null);

         });
		
		//bouton e voir le profil
		Button viewProfil = new Button("View Profil");
		viewProfil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
				scene4.start(primaryStage);


            }});
		viewProfil.setTextFill(Color.WHITE);
		viewProfil.setStyle("-fx-background-color: darkturquoise; ");
		
		viewProfil.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
			viewProfil.setEffect(shadowa);

         });

		viewProfil.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
			viewProfil.setEffect(null);

         });
		
		
		//mettre les buttons dune facon horizontale
        HBox buttonsBox = new HBox(10);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(insert,update,delete,clearfields,viewProfil,returne,quit);

		
		
		
		//ajout des elements dans la scene
		root2.getChildren().addAll(appName,tableFormBox,buttonsBox);
	}
    
}
