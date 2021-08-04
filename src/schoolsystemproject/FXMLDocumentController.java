/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Nina
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML private Button courses;
    @FXML private Button professors;
    @FXML private Button students;
            
    
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    @FXML
    public void switchToCourses(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("CourseAdd.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene); 
        this.stage.show();
    }
    
    @FXML
    public void switchToProfessors(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("ProfessorAdd.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene);
        this.stage.show();
    }
    
    @FXML
    public void switchToStudents(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("CourseAdd.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene);
        this.stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}
