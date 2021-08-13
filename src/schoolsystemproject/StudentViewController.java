/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nina
 */
public class StudentViewController implements Initializable {
    
    //Buttons
    @FXML private Button back;
    @FXML private Button viewDetails;
    @FXML private Button removeCourse;
    //Labels
    @FXML private Label selectStudent;
    @FXML private Label selectCourse;
    //Lists
    @FXML private ListView studentList;
    @FXML private ListView coursesTaken;
    //TextFields
    @FXML private TextField name;
    @FXML private TextField age;
    @FXML private TextField grade;
    @FXML private TextField major;
    @FXML private TextField finalID;
    @FXML private TextField creditHours;
    
    //Set fields when viewDetails button is pushed 
    public void setFields() {
        
        if (this.studentList.getSelectionModel().isEmpty() == true) {
            selectStudent.setVisible(true);
        }
        else {
            selectStudent.setVisible(false);
            Student selectedStudent = (Student) this.studentList.getSelectionModel().getSelectedItem(); //get selected student
            this.name.setText(selectedStudent.getName()); //set name textfield to selected student name 
            this.age.setText(selectedStudent.age().toString()); //set age textfield to selected student based calculated from dob 
            this.grade.setText(selectedStudent.getGrade()); //set grade textfield to selected student grade 
            this.major.setText(selectedStudent.getMajor()); //set major textfield to selected student major
            this.finalID.setText(selectedStudent.getFinalID()); //set final ID textfield to selected student finalID
            this.creditHours.setText(selectedStudent.getCreditHours().toString()); //set credit hours textfield to selected student credit hours based on coursesTaking
            ObservableList<Course> courseItems = FXCollections.observableList(selectedStudent.getCoursesTaking()); //convert ArrayList to ObservableList
            this.coursesTaken.setItems(courseItems); //set coursesTaken list to selected student courses taken
        }
    }
    
    //Removes a course object from coursesTaken list when removeCourse button is pushed 
    public void removeCourseTaken() {
        if (this.coursesTaken.getSelectionModel().isEmpty() == true) {
            selectCourse.setVisible(true);
        }
        else {
            selectCourse.setVisible(false);
            
            //gets selected student and course objects
            Student selectedStudent = (Student) this.studentList.getSelectionModel().getSelectedItem(); 
            Course selectedCourse = (Course) this.coursesTaken.getSelectionModel().getSelectedItem(); 
        
            //removes selected course object from selected student's coursesTaken list
            selectedStudent.removeCourse(selectedCourse); 
        
            //updates the coursesTaking list 
            ObservableList<Course> courseItems = FXCollections.observableList(selectedStudent.getCoursesTaking());
            this.coursesTaken.setItems(courseItems);
        
            //takes back credit hours from removed course 
            this.creditHours.setText(selectedStudent.getCreditHours().toString());
        }
    }
    
    
    //fields for scene switch
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
        
        //initialize lists
        ObservableList<Student> items = FXCollections.observableList(SchoolSystemProject.listOfStudents);
        studentList.setItems(items);
        
        ObservableList<Course> items2 = FXCollections.observableList(SchoolSystemProject.listOfCoursesTaking);
        coursesTaken.setItems(items2);
        
        //initialize labels as blank 
        selectStudent.setVisible(false);
        selectCourse.setVisible(false);
    }    
    
}
