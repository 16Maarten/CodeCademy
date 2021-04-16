package Presentation.OverviewsUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OverviewsUI {
    
    public Parent getView(){
        BorderPane layout = new BorderPane();
        
        Label label = new Label("Choose one of the options for the overviews class");
        Button top3 = new Button("Top 3");
        Top3UI top3UI = new Top3UI();

        Button average = new Button("Average Progress");
        AverageProgressUI averageUI = new AverageProgressUI();

        Button course = new Button("Course progress");
        CourseProgressReadUI courseUI = new CourseProgressReadUI();

        Button number = new Button("Number students pass");
        NumberOfStudentsPassUI numberUI = new NumberOfStudentsPassUI();

        Button home = new Button("Return home");

        VBox box = new VBox();
        box.getChildren().addAll(label, top3, average, course, number, home);
        layout.setTop(box);

        top3.setOnAction((event) -> layout.setCenter(top3UI.getView()));
        average.setOnAction((event) -> layout.setCenter(averageUI.getView()));
        course.setOnAction((event) -> layout.setCenter(courseUI.getView()));
        number.setOnAction((event) -> layout.setCenter(numberUI.getView()));

        return layout;

        
    }
}
