/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nina
 */
public class CourseViewController implements Initializable {
    
    @FXML private Button back; 
    @FXML private Button viewDetails;
    @FXML private Label selectCourse;
    @FXML private ListView courseListView;
    @FXML private TextField courseName;
    @FXML private TextField courseSubject;
    @FXML private TextField courseNumber;
    @FXML private TextField courseCredit;

    //fields for scene switch
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    
    public void setFields() {
        
        Course selectedCourse = (Course)this.courseListView.getSelectionModel().getSelectedItem();
        this.courseName.setText(selectedCourse.getCourseName());
        this.courseSubject.setText(selectedCourse.getCourseSubj());
        this.courseNumber.setText(selectedCourse.getCourseNum());        
        this.courseCredit.setText(selectedCourse.getCredit().toString());
         
    }
    
    
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
        courseListView.setItems(items);
        
        selectCourse.setText("");
    }    
    
}
