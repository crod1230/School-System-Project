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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
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
        
    }
    
    public void removeProfessor() {
        
    }
    
    public void addCourseToProfessor() {
        
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
        // TODO
    }    
    
}
