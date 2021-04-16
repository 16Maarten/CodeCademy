package Presentation.StudentUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentReadUI{

    public Parent getView() {

        BorderPane layout = new BorderPane();
        
        Label label = new Label("Students:");
        Button backButton = new Button("Back");

        VBox box = new VBox();
        box.getChildren().addAll(label, backButton);
        layout.setTop(box);
        

        return layout;
        
    }
    
}
