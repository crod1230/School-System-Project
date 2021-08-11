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
    
    @FXML private Button back;
    @FXML private Button viewDetails;
    @FXML private Label selectStudent;
    
    @FXML private ListView studentList;
    @FXML private ListView coursesTaken;
    
    @FXML private TextField name;
    @FXML private TextField age;
    @FXML private TextField grade;
    @FXML private TextField major;
    @FXML private TextField finalID;
    
    
    public void setFields() {
        
        Student selectedStudent = (Student) this.studentList.getSelectionModel().getSelectedItem();
        this.name.setText(selectedStudent.getName());
        this.age.setText(selectedStudent.age().toString());
        this.grade.setText(selectedStudent.getGrade());
        this.major.setText(selectedStudent.getMajor());
        this.finalID.setText(selectedStudent.getFinalID());

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
        
        ObservableList<Student> items = FXCollections.observableList(SchoolSystemProject.listOfStudents);
        studentList.setItems(items);
        
        ObservableList<Course> items2 = FXCollections.observableList(SchoolSystemProject.listOfCoursesTaking);
        coursesTaken.setItems(items2);
        
        selectStudent.setText("");
    }    
    
}
