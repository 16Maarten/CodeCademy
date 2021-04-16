package Presentation.RegistrationUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationUI{

    public Parent getView(){
        BorderPane layout = new BorderPane();
        
        Label label = new Label("Choose one of the options for the registration class");

        Button create = new Button("Create");
        RegistrationCreateUI createUI = new RegistrationCreateUI();

        Button read = new Button("Read");
        RegistrationReadUI readUI = new RegistrationReadUI();

        Button update = new Button("Update");
        RegistrationUpdateUI updateUI = new RegistrationUpdateUI();

        Button delete = new Button("Delete");
        RegistrationDeleteUI deleteUI = new RegistrationDeleteUI();

        Button home = new Button("Return home");


        // layout.setAlignment(Pos.TOP_CENTER);
        // layout.setPadding(new Insets(10, 10, 10, 10));
        
        // layout.add(label, 0, 0);
        // layout.add(create, 0, 1);
        // layout.add(read, 0, 2);
        // layout.add(update, 0, 3);
        // layout.add(delete, 0, 4);
        // layout.add(home, 0, 5);

        VBox box = new VBox();
        box.getChildren().addAll(label, create, read, update, delete, home);
        layout.setTop(box);

        create.setOnAction((event) -> layout.setCenter(createUI.getView()));
        read.setOnAction((event) -> layout.setCenter(readUI.getView()));
        update.setOnAction((event) -> layout.setCenter(updateUI.getView()));
        delete.setOnAction((event) -> layout.setCenter(deleteUI.getView()));

        return layout;

        
    }
    
}
