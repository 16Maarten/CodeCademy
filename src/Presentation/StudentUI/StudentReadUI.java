package Presentation.StudentUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentReadUI extends Application{

    @Override
    public void start(Stage windows) throws Exception {
        Label name = new Label("Students:");
        Button backButton = new Button("Back");
        
        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(name, backButton);
        box.setSpacing(5);

        windows.setTitle("Students");

        windows.setScene(scene);
        windows.show();
        
    }
    
}
