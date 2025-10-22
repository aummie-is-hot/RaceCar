
package carracingproject.fxcore;

/*
By: <Aum Markandey>
Date: 2025-10-16
Program Details: <The main part of the game that allows you to bet on a car to win in a drag race>
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

public class FXMLControllerCarCustom implements Initializable {
    @FXML
    private Button btnApplyGolden;
    MediaPlayer player;
    @FXML
    private Button btnApplyLimo;

    @FXML
    private Button btnApplyNormal;

    @FXML
    private Button btnApplyRace;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBackgroundA;

    @FXML
    private Label lblOut;

    @FXML
    private Label lblOut1;

    @FXML
    private Label lblOut11;

    @FXML
    private Label lblOut12;

    @FXML
    private Label lblOut121;

    @FXML
    private Label lblOut122;

    @FXML
    private Label lblOut123;

    @FXML
    private Label lblOut13;

    @FXML
    private Label lblOut14;

    @FXML
    private Label lblUnlockUpgrade;

    @FXML
    void btnApplyGoldenA(ActionEvent event) {
        if (MainApp.money >=15000){
            if (MainApp.goldenCar == 0) {
            MainApp.RaceCar = 0;
            MainApp.normalCar = 0;
            MainApp.Limo = 0;
            MainApp.goldenCar = 1;
            btnApplyRace.setDisable(false);
            btnApplyNormal.setDisable(false);
            btnApplyLimo.setDisable(false);
            btnApplyGolden.setDisable(true);
            MainApp.money = MainApp.money - 15000;
            player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
            player.play();
        }
        } else {
            player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
      player.play();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Insufficient Funds");
            alert.setHeaderText(null);
            alert.setContentText("You need $15,000 to unlock the Golden Car!");
            alert.showAndWait();
            
        }
    }

    @FXML
    void btnApplyLimoA(ActionEvent event) {
         if (MainApp.money >=5000){
            if (MainApp.Limo == 0) {
            MainApp.RaceCar = 0;
            MainApp.normalCar = 0;
            MainApp.Limo = 1;
            MainApp.goldenCar = 0;
            btnApplyRace.setDisable(false);
            btnApplyNormal.setDisable(false);
            btnApplyLimo.setDisable(true);
            btnApplyGolden.setDisable(false);
            MainApp.money = MainApp.money - 5000;
            player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
            player.play();
        }
         }else {
            player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
      player.play();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Insufficient Funds");
            alert.setHeaderText(null);
            alert.setContentText("You need $5000 to unlock the Limo!");
            alert.showAndWait();
            
        }
        
    }

    @FXML
    void btnApplyNormalA(ActionEvent event) {
        
            if (MainApp.normalCar == 0) {
            MainApp.RaceCar = 0;
            MainApp.normalCar = 1;
            MainApp.Limo = 0;
            MainApp.goldenCar = 0;
            btnApplyRace.setDisable(false);
            btnApplyNormal.setDisable(true);
            btnApplyLimo.setDisable(false);
            btnApplyGolden.setDisable(false);
            player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
            player.play();
        }
       
        
        
    }

    @FXML
    void btnApplyRaceA(ActionEvent event) {
        
        if (MainApp.upgradeLuck == 1) {
            MainApp.RaceCar = 1;
            MainApp.normalCar = 0;
            MainApp.Limo = 0;
            MainApp.goldenCar = 0;
            lblUnlockUpgrade.setText("Free");
            btnApplyRace.setDisable(true);
            btnApplyNormal.setDisable(false);
            btnApplyLimo.setDisable(false);
            btnApplyGolden.setDisable(false);
            player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
            player.play();
            
        }
        
        else {
            player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
      player.play();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Insufficient Funds");
            alert.setHeaderText(null);
            alert.setContentText("You need to unlock the luck upgrade to use this car!");
            alert.showAndWait();
            
    }
    }

    @FXML
    void btnBackA(ActionEvent event) {
        try {
            MainApp.setRoot("menu","Drag Racer");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void btnBackgroundA(ActionEvent event) {
        try {
            MainApp.setRoot("customize","Customize");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (MainApp.RaceCar == 1 && MainApp.upgradeLuck == 1) {
            MainApp.RaceCar = 1;
            MainApp.normalCar = 0;
            MainApp.Limo = 0;
            MainApp.goldenCar = 0;
            lblUnlockUpgrade.setText("Free");
            btnApplyRace.setDisable(true);
            btnApplyNormal.setDisable(false);
            btnApplyLimo.setDisable(false);
            btnApplyGolden.setDisable(false);
        }
        if (MainApp.normalCar == 1) {
            MainApp.RaceCar = 0;
            MainApp.normalCar = 1;
            MainApp.Limo = 0;
            MainApp.goldenCar = 0;
            btnApplyRace.setDisable(false);
            btnApplyNormal.setDisable(true);
            btnApplyLimo.setDisable(false);
            btnApplyGolden.setDisable(false);
        }
        if (MainApp.Limo == 1) {
            MainApp.RaceCar = 0;
            MainApp.normalCar = 0;
            MainApp.Limo = 1;
            MainApp.goldenCar = 0;
            btnApplyRace.setDisable(false);
            btnApplyNormal.setDisable(false);
            btnApplyLimo.setDisable(true);
            btnApplyGolden.setDisable(false);
        }
        if (MainApp.goldenCar == 1) {
            MainApp.RaceCar = 0;
            MainApp.normalCar = 0;
            MainApp.Limo = 0;
            MainApp.goldenCar = 1;
            btnApplyRace.setDisable(false);
            btnApplyNormal.setDisable(false);
            btnApplyLimo.setDisable(false);
            btnApplyGolden.setDisable(true);
        }
        if (MainApp.upgradeLuck == 1) {
            
            
            
            
            lblUnlockUpgrade.setText("Free");
            
        }
        /*
         
         
         
         
         
         */

    }

}
