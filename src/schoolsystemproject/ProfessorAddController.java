/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nina
 */
public class ProfessorAddController implements Initializable {
    
    @FXML private Button back;
    @FXML private Button removeProfessor;
    @FXML private Button addProfessor;
    @FXML private Button addCourse;
    @FXML private Label selectProfessor;
    @FXML private Label enterFields;
    @FXML private Label selectCourse;
    @FXML private ListView professorList;
    @FXML private ListView coursesAvailable;
    @FXML private TextField name;
    @FXML private DatePicker dob;
    @FXML private TextField edulvl;
    @FXML private TextField dpt;
    @FXML private TextField finalID;
    
   //fields for scene switch
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    //Fields for adding a professor 
    private String profName; 
    private LocalDate profDoB;
    private String profDpt;
    private String profEduLvl;
    private String profID; 
    
    
    public void addProfessor() {
        
        if ((this.name.getText().isEmpty() == true)||(this.dob.getValue() == null)||(this.edulvl.getText().isEmpty() == true)||(this.dpt.getText().isEmpty() == true)||(this.finalID.getText().isEmpty() == true)) {
            enterFields.setVisible(true);
        }
        else {
            enterFields.setVisible(false);
            
            //take data from text fields 
            this.profDoB = this.dob.getValue(); //gets local date from datePicker
            this.profName = this.name.getText().toString();
            this.profDpt = this.dpt.getText().toString();
            this.profEduLvl = this.edulvl.getText().toString();
            this.profID = this.finalID.getText().toString();
        
            //create new professor object with data 
            Professor newProf = new Professor(profName, profDoB, profDpt, profEduLvl, profID);
        
            //add professor object to ataic list of professors 
            SchoolSystemProject.listOfProfs.add(newProf);
        
            //clear all text fields 
            this.name.setText("");
            this.dob.getEditor().clear();
            this.edulvl.setText("");
            this.dpt.setText("");
            this.finalID.setText("");
        
            ObservableList<Professor> items = FXCollections.observableList(SchoolSystemProject.listOfProfs);
            professorList.setItems(items);
        }
        
    }
    
    public void removeProfessor() {
        if (this.professorList.getSelectionModel().isEmpty() == true) {
            selectProfessor.setVisible(true);
        }
        else {
            selectProfessor.setVisible(false);
            Professor selectedProfessor = (Professor) this.professorList.getSelectionModel().getSelectedItem();
            SchoolSystemProject.listOfProfs.remove(selectedProfessor);
        
            ObservableList<Professor> items = FXCollections.observableList(SchoolSystemProject.listOfProfs);
            professorList.setItems(items);
        }
    }
    
    
    public void addCourseToProfessor() {
        if (this.coursesAvailable.getSelectionModel().isEmpty() == true) {
            selectCourse.setVisible(true);
        }
        else {
            selectCourse.setVisible(false);
            //get selected professor and course 
            Professor selectedProfessor = (Professor) this.professorList.getSelectionModel().getSelectedItem();
            Course selectedCourse = (Course)this.coursesAvailable.getSelectionModel().getSelectedItem();
        
            //add selected course to selected professor coursesTaught
            selectedProfessor.addClass(selectedCourse);
        }
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
        
        ObservableList<Professor> items = FXCollections.observableList(SchoolSystemProject.listOfProfs);
        professorList.setItems(items);
        
        ObservableList<Course> items2 = FXCollections.observableList(SchoolSystemProject.listOfCourses);
        coursesAvailable.setItems(items2);
        
        selectProfessor.setVisible(false);
        selectCourse.setVisible(false);
        enterFields.setVisible(false);
    }    
    
}
