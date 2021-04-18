package Application_Logic;

import DataLayer.DAOFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import person.PercentageWatched;
import person.Registration;
import products.Course;
import products.Webcast;
import products.Module;

public class RegistrationManager {

    private List<Registration> registrations;
    private DAOFactory daoFactory;

    public RegistrationManager(DAOFactory daoFactory) {
        this.registrations = daoFactory.createDAORegistration().findRegistration();
        this.daoFactory = daoFactory;
        addPercentageWatched(this.registrations);
    }

    public boolean deleteRegistration(String courseName, String email, String registrationDate) {
        for (int i = 0; i < this.registrations.size(); i++) {
            System.out.println(this.registrations.get(i).getCursusName());
            if (this.registrations.get(i).getCursusName().equals(courseName) && this.registrations.get(i).getEmail().equals(email) && this.registrations.get(i).getRegistrationDate().equals(registrationDate)) {
                System.out.println(this.registrations.get(i));
                PercentageWatchedManager percentageWatchedManager = new PercentageWatchedManager(this.daoFactory);
                List<Integer> contentIds = new ArrayList();
                CourseManager courseManager = new CourseManager(this.daoFactory);
                List<Course> courses = courseManager.getCourses();
                List<Module> modules;
                List<Webcast> webcasts;
                for (int j = 0; j < courses.size(); j++) {
                    if (courses.get(j).getCursusName().equals(courseName)) {
                        modules = courses.get(j).getModuleList();
                        webcasts = courses.get(j).getWebcastList();
                        for (int k = 0; k < modules.size(); k++) {
                            contentIds.add(modules.get(k).getId());
                        }

                        for (int k = 0; k < webcasts.size(); k++) {
                            contentIds.add(webcasts.get(k).getId());
                        }
                    }
                }
                List<PercentageWatched> percentageWatched = this.registrations.get(i).getPercentageWatched();
                for (int j = 0; j < contentIds.size(); j++) {
                    if (percentageWatched.get(j).getEmail().equals(registrations.get(i).getEmail()) && percentageWatched.get(j).getPercentage() == contentIds.get(j)) {
                        percentageWatched.remove(percentageWatched.get(j));
                        this.registrations.get(j).setPercentageWatched(percentageWatched);
                    }
                    percentageWatchedManager.deletePercentageWatched(registrations.get(i).getEmail(), contentIds.get(j));
                }
                boolean answer = this.daoFactory.removeDAORegistration(this.registrations.get(i));
                this.registrations.remove(this.registrations.get(i));

                return answer;
            }
        }
        return false;
    }

    public boolean addRegistration(String registrationDate, String email, String cursusName) {
        PercentageWatchedManager percentageWatchedManager = new PercentageWatchedManager(this.daoFactory);
        List<Integer> contentIds = new ArrayList();
        CourseManager courseManager = new CourseManager(this.daoFactory);
        List<Course> courses = courseManager.getCourses();
        List<Module> modules;
        List<Webcast> webcasts;


        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCursusName().equals(cursusName)) {
                modules = courses.get(i).getModuleList();
                webcasts = courses.get(i).getWebcastList();
                for (int k = 0; k < modules.size(); k++) {
                    contentIds.add(modules.get(k).getId());
                }

                for (int k = 0; k < webcasts.size(); k++) {
                    contentIds.add(webcasts.get(k).getId());
                }
            }
        }

        for (int i = 0; i < contentIds.size(); i++) {
            percentageWatchedManager.addPercentageWatched(0, email, contentIds.get(i));
        }

        this.registrations.add(new Registration(registrationDate, email, cursusName));
        return this.daoFactory.addDAORegistration(new Registration(registrationDate, email, cursusName));
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    private void addPercentageWatched(List<Registration> registrations) {
        List<Integer> contentIds = new ArrayList();
        CourseManager courseManager = new CourseManager(this.daoFactory);
        List<Course> courses = courseManager.getCourses();
        List<Module> modules;
        List<Webcast> webcasts;
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < registrations.size(); j++) {
                if (courses.get(i).getCursusName().equals(registrations.get(j).getCursusName())) {
                    modules = courses.get(i).getModuleList();
                    webcasts = courses.get(i).getWebcastList();
                    for (int k = 0; k < modules.size(); k++) {
                        contentIds.add(modules.get(k).getId());
                    }

                    for (int k = 0; k < webcasts.size(); k++) {
                        contentIds.add(webcasts.get(k).getId());
                    }
                }
            }
        }
        PercentageWatchedManager percentageWatchedManager = new PercentageWatchedManager(this.daoFactory);
        List<PercentageWatched> percentageWatched = percentageWatchedManager.getPercentageWatched();
        for (int i = 0; i < registrations.size(); i++) {
            List<PercentageWatched> percentageWatchedRegistration = new ArrayList<>();
            for (int j = 0; j < percentageWatched.size(); j++) {
                for (int k = 0; k < contentIds.size(); k++) {
                    if (registrations.get(i).getEmail().equals(percentageWatched.get(j).getEmail()) && contentIds.get(k).equals(percentageWatched.get(j).getContentItemId())) {
                        percentageWatchedRegistration.add(percentageWatched.get(j));
                    }
                }
            }
            registrations.get(i).setPercentageWatched(percentageWatchedRegistration);
        }
    }

}
