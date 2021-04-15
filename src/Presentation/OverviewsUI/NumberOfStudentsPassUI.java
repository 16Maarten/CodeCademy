package Presentation.OverviewsUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberOfStudentsPassUI extends Application{

    @Override
    public void start(Stage windows) {
        Label name = new Label("Course:");
        ComboBox comboBox = new ComboBox();

        Button getButton = new Button("Get amount");
        Button backButton = new Button("Back");
        
        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(name, backButton);
        box.setSpacing(5);

        windows.setTitle("Number of students pass");

        windows.setScene(scene);
        windows.show();
        
    }
    
}
