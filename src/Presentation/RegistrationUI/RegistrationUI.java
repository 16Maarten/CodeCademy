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


        layout.add(label, 0, 0);
        layout.add(create, 0, 1);
        layout.add(read, 0, 2);
        layout.add(update, 0, 3);
        layout.add(delete, 0, 4);
        layout.add(home, 0, 5);

        return layout;

        
    }
    
}
