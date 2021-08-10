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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nina
 */
public class CourseViewController implements Initializable {
    
    @FXML private Button back; 
    @FXML private ListView courseListView;
    @FXML private TextArea courseDetails; 
    @FXML private Button viewDetails;
            

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
        // TODO
    }    
    
}
