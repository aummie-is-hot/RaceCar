
package carracingproject.fxcore;
/*
By: <Aum markandey>
Date: 2025-10-16
Program Details: <Drag racers main menu controller>
*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class FXMLControllerMenu implements Initializable {
     @FXML
    private Button btnQuit;
    @FXML
    private Button btnSettings;

    @FXML
    private Button btnStart;

    @FXML
    private Label lblOut;

    @FXML
    private Button btnCustimize;
    MediaPlayer player;
    @FXML
    void btnQuitA(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnCuztimizeA(ActionEvent event) {
        try {
            MainApp.setRoot("customize", "Drag Racers");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void btnSettingA(ActionEvent event) {
        try {
            MainApp.setRoot("setting", "Drag Racers");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @FXML
    void btnStartA(ActionEvent event) {
        try {
            MainApp.setRoot("primary", "Drag Racers");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
        

}
