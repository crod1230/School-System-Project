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
public class ProfessorViewController implements Initializable {
    
    @FXML private Button back;
    @FXML private Button viewDetails;
    @FXML private Label selectProfessor;
    @FXML private ListView professorList;
    @FXML private ListView coursesTaught;
    @FXML private TextField name;
    @FXML private TextField age;
    @FXML private TextField edulvl;
    @FXML private TextField dpt;
    @FXML private TextField finalID;
    
    //fields for scene switch
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    
    public void setFields() {
        
        Professor selectedProfessor = (Professor)this.professorList.getSelectionModel().getSelectedItem();
        this.name.setText(selectedProfessor.getName());
        this.age.setText(selectedProfessor.age().toString());
        this.edulvl.setText(selectedProfessor.getEduLvl());
        this.dpt.setText(selectedProfessor.getDpt());
        this.finalID.setText(selectedProfessor.getFinalID());

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
        
        ObservableList<Course> items2 = FXCollections.observableList(SchoolSystemProject.listOfCoursesTeaching);
        coursesTaught.setItems(items2);
        
        selectProfessor.setText("");
        
    }    
    
}
