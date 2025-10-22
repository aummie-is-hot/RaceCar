
package carracingproject.fxcore;

/*
By: Aum Markandey
Date: 2025-10-16
Program Details: <Setting fxml controller for drag racers allowing you to change settings>
*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FXMLControllerSettings implements Initializable {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnBackgroundMusic;

    @FXML
    private Button btnSoundEffects;

    @FXML
    void btnBackA(ActionEvent event) {
        try {
            MainApp.setRoot("menu","Drag Racers");
        } catch (Exception e) {
            
        }
    }



    @FXML
    void btnBackgroundMusicA(ActionEvent event) {
        if (MainApp.backgroundmusicon == true){
            btnBackgroundMusic.setStyle("-fx-background-color: red;");
            MainApp.backgroundmusicon = false;
            MainApp.Backgroundplayer.stop();
            
        }
        else {
            btnBackgroundMusic.setStyle("-fx-background-color: green;");
            MainApp.backgroundmusicon = true;
            MainApp.Backgroundplayer.play();
        }
        
        
        
    }

    @FXML
    void btnSoundEffectsA(ActionEvent event) {
        if (MainApp.soundeffectson == 0){
            btnSoundEffects.setStyle("-fx-background-color: red;");
            MainApp.soundeffectson = 1;
        }
        else {
            btnSoundEffects.setStyle("-fx-background-color: green;");
            MainApp.soundeffectson = 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (MainApp.soundeffectson == 1){
            btnSoundEffects.setStyle("-fx-background-color: red;");
        }
        else if (MainApp.backgroundmusicon == false){
            btnBackgroundMusic.setStyle("-fx-background-color: red;");
        }

        

    }

}
