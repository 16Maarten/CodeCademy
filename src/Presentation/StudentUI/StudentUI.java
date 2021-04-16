package Presentation.StudentUI;

import Presentation.HomeUI;
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

public class StudentUI{
    
    public Parent getView(){
        BorderPane layout = new BorderPane();
        
        Label label = new Label("Choose one of the options for the student class");
        Button create = new Button("Create");
        StudentCreateUI createUI = new StudentCreateUI();

        Button read = new Button("Read");
        StudentReadUI readUI = new StudentReadUI();

        Button update = new Button("Update");
        StudentUpdateUI updateUI = new StudentUpdateUI();

        Button delete = new Button("Delete");
        StudentDeleteUI deleteUI = new StudentDeleteUI();

        Button home = new Button("Return home");

        // layout.set(Pos.TOP_CENTER);
        // layout.setPadding(new Insets(10, 10, 10, 10));

        // VBox box = new VBox();
        // Scene scene = new Scene(box, 300, 300);
        
        // box.getChildren().addAll(label, create, read, update, delete, home);
        // box.setSpacing(5);

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
