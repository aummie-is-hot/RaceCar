
package carracingproject.fxcore;
/*
By: <Aum Markandey>
Date: 2025-10-16
Program Details: <The customizeing screen in the game drag racers which allows you to customize your screen>
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



public class FXMLControllerCustomize implements Initializable {
    @FXML
    private Button btnApplyNormal;
    MediaPlayer player;
    @FXML
    private Button btnApplyWater;

    @FXML
    private Button btnCars;

    @FXML
    private Button btnBack;

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
    void btnApplyNormalA(ActionEvent event) {
        MainApp.normaltrack = 1;
        MainApp.watertrack = 0;
        btnApplyWater.setDisable(false);
        btnApplyNormal.setDisable(true);
    }

    @FXML
    void btnApplyWaterA(ActionEvent event) {
        MainApp.normaltrack = 0;
        MainApp.watertrack = 1;
        btnApplyWater.setDisable(true);
        btnApplyNormal.setDisable(false);
    }
    

    @FXML
  void btnCarsA(ActionEvent event) {
    try {
      MainApp.setRoot("carcustom", "Customize Your Car");
    } catch (Exception e) {
System.out.println(e);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (MainApp.normaltrack == 1){
            btnApplyWater.setDisable(false);
            btnApplyNormal.setDisable(true);
        }
        else if (MainApp.watertrack == 1){
            btnApplyWater.setDisable(true);
            btnApplyNormal.setDisable(false);
        }
    }    
        

}
