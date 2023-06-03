package application;

import java.io.File;

import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swt.SWTFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.Printer.MarginType;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import javafx.print.PrinterJob;
import javafx.print.Printer;
import javafx.print.PageLayout;
import javafx.print.Printer.MarginType;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.transform.Translate;

public class scene4 {

	public static void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		VBox root4=new VBox();
	    
		Scene scene4 = new Scene(root4, 1280, 650);
		Scene2 Scene2=new Scene2();
		primaryStage.setScene(scene4);
		primaryStage.setTitle("View Contact");
		scene4.getStylesheets().add(("application.css"));

		
		
		
		String name = Scene2.FnameField.getText();
		Text text = new Text (5,50,name+"'s Profile");
		
		
		
		root4.setAlignment(Pos.TOP_CENTER);
		
        Font fonttext = Font.font("Georgia", 33);
        text.setFont(fonttext);
        text.setFill( Color.MEDIUMBLUE );
        DropShadow shadow = new DropShadow(6, 3, 3,Color.BLACK);
        text.setEffect(shadow);
        root4.setMargin(text, new Insets(50));
		
		GridPane grille = new GridPane();
		
        
		String number = Scene2.numField.getText();
		String email = Scene2.emailField.getText();
		String media = Scene2.mediaField.getText();
		
		String adress = Scene2.adressField.getText();
		String relation = Scene2.relationField.getText();
		String date = Scene2.dateField.getText();
		String note = Scene2.noteField.getText();
		
		
		Text textname = new Text (name);
		Text textnumber = new Text (number);
		Text textemail = new Text (email);
		Text textmedia = new Text (media);
		Text textadress = new Text (adress);
		Text textrelation = new Text (relation);
		Text textdate = new Text (date);
		Text textnote = new Text (note);
		
		
		Label FnameLabel = new Label("Full Name");
       
        Label numLabel = new Label("Number Phone");
        
        Label emailLabel = new Label("Email");
         
        Label mediaLabel = new Label("Social Media Profiles");
         
        Label adressLabel = new Label("Adress");
         
        Label relationLabel = new Label("Relationship");
        
        Label dateLabel = new Label("Important dates");
        
        Label noteLabel = new Label("Notes");
       
		grille.add(FnameLabel, 0, 0);
		grille.add(numLabel, 0, 1);
		grille.add(emailLabel, 0, 2);
		grille.add(mediaLabel, 0, 3);
		grille.add(adressLabel, 0, 4);
		grille.add(relationLabel, 0, 5);
		grille.add(dateLabel, 0, 6);
		grille.add(noteLabel, 0, 7);
		 
		String npoint = new String(":");
		Text npoints = new Text(npoint);
		grille.add(npoints, 1, 0);
		
		Text npoins = new Text(npoint);
		
		grille.add(npoins, 1, 1);
		
		Text npoi = new Text(npoint);
		grille.add(npoi, 1, 2);
		
		Text npoi1 = new Text(npoint);
		grille.add(npoi1, 1, 3);
		
		Text npoint2 = new Text(npoint);
		grille.add(npoint2, 1, 4);
		
		Text npoint3 = new Text(npoint);
		grille.add(npoint3, 1, 5);
		
		Text npoint4 = new Text(npoint);
		grille.add(npoint4, 1, 6);
		
		Text npoint5 = new Text(npoint);
		grille.add(npoint5, 1, 7);
		
		
		grille.add(textname, 2, 0);
		grille.add(textnumber, 2, 1);
		grille.add(textemail, 2, 2);
		grille.add(textmedia, 2, 3);
		grille.add(textadress, 2, 4);
		grille.add(textrelation, 2, 5);
		grille.add(textdate, 2, 6);
		grille.add(textnote, 2, 7);
		
		
		
		
		grille.setAlignment(Pos.CENTER);
		
		grille.setVgap(40);
		grille.setHgap(60);
		
		
		Button returne = new Button("return");
		Button print = new Button("print now");
		
		HBox hbox1 = new HBox (10);
		grille.add(hbox1, 2, 8);
		hbox1.getChildren().addAll(returne , print);
		root4.getChildren().addAll(text,grille);
		hbox1.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		//le clique sur le bouton retour
		 DropShadow shadowa = new DropShadow(10, 3, 3, Color.gray(0));
				returne.setOnAction((EventHandler<ActionEvent>)new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						try {
							Scene2.start(primaryStage);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}								
				});
				returne.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
					returne.setEffect(shadowa);

		         });

				returne.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
					returne.setEffect(null);

		         });
				
				print.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent ev) -> {
					print.setEffect(shadowa);

		         });

				print.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ev) -> {
					print.setEffect(null);

		         });
				
				print.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		                // Code pour l'impression de la scène
		                 printScene(root4,primaryStage);
		            }
		        });
				returne.setId("returne");
				print.setId("print");
			

				primaryStage.show();
		
	}




private static void printScene(Node content, Stage primaryStage) {
    PrinterJob printerJob = PrinterJob.createPrinterJob();

    if (printerJob != null && printerJob.showPrintDialog(primaryStage)) {
        PageLayout pageLayout = printerJob.getJobSettings().getPageLayout();

        // Calculate the printable area size
        double printableWidth = pageLayout.getPrintableWidth();
        double printableHeight = pageLayout.getPrintableHeight();

        // Create a snapshot of the content
        SnapshotParameters snapshotParams = new SnapshotParameters();
        snapshotParams.setFill(Color.TRANSPARENT);
        WritableImage snapshot = content.snapshot(snapshotParams, null);

        // Calculate the scale factor for fitting the content within the printable area
        double scaleX = printableWidth / snapshot.getWidth();
        double scaleY = printableHeight / snapshot.getHeight();
        double scale = Math.min(scaleX, scaleY);

        // Calculate the position for centering the content within the printable area
        double offsetX = (printableWidth - snapshot.getWidth() * scale) / 2;
        double offsetY = (printableHeight - snapshot.getHeight() * scale) / 2;

        // Create a transformation to scale and position the content
        Transform transform = new Translate(offsetX, offsetY).createConcatenation(new Scale(scale, scale));

        // Apply the transformation to the content
        content.getTransforms().add(transform);
        Button printButton = (Button) primaryStage.getScene().lookup("#print");
        printButton.setVisible(false);
        Button returnButton = (Button) primaryStage.getScene().lookup("#returne");
        returnButton.setVisible(false);

        // Print the page
        boolean success = printerJob.printPage(content);

        if (success) {
            printerJob.endJob();
        }

        // Remove the transformation from the content
        content.getTransforms().remove(transform);
        printButton.setVisible(true);
        returnButton.setVisible(true);


    }
}









	

}
