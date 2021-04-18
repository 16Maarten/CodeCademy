package Presentation.StudentUI;

import Application_Logic.StudentManager;
import TestsSrc.DateTools;
import TestsSrc.MailTools;
import TestsSrc.PostalCode;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class StudentCreateUI {

    private StudentManager manager;

    public StudentCreateUI(StudentManager manager) {
        this.manager = manager;
    }

    public Parent getView() {

        VBox layout = new VBox();

        Label name = new Label("Name");
        TextField nameInput = new TextField();

        Label email = new Label("Email");
        TextField emailInput = new TextField();

        Label birthDate = new Label("Birthday");
        DatePicker datePicker = new DatePicker();
        datePicker.setMaxWidth(Double.MAX_VALUE);

        Label gender = new Label("Gender");
        ComboBox genderField = new ComboBox(FXCollections.observableArrayList("M", "F"));
        genderField.setMaxWidth(Double.MAX_VALUE);
        Label address = new Label("Address");
        TextField addressInput = new TextField();

        Label residence = new Label("Residence");
        TextField residenceInput = new TextField();

        Label country = new Label("Country");
        TextField countryInput = new TextField();

        Label postalCode = new Label("PostalCode");
        TextField postalCodeInput = new TextField();

        Label formatMessage = new Label("");

        Button addButton = new Button("Add Student");
        addButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        StudentUI studentUI = new StudentUI();
        Label message = new Label();

        layout.getChildren().addAll(name, nameInput, email, emailInput, birthDate, datePicker, gender, genderField,
                address, addressInput, residence, residenceInput, country, countryInput, postalCode, postalCodeInput,
                addButton, backButton, message, formatMessage);
        layout.setSpacing(5);
        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(studentUI.getView());
        });

        addButton.setOnAction((event) -> {
            String nameStudent = nameInput.getText();
            String emailStudent = emailInput.getText();
            String birthdayStudent = String.valueOf(datePicker.getValue());
            String genderStudent = String.valueOf(genderField.getValue());
            String adressStudent = addressInput.getText();
            String residenceStudent = residenceInput.getText();
            String countryStudent = countryInput.getText();
            String postalCodeStudent = postalCodeInput.getText();
            PostalCode postalcode = new PostalCode();
            String postalCodeFormat = postalcode.FormatPostalCode(postalCodeStudent);
            MailTools mailTool = new MailTools(emailStudent);
            DateTools dateTools = new DateTools();
            String[] dates = birthdayStudent.split("-");
            int day = Integer.valueOf(dates[0]);
            int Month = Integer.valueOf(dates[1]);
            int Year = Integer.valueOf(dates[2]);
            if (mailTool.validateMailAddress()) {
                formatMessage.setText("Check the format of your email");
            } else if (dateTools.validateDate(day, Month, Year)) {
                formatMessage.setText("Check the format of birthday");
            } else {

                boolean answer = manager.addStudent(emailStudent, nameStudent, birthdayStudent, genderStudent,
                        adressStudent, residenceStudent, countryStudent, postalCodeFormat);
                if (answer) {
                    message.setText("Added student: " + nameStudent);
                } else {
                    message.setText("Something went wrong try again");
                }
            }
        });

        return layout;

    }

}
