package Presentation.CourseUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseUpdateUI extends Application{

    @Override
    public void start(Stage windows){
        Label courseName = new Label("Course name");
        TextField courseNameInput = new TextField();

        Label contentId = new Label("Content item id");
        TextField contentIdInput = new TextField();

        Label subject = new Label("Subject");
        TextField subjectInput = new TextField();

        Label introText = new Label("Intro text");
        TextField introTextInput = new TextField();

        Label difficulty = new Label("Difficulty indicator");
        TextField difficultyInput = new TextField();


        Button button = new Button("Update");
        Button backButton = new Button("Back");

        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(courseName, courseNameInput, contentId, contentIdInput, subject, subjectInput, introText, introTextInput
        , difficulty, difficultyInput,button, backButton);
        box.setSpacing(2);

        windows.setTitle("Course update");

        windows.setScene(scene);
        windows.show();
        
    }
    
}
