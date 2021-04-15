package Presentation.OverviewsUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AverageProgressUI extends Application{

    @Override
    public void start(Stage windows) throws Exception {
        Label name = new Label("Selected course:");
        ComboBox comboBox = new ComboBox();
        Button courseButton = new Button("Get progress");
        Button backButton = new Button("Back");
        
        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(name, comboBox,courseButton, backButton);
        box.setSpacing(5);

        windows.setTitle("Average progress");

        windows.setScene(scene);
        windows.show();
        
    }
    
}
