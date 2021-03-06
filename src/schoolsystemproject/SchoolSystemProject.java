/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nina
 */
public class SchoolSystemProject extends Application {
    
    static List<Professor> listOfProfs;
    static List<Course> listOfCoursesTeaching;
    static List<Student> listOfStudents;
    static List<Course> listOfCoursesTaking;
    static List<Course> listOfCourses;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        listOfProfs = new ArrayList<>();
        listOfCoursesTeaching = new ArrayList<>();
        listOfStudents = new ArrayList<>();
        listOfCoursesTaking = new ArrayList<>();
        listOfCourses = new ArrayList<>();
        
        launch(args);
    }
    
}
