
package carracingproject.fxcore;

/*
By: <Aum Markandey>
Date: 2025-10-16
Program Details: <The FXML controller for the shop in drag racers>
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
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FXMLControllerShop implements Initializable {

  @FXML
  private Button btnBack;

  @FXML
  private Button btnUpgradeLuck;

  @FXML
  private Button btnUpgradeMoney;

  

  @FXML
  private Label lblOut;

  @FXML
  private Label lblOut1;

  @FXML
  private Label lblOut11;

  @FXML
  private Label lblOut12;

  @FXML
  private Label lblMoney;

  @FXML
  private Label lblOut121;
  MediaPlayer player;
  Timeline timelineMoney = new Timeline(new KeyFrame(Duration.millis(25), ae -> Money()));
  Timeline timelineCheckMoney = new Timeline(new KeyFrame(Duration.millis(25), ae -> CheckLevelMoney()));
  Timeline timelineCheckLuck = new Timeline(new KeyFrame(Duration.millis(25), ae -> CheckLevelLuck()));
  
  private void Money() {
    lblMoney.setText("Money: " + MainApp.money);

  }

  @FXML
  void btnBackA(ActionEvent event) {
    try {
      MainApp.setRoot("primary", "Drag Racers");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  

  @FXML
  void btnUpgradeLuckA(ActionEvent event) {

    if (MainApp.money >= 150) {
      
      if (MainApp.upgradelevelluck <1){
      MainApp.upgradeLuck = 1;
      MainApp.RaceCar = 1;
      MainApp.money = MainApp.money - 150;
      MainApp.upgradelevelluck = MainApp.upgradelevelluck+1;
      player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
      player.play();
      
      
      }
      if (MainApp.upgradelevelluck>1){
        player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
        player.play();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("MAX UPGRADE LEVEL REACHED");
        alert.showAndWait();
      }

    } else if (MainApp.money < 150) {
      player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
      player.play();
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Information Dialog");
      alert.setHeaderText(null);
      alert.setContentText("INSUFFICENT FUNDS!");
      alert.showAndWait();
    }
  }

  @FXML
  void btnUpgradeMoneyA(ActionEvent event) {
    if (MainApp.money >= 200) {
      if (MainApp.upgradeBet > 2) {
        player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
        player.play();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("MAX UPGRADE LEVEL REACHED");
        alert.showAndWait();
      }
      else if (MainApp.upgradeBet<=3){
        MainApp.upgradeBet = MainApp.upgradeBet + 1;
      MainApp.money = MainApp.money - 200;
      MainApp.upgradelevelmoney = MainApp.upgradelevelmoney+1;
      
      player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
      player.play();
      }
      

    } else if (MainApp.money < 200) {
      player = new MediaPlayer((new Media(getClass().getResource("/wronganswer-37702.mp3").toString())));
      player.play();
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Information Dialog");
      alert.setHeaderText(null);
      alert.setContentText("INSUFFICENT FUNDS!");
      alert.showAndWait();
    }
  }

  private void CheckLevelMoney(){
    if (MainApp.upgradelevelmoney>=3){
        btnUpgradeMoney.setText("MAXED UPGRADE");
      }
      else if (MainApp.upgradelevelmoney<3){
        btnUpgradeMoney.setText("Upgrade "+MainApp.upgradelevelmoney+"/3");
      }
  }
  private void CheckLevelLuck(){
    if(MainApp.upgradelevelluck>=1){
    btnUpgradeLuck.setText("MAXED UPGRADE");
    }
    if (MainApp.upgradelevelluck<1){
      btnUpgradeLuck.setText("Upgrade 0/1");
    }
  }
  
  

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    timelineMoney.setCycleCount(Timeline.INDEFINITE);
    timelineMoney.play();
    timelineCheckMoney.setCycleCount(Timeline.INDEFINITE);
    timelineCheckMoney.play();
    timelineCheckLuck.setCycleCount(Timeline.INDEFINITE);
    timelineCheckLuck.play();
    btnUpgradeMoney.setText("Upgrade "+MainApp.upgradelevelmoney+"/3");
   
  }

}
