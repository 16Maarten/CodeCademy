package Presentation.OverviewsUI;

import Application_Logic.CourseManager;
import Application_Logic.PercentageWatchedManager;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.PercentageWatched;
import products.Course;
import products.Webcast;
import products.Module;

public class Top3UI {

    PercentageWatchedManager percentageWatchedManager;
    private CourseManager courseManager;
    private List<Course> courses;
    private List<Integer> avarageWebcasts;
    private List<Integer> topWebcasts;
    private List<Webcast> webcasts;

    public Top3UI(CourseManager courseManager, PercentageWatchedManager percentageWatchedManager) {
        this.percentageWatchedManager = percentageWatchedManager;
        this.courseManager = courseManager;
    }

    public Parent getView() {
        this.courses = courseManager.getCourses();
        System.out.println(this.courses.size());
        for (int i = 0; i < courses.size(); i++) {
            List<Webcast> webcasts2;
            if (!this.courses.get(i).getWebcastList().isEmpty()) {
                webcasts2 = this.courses.get(i).getWebcastList();
                System.out.println(webcasts2.get(0));
                System.out.println(webcasts2.get(1));
                this.webcasts.add(webcasts2.get(0));
                this.webcasts.add(webcasts2.get(1));
            }
        }

        for (int i = 0; i < this.webcasts.size(); i++) {
            this.avarageWebcasts.add(avarageContent(this.webcasts.get(i).getId()));
        }
        Label top3 = new Label("Top 3");
        Label webcast1 = new Label();
        Label webcast2 = new Label();
        Label webcast3 = new Label();
        int highestWebcast = calcHighestWebcast(this.avarageWebcasts);
        webcast1.setText("1. " + this.webcasts.get(this.topWebcasts.get(0)).getTitle() + " " + highestWebcast);
        this.avarageWebcasts.remove(this.topWebcasts.get(0));
        int secondHighestWebcast = calcHighestWebcast(this.avarageWebcasts);
        webcast2.setText("1. " + this.webcasts.get(this.topWebcasts.get(0)).getTitle() + " " + secondHighestWebcast);
        this.avarageWebcasts.remove(this.topWebcasts.get(0));
        int thirdHighestWebcast = calcHighestWebcast(this.avarageWebcasts);
        webcast3.setText("1. " + this.webcasts.get(this.topWebcasts.get(0)).getTitle() + " " + thirdHighestWebcast);
        this.avarageWebcasts.remove(this.topWebcasts.get(0));

        VBox layout = new VBox();
        layout.getChildren().addAll(top3, webcast1, webcast2, webcast3);
        Button backButton = new Button("Back");
        backButton.setMaxWidth(Double.MAX_VALUE);
        OverviewsUI overviewsUI = new OverviewsUI();
        layout.setSpacing(5);

        backButton.setOnAction((event) -> {
            layout.getChildren().clear();
            layout.getChildren().add(overviewsUI.getView());
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

    private int calcHighestWebcast(List<Integer> list) {
        this.topWebcasts.clear();
        int HighestNumber = list.get(0);
        this.topWebcasts.add(0);
        for (int i = 1; i < list.size(); i++) {
            if (HighestNumber < list.get(i)) {
                this.topWebcasts.clear();
                this.topWebcasts.add(i);
                HighestNumber = list.get(i);
            }
        }
        return HighestNumber;
    }
}
