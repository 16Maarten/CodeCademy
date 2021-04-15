package Presentation.RegistrationUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationUI{

    public Parent getView(){
        GridPane layout = new GridPane();
        
        Label label = new Label("Choose one of the options for the registration class");
        Button create = new Button("Create");
        Button read = new Button("Read");
        Button update = new Button("Update");
        Button delete = new Button("Delete");
        Button home = new Button("Return home");

        VBox box = new VBox();

        
        box.getChildren().addAll(label, create, read, update, delete, home);
        box.setSpacing(5);

        return layout;

        
    }
    
}
