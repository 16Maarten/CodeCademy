package Presentation.StudentUI;

import Application_Logic.StudentManager;
import Presentation.CourseUI.CourseUI;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.Student;

public class StudentDeleteUI {

    private StudentManager manager;
    private List<Student> students;

    public StudentDeleteUI(StudentManager manager) {
        this.manager = manager;
    }

    public Parent getView() {
        VBox layout = new VBox();
        students = manager.getStudents();
        ArrayList<String> studentNames = new ArrayList();
        for (int i = 0; i < students.size(); i++) {
            studentNames.add(students.get(i).getEmail());
        }

        Label name = new Label("Enter email");
        TextField emailInput = new TextField();
        Label message = new Label();
        Button deleteButton = new Button("Delete student");
        deleteButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        StudentUI studentUI = new StudentUI();
        layout.getChildren().addAll(name, emailInput, deleteButton, backButton, message);
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(studentUI.getView());
        });

        deleteButton.setOnAction((event) -> {
            String emailStudent = emailInput.getText();
            for (int i = 0; i < this.students.size(); i++) {
                if (!this.students.get(i).getEmail().equals(emailStudent)) {
                    message.setText("Wrong Email");
                } else {
                    boolean answer = manager.deleteStudent(emailStudent);
                    if (answer) {
                        message.setText("Deleted student: " + emailStudent);
                    } else {
                        message.setText("Something went wrong try again");
                    }
                }
            }
        });

        return layout;

    }

}
