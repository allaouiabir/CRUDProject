package application;
	
import java.util.Optional;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1280, 650);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Welcome");

            VBox centerBox = new VBox(40);
            centerBox.setAlignment(Pos.CENTER);


            //le titre
            Text appName = new Text(50, 50, "MyContactKeeper");
            Font f = Font.font("Times New Roman", FontWeight.BOLD, 40);
            appName.setFont(f);
            appName.setFill( Color.MEDIUMBLUE );
            DropShadow shadow = new DropShadow(6, 3, 3,Color.BLACK);
            appName.setEffect(shadow);

            //welcome et son style
            Text welcome = new Text(5, 50, "Welcome To Your Space");
            Font fwelcome = Font.font("Georgia", 29);
            welcome.setFont(fwelcome);

            // les deux boutons
            DropShadow shadowa = new DropShadow(10, 3, 3, Color.gray(0));
            // bouton 1
            Button btn1 = new Button("Contacts Management");

            //son event
            btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
                btn1.setEffect(shadowa);

            });

            btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
                btn1.setEffect(null);

            });


            //bouton2
            Button btn2 = new Button("View My Contacts");
            //son event
            btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
                btn2.setEffect(shadowa);

            });

            btn2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
                btn2.setEffect(null);

            });
            
            btn1.setTextFill(Color.WHITE);
            btn1.setStyle("-fx-background-color:darkturquoise ; ");
            
            btn2.setTextFill(Color.WHITE);
            btn2.setStyle("-fx-background-color: darkturquoise; ");
           
            
            HBox buttonBox = new HBox(10);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.getChildren().addAll(btn1, btn2);

            //ajout des elements a la page
            centerBox.getChildren().addAll(appName, welcome, buttonBox);
            root.setCenter(centerBox);
            FlowPane p = new FlowPane();
            
            
            //aller vers la scene 2 :contact Management 
			btn1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {				
					
						//afficher une nouvelle fenetre
						Scene2 scene2 =new Scene2();
						contactsDAO dao = new contactsDAO(scene2);

						try {
							scene2.start(primaryStage);}
						catch (Exception e) {
							e.printStackTrace();//afficher lerreur
						}				
				}						
			});
			
			//aller vers la scene 3 :View contact  
			btn2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {				
					
						//afficher une nouvelle fenetre
						scene3 scene3 =new scene3();
						try {
							scene3.start(primaryStage);}
						catch (Exception e) {
							e.printStackTrace();//afficher lerreur
						}				
				}						
			});
            
            
            //si on veut quitter :
            primaryStage.setOnCloseRequest((EventHandler<WindowEvent>)new EventHandler<WindowEvent>() {
				public void handle(WindowEvent event) {
					event.consume();//si on ecrit pas cette methode meme si on clque sur NON , le prog va etre quitter
					fermerprog();
				}
			});
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //fonction fermer programme
    public void fermerprog() {
		//boite de dialoge confirmation
		
		Alert confirmer= new Alert(AlertType.CONFIRMATION);
		confirmer.setTitle("CONFIRMATION");
		confirmer.setContentText("voulez vous vraiment quitter ?");
		
		//changer les boutons ok et annuler:enlever les anciens et creation et lajout de nouveaux boutons
		
		confirmer.getButtonTypes().removeAll(ButtonType.OK,ButtonType.CANCEL);
		ButtonType btnOUI =new ButtonType("YES");
		ButtonType btnNON =new ButtonType("NO");
		
		confirmer.getButtonTypes().addAll(btnOUI,btnNON);
		

		
		Optional<ButtonType> resultat =confirmer.showAndWait();//stocker le resultat :ok ou cancel dans lobjet resultat 
		if (resultat.get()==btnOUI)
			System.exit(0);
	}

    public static void main(String[] args) {
        launch(args);
    }
}
