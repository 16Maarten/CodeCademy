package Presentation.StudentUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentUpdateUI{

    
    public Parent getView(){
        GridPane layout = new GridPane();
        
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

        // VBox box = new VBox();

        // Scene scene = new Scene(layout,200,200);
        
        layout.add(name, 0, 0);
        layout.add(nameInput, 0, 1);
        layout.add(email, 0, 2);
        layout.add(emailInput, 0, 3);
        layout.add(birthDate, 0, 4);
        layout.add(birthDateInput, 0, 5);
        layout.add(gender, 0, 6);
        layout.add(genderInput, 0, 7);
        layout.add(address, 0, 8);
        layout.add(addressInput, 0, 9);
        layout.add(residence, 0, 10);
        layout.add(residenceInput, 0, 11);
        layout.add(country, 0, 12);
        layout.add(countryInput, 0, 13);
        layout.add(button, 0, 14);
        layout.add(backButton, 0, 15);

        return layout;
        
    }
    
}
