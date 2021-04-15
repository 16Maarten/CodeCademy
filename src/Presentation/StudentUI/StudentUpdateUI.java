package Presentation.StudentUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentUpdateUI extends Application{

    @Override
    public void start(Stage windows) throws Exception {
        Label name = new Label("Name");
        TextField nameInput = new TextField();

        Label email = new Label("Email");
        TextField emailInput = new TextField();

        Label birthDate = new Label("Birth date");
        TextField birthDateInput = new TextField();

        Label gender = new Label("Gender");
        TextField genderInput = new TextField();

        Label address = new Label("Address");
        TextField addressInput = new TextField();

        Label residence = new Label("Residence");
        TextField residenceInput = new TextField();

        Label country = new Label("Country");
        TextField countryInput = new TextField();

        Button button = new Button("Update");
        Button backButton = new Button("Back");

        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(name, nameInput, email, emailInput, birthDate, birthDateInput, gender, genderInput, address, addressInput, residence,
        residenceInput, country, countryInput, button, backButton);
        box.setSpacing(2);

        windows.setTitle("Student update");

        windows.setScene(scene);
        windows.show();
        
    }
    
}
