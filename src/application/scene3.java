package application;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class scene3 extends Application{
	private TableView<contacts> table = new TableView<contacts>();
	private contactsDAO studentsDAO = new contactsDAO();
	

	public  void start(Stage primaryStage) {
		try {

	VBox root3=new VBox(30);
    root3.setAlignment(Pos.CENTER);
	Scene scene3 = new Scene(root3, 1280, 650);
	Main scene1=new Main();
	primaryStage.setScene(scene3);
	primaryStage.setTitle("View My Contacts");
	
    //nom de l'application et son style
	Text appName = new Text(50, 50, "MyContactKeeper");
    Font f = Font.font("Times New Roman", FontWeight.BOLD, 40);
    appName.setFont(f);
    appName.setFill( Color.MEDIUMBLUE );
    DropShadow shadow = new DropShadow(6, 3, 3,Color.BLACK);
    appName.setEffect(shadow);
    
    //table
    table.setPadding(new Insets(10));

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
    
	//buttons 
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
	
	//mettre les buttons dune facon horizontale
    HBox buttonsBox = new HBox(10);
    buttonsBox.setAlignment(Pos.CENTER);
    buttonsBox.getChildren().addAll(returne,quit);

	root3.getChildren().addAll(appName,table,buttonsBox);


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

