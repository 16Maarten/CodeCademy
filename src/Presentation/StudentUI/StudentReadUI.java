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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.Student;

public class StudentReadUI {

    private StudentManager manager;
    private List<Student> students;

    public StudentReadUI(StudentManager manager) {
        this.manager = manager;
    }

    public Parent getView() {

        VBox layout = new VBox();
        students = manager.getStudents();
        ArrayList<String> courseNames = new ArrayList();
        for (int i = 0; i < students.size(); i++) {
            courseNames.add(students.get(i).getEmail());
        }

        Label name = new Label("Select student email");
        Label studentsNameOutput = new Label();
        Label emailOutput = new Label();
        Label birthdayOutput = new Label();
        Label genderOutput = new Label();
        Label adressOutput = new Label();
        Label residenceOutput = new Label();
        Label countryOutput = new Label();
        Label postalCodeOutput = new Label();
        ComboBox studentsField = new ComboBox(FXCollections.observableArrayList(courseNames));
        studentsField.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        StudentUI studentUI = new StudentUI();
        backButton.setMaxWidth(Double.MAX_VALUE);
        Button infoButton = new Button("Info Student");
        infoButton.setMaxWidth(Double.MAX_VALUE);
        layout.getChildren().addAll(name, studentsField, infoButton, backButton);

        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(studentUI.getView());
        });

        infoButton.setOnAction((event) -> {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getEmail().equals(studentsField.getValue())) {
                    studentsNameOutput.setText("Name: " + students.get(i).getName());
                    emailOutput.setText("Email: " + students.get(i).getEmail());
                    birthdayOutput.setText("Birthday: " + students.get(i).getBirthDate());
                    genderOutput.setText("Gender: " + students.get(i).getGender());
                    adressOutput.setText("Adress: " + students.get(i).getAddress());
                    residenceOutput.setText("Residence: " + students.get(i).getResidence());
                    countryOutput.setText("Country: " + students.get(i).getCountry());
                    postalCodeOutput.setText("PostalCode: " + students.get(i).getPostalCode());
                }
            }

            layout.getChildren().clear();
            layout.getChildren().addAll(name, studentsField, studentsNameOutput, emailOutput, birthdayOutput, genderOutput, adressOutput, residenceOutput, countryOutput,postalCodeOutput, infoButton, backButton);
        });;

        return layout;

    }

}
