package Presentation.OverviewsUI;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OverviewsUI {
    
    public Parent getView(){
        GridPane layout = new GridPane();
        
        Label label = new Label("Choose one of the options for the student class");
        Button top3 = new Button("Top 3");
        Button average = new Button("Average progress");
        Button number = new Button("Number students");
        Button course = new Button("Course progress");
        Button home = new Button("Return home");

        VBox box = new VBox();

        
        box.getChildren().addAll(label, top3, number, course, average, home);
        box.setSpacing(5);

        return layout;

        
    }
}
