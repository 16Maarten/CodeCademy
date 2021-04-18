package Presentation.OverviewsUI;

import Application_Logic.CourseManager;
import Application_Logic.PercentageWatchedManager;
import Application_Logic.RegistrationManager;
import Presentation.RegistrationUI.RegistrationUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.PercentageWatched;
import products.Course;
import products.Webcast;
import products.Module;

public class AverageProgressUI {

    PercentageWatchedManager percentageWatchedManager;
    private CourseManager courseManager;
    private List<Course> courses;
    private List<Module> modules;
    private List<Webcast> webcasts;

    public AverageProgressUI(CourseManager courseManager, PercentageWatchedManager percentageWatchedManager) {
        this.percentageWatchedManager = percentageWatchedManager;
        this.courseManager = courseManager;
    }

    public Parent getView() {
        courses = courseManager.getCourses();
        ArrayList<String> courseNames = new ArrayList();
        for (int i = 0; i < courses.size(); i++) {
            courseNames.add(courses.get(i).getCursusName());
        }

        VBox layout = new VBox();

        Label course = new Label("Choose course");
        Label module1 = new Label();
        Label module2 = new Label();
        Label webcast1 = new Label();
        Label webcast2 = new Label();
        Label module1Answer = new Label();
        Label module2Answer = new Label();
        Label webcast1Answer = new Label();
        Label webcast2Answer = new Label();

        ComboBox coursesField = new ComboBox(FXCollections.observableArrayList(courseNames));
        coursesField.setMaxWidth(Double.MAX_VALUE);

        Button getInfoButton = new Button("Get Course Information");
        getInfoButton.setMaxWidth(Double.MAX_VALUE);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        OverviewsUI overviewsUI = new OverviewsUI();
        Label message = new Label();

        layout.getChildren().addAll(course, coursesField, getInfoButton, backButton, message);
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(overviewsUI.getView());
        });

        getInfoButton.setOnAction((event) -> {
            String courseName = String.valueOf(coursesField.getValue());
            for (int i = 0; i < courses.size(); i++) {
                if (this.courses.get(i).getCursusName().equals(courseName)) {
                    this.modules = this.courses.get(i).getModuleList();
                    this.webcasts = this.courses.get(i).getWebcastList();
                }
            }
            module1.setText(this.modules.get(0).getTitle());
            module2.setText(this.modules.get(1).getTitle());
            module1Answer.setText(String.valueOf(avarageContent(this.modules.get(0).getId()))+"%");
            module2Answer.setText(String.valueOf(avarageContent(this.modules.get(1).getId()))+"%");
            webcast1.setText(this.webcasts.get(0).getTitle());
            webcast2.setText(this.webcasts.get(1).getTitle());
            webcast1Answer.setText(String.valueOf(avarageContent(this.webcasts.get(0).getId()))+"%");
            webcast2Answer.setText(String.valueOf(avarageContent(this.webcasts.get(1).getId()))+"%");
            layout.getChildren().clear();
            layout.getChildren().addAll(course, coursesField, module1, module1Answer, module2, module2Answer, webcast1, webcast1Answer, webcast2, webcast2Answer, getInfoButton, backButton, message);
        });

        return layout;

    }

    private int avarageContent(int contentId) {
        List<PercentageWatched> perncentageWatched = this.percentageWatchedManager.getPercentageWatched();
        int number = 0;
        int answer = 0;
        for (int i = 0; i < perncentageWatched.size(); i++) {
            if (perncentageWatched.get(i).getContentItemId() == contentId) {
                answer = answer + perncentageWatched.get(i).getPercentage();
                number++;
            }
        }
        return answer / number;
    }

}
