/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
public class StudentAddController implements Initializable {
    
    @FXML private Button back;
    @FXML private Button removeStudent;
    @FXML private Button addStudent;
    @FXML private Button addCourse;
    
    @FXML private Label selectStudent;
    @FXML private Label enterFields;
    @FXML private Label selectCourse;
    
    @FXML private ListView studentList;
    @FXML private ListView coursesAvailable;
    
    @FXML private TextField name;
    @FXML private DatePicker dob;
    @FXML private TextField grade;
    @FXML private TextField major;
    @FXML private TextField finalID;
    
    
    //fields for switching scene 
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    //Fields for adding a professor 
    private String studentName; 
    private LocalDate studentDoB;
    private String studentGrade;
    private String studentMajor;
    private String studentID; 
    
    
    
    public void addStudent() {
        
        //take data from text fields 
        this.studentDoB = this.dob.getValue(); //gets local date from datePicker
        this.studentName = this.name.getText().toString();
        this.studentGrade = this.grade.getText().toString();
        this.studentMajor = this.major.getText().toString();
        this.studentID = this.finalID.getText().toString();
        
        
        //create new student object using data 
        Student newStudent = new Student(studentName, studentDoB, studentGrade, studentMajor, studentID);
        
        
        //add student object to static list of students
        SchoolSystemProject.listOfStudents.add(newStudent);
        
        
        //clear all text fields 
        this.name.setText("");
        this.dob.getEditor().clear();
        this.grade.setText("");
        this.major.setText("");
        this.finalID.setText("");
        
        ObservableList<Student> items = FXCollections.observableList(SchoolSystemProject.listOfStudents);
        studentList.setItems(items);
        
    }
    
    
    public void removeStudent(ActionEvent event) {
//        if ()
//        SchoolSystemProject.listOfStudents.remove(dob)
    }
    
    public void addCoursetoStudent(ActionEvent selectedCourse) {
        
    }
    
    
    
    
    
    
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
        
        ObservableList<Student> items = FXCollections.observableList(SchoolSystemProject.listOfStudents);
        studentList.setItems(items);
        
        ObservableList<Course> items2 = FXCollections.observableList(SchoolSystemProject.listOfCourses);
        coursesAvailable.setItems(items2);
        
        selectStudent.setText("");
        selectCourse.setText("");
        enterFields.setText("");
        
    }    
    
}
