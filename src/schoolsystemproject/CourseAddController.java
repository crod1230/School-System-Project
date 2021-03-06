/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nina
 */
public class CourseAddController implements Initializable {
    
    @FXML private Button back;
    @FXML private Button removeCourse; 
    @FXML private Button addCourse;
    @FXML private Label selectCourse;
    @FXML private Label enterFields;
    @FXML private ListView courseList; 
    @FXML private TextField addName;
    @FXML private TextField addSubject;
    @FXML private TextField addNumber;
    @FXML private TextField addCredit; 
    
    private String courseName;
    private String courseSubject; 
    private String courseNumber; 
    private Integer courseCredit;
    
    
    @FXML
    public void addCourse() {
        
        if ((this.addName.getText().isEmpty() == true)||(this.addSubject.getText().isEmpty() == true)||(this.addNumber.getText().isEmpty() == true)||(this.addCredit.getText().isEmpty() == true)) {
            enterFields.setVisible(true);
        }
        else {
            enterFields.setVisible(false);
            
            //take all data from text fields 
            courseName = this.addName.getText().toString();
            courseSubject = this.addSubject.getText().toString();
            courseNumber = this.addNumber.getText().toString();
            courseCredit = Integer.parseInt(this.addCredit.getText().toString());
        
            //create new course object using data 
            Course newCourse = new Course(courseName, courseSubject, courseNumber, courseCredit);
        
            //add new object to list of courses
            SchoolSystemProject.listOfCourses.add(newCourse);
        
            //clear all text fields 
            this.addName.setText("");
            this.addSubject.setText("");
            this.addNumber.setText("");
            this.addCredit.setText("");
        
            ObservableList<Course> items = FXCollections.observableList(SchoolSystemProject.listOfCourses);
            courseList.setItems(items);
        }
     
    }
    
    
    public void removeCourse() {
        if (this.courseList.getSelectionModel().isEmpty() == true) {
            selectCourse.setVisible(true);
        }
        else {
            selectCourse.setVisible(false);
            Course selectedCourse = (Course) this.courseList.getSelectionModel().getSelectedItem();
            SchoolSystemProject.listOfCourses.remove(selectedCourse);
        
            ObservableList<Course> items = FXCollections.observableList(SchoolSystemProject.listOfCourses);
            courseList.setItems(items);
        }
    }
    
    
    //fields for switching scenes
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    //method to return to main scene 
    @FXML
    public void returnToMain(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene); 
        this.stage.show();
    }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Course> items = FXCollections.observableList(SchoolSystemProject.listOfCourses);
        courseList.setItems(items);
        
        selectCourse.setVisible(false);
        enterFields.setVisible(false);
    }    
    
}
