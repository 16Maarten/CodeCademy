package Presentation.CourseUI;


import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CourseCreateUI{

    
    public Parent getView(){
        GridPane layout = new GridPane();
        
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


        Button button = new Button("Add");
        Button backButton = new Button("Back");

        // VBox box = new VBox();

        // Scene scene = new Scene(box,200,200);

        layout.add(courseName, 0,0);
        layout.add(courseNameInput, 0,1);
        layout.add(contentId, 0,2);
        layout.add(contentIdInput, 0,3);
        layout.add(subject, 0,4);
        layout.add(subjectInput, 0,5);
        layout.add(introText, 0,6);
        layout.add(introTextInput, 0,7);
        layout.add(difficulty, 0,8);
        layout.add(difficultyInput, 0,9);
        layout.add(button, 0,10);
        layout.add(backButton, 0,11);

        return layout;
        
    }
    
}
