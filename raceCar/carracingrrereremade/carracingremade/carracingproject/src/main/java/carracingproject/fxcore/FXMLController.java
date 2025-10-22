
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

public class FXMLController implements Initializable {
    MediaPlayer player;
    @FXML
    private Button btnQuit;

    @FXML
    private ImageView imgBackground;

    @FXML
    private Label lblMoney;

    @FXML
    private Label lblSpeed;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnShop;

    @FXML
    private Button btnReset;

    @FXML
    private Label lblOut;

    @FXML
    private ImageView imgFinishLine;

    @FXML
    private ImageView imgPlayer;

    @FXML
    private ImageView imgBot1;

    @FXML
    private TextField txtField;

    int movespeedPlayer = ThreadLocalRandom.current().nextInt(5, 9 + 1);

    int movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(25), ae -> move()));

    Timeline timelinebet = new Timeline(new KeyFrame(Duration.millis(25), ae -> bet()));

    Timeline timelineBackground = new Timeline(new KeyFrame(Duration.millis(25), ae -> background()));

    private void background(){
        if (MainApp.normaltrack == 1){
            imgBackground.setImage(new Image(getClass().getResource("/New Project.jpg").toString()));
        }
        else if(MainApp.watertrack == 1){
            imgBackground.setImage(new Image(getClass().getResource("/underwatertrack.jpg").toString()));
        }
    }

    int cheatcounterW = 0;
    int cheatcounterG = 0;

    public boolean collision(ImageView block1, ImageView block2) {

        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }
    private void sound(String s){
        if(MainApp.soundeffectson == 0){
             if (s.equals("roar")){
            player = new MediaPlayer((new Media(getClass().getResource("/roar.mp3").toString())));
            player.play();
        }
        if (s.equals("money")){
            
            player = new MediaPlayer((new Media(getClass().getResource("/payed.mp3").toString())));
            player.play();
        }
        if (s.equals("lose")){
            
            player = new MediaPlayer((new Media(getClass().getResource("/loser.mp3").toString())));
            player.play();
        }else{

        }
        }
        
        
    }

    
    
    @FXML
    void btnResetA(ActionEvent event) {
        MainApp.money = 100;
        lblMoney.setText("Money: $" + MainApp.money);
    }

    @FXML
    void apCheatCodes(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.W) {
            cheatcounterW = cheatcounterW + 1;
        }
        if (code == KeyCode.G) {
            cheatcounterG = cheatcounterG + 1;
        }
    }

    @FXML
    void btnStartA(ActionEvent event) {
        txtField.setDisable(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        if (imgPlayer.getTranslateX() == 0) {

                
            
                
                
                sound("roar");
            if (cheatcounterW >= 5) {
                
                movespeedPlayer = ThreadLocalRandom.current().nextInt(20, 29 + 1);
                movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);
                
            }

            if (MainApp.upgradeLuck == 0) {
                
                movespeedPlayer = ThreadLocalRandom.current().nextInt(5, 9 + 1);
                movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);
                
            }

            if (MainApp.upgradeLuck == 1 || MainApp.RaceCar ==1) {
                movespeedPlayer = ThreadLocalRandom.current().nextInt(5, 12 + 1);
                movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);
            }
            if (MainApp.normalCar == 1) {
                movespeedPlayer = ThreadLocalRandom.current().nextInt(5, 9 + 1);
                movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);
            }
            if (MainApp.Limo == 1) {
                movespeedPlayer = ThreadLocalRandom.current().nextInt(5, 7 + 1);
                movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);
            }
            if (MainApp.goldenCar == 1) {
                movespeedPlayer = ThreadLocalRandom.current().nextInt(5, 19 + 1);
                movespeedBot1 = ThreadLocalRandom.current().nextInt(5, 9 + 1);
            }
            
        }
        if (cheatcounterG > 10) {

            MainApp.money = MainApp.money + 100;
            lblMoney.setText("Money: " + MainApp.money);
        }

    }

    private void wincondition(String msg) {
        if (msg.equals("W")) {
            timeline.stop();
            imgPlayer.setTranslateX(0);
            imgPlayer.setTranslateY(0);
            imgBot1.setTranslateX(0);
            imgBot1.setTranslateY(0);
            double bet = Double.parseDouble(txtField.getText());
            MainApp.money = MainApp.money + bet * 2;
            lblMoney.setText("Money: " + MainApp.money);
            lblOut.setText("You Win " );
            sound("money");
            txtField.setDisable(false);
            

        } else if (msg.equals("L")) {
            timeline.stop();
            imgPlayer.setTranslateX(0);
            imgPlayer.setTranslateY(0);
            imgBot1.setTranslateX(0);
            imgBot1.setTranslateY(0);
            double bet = Double.parseDouble(txtField.getText());
            MainApp.money = MainApp.money - bet;
            lblMoney.setText("Money: " + MainApp.money);
           lblOut.setText("You Lose " );
            sound("lose");
            txtField.setDisable(false);
        }
        if (msg.equals("UpgradeW0")) {
            timeline.stop();
            imgPlayer.setTranslateX(0);
            imgPlayer.setTranslateY(0);
            imgBot1.setTranslateX(0);
            imgBot1.setTranslateY(0);
            double bet = Double.parseDouble(txtField.getText());
            MainApp.money = MainApp.money + bet * 3;
            lblMoney.setText("Money: " + MainApp.money);
            lblOut.setText("You Win " );
            sound("money");
            txtField.setDisable(false);
        }
        if (msg.equals("UpgradeW2")) {
            timeline.stop();
            imgPlayer.setTranslateX(0);
            imgPlayer.setTranslateY(0);
            imgBot1.setTranslateX(0);
            imgBot1.setTranslateY(0);
            double bet = Double.parseDouble(txtField.getText());
            MainApp.money = MainApp.money + bet * 4;
            lblMoney.setText("Money: " + MainApp.money);
            lblOut.setText("You Win " );
            sound("money");
            txtField.setDisable(false);

        }
        if (msg.equals("UpgradeW3")) {
            timeline.stop();
            imgPlayer.setTranslateX(0);
            imgPlayer.setTranslateY(0);
            imgBot1.setTranslateX(0);
            imgBot1.setTranslateY(0);
            double bet = Double.parseDouble(txtField.getText());
            MainApp.money = MainApp.money + bet * 5;
            lblMoney.setText("Money: " + MainApp.money);
            lblOut.setText("You Win " );
            sound("money");
            txtField.setDisable(false);

        }

        if (msg.equals("D")) {
            timeline.stop();
            imgPlayer.setTranslateX(0);
            imgPlayer.setTranslateY(0);
            imgBot1.setTranslateX(0);
            imgBot1.setTranslateY(0);
            
            lblMoney.setText("Money: " + MainApp.money);
            lblOut.setText("Draw " );
            txtField.setDisable(false);

        }

    }

    private void bet() {

        try {
            
            if (MainApp.upgradeLuck == 1 || MainApp.RaceCar ==1) {
                imgPlayer.setImage(new Image(getClass().getResource("/racecarupgraded.png").toString()));
            }
            if (MainApp.normalCar == 1) {
                imgPlayer.setImage(new Image(getClass().getResource("/RaceCarRemade.png").toString()));
            }
            if (MainApp.Limo == 1) {
                imgPlayer.setImage(new Image(getClass().getResource("/Limo.png").toString()));
            }
            if (MainApp.goldenCar == 1) {
                imgPlayer.setImage(new Image(getClass().getResource("/GoldenCar.png").toString()));
            }
            lblMoney.setText("Money: " + MainApp.money);
            MainApp.bet = Double.parseDouble(txtField.getText());
            

            if (MainApp.bet < MainApp.money && MainApp.bet > 0) {
                btnStart.setDisable(false);                    
            } else if (MainApp.bet > MainApp.money || MainApp.bet <= 0) {
                btnStart.setDisable(true);   
            }

        } catch (Exception e) {
            btnStart.setDisable(true);
        }

    }

    private void move() {

        imgPlayer.setTranslateX(imgPlayer.getTranslateX() + movespeedPlayer);
        imgBot1.setTranslateX(imgBot1.getTranslateX() + movespeedBot1);
        lblSpeed.setText("Player Speed: " + movespeedPlayer);
        if (collision(imgPlayer, imgFinishLine)) {
            if (MainApp.upgradeBet == 1) {
                wincondition("UpgradeW0");
            } else if (MainApp.upgradeBet == 0) {
                wincondition("W");
            } else if (MainApp.upgradeBet == 2) {
                wincondition("UpgradeW2");
            } else if (MainApp.upgradeBet == 3) {
                wincondition("UpgradeW3");
            }



        } else if (collision(imgFinishLine, imgBot1)) {
            wincondition("L");
            if(MainApp.money <=0){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("You Lost");
                alert.setHeaderText(null);
                alert.setContentText("You lost all your money. Click reset to play again.");
                alert.showAndWait();
                
            }
        } else if (collision(imgFinishLine, imgBot1) && collision(imgFinishLine, imgPlayer)){
            wincondition("D");
            if(MainApp.money <=0){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("You Lost");
                alert.setHeaderText(null);
                alert.setContentText("You lost all your money. Click reset to play again.");
                alert.showAndWait();
                
            }
        }

    }
    @FXML
    void btnQuitA(ActionEvent event) {
        try {
            if (MainApp.soundeffectson==0){
                
            }
            
            
            timelinebet.stop();
            timelineBackground.stop();
            timeline.stop();
            
            MainApp.setRoot("menu", "Drag Racers");
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void btnShopA(ActionEvent event) {

        try {
            if (MainApp.soundeffectson==0){
                
            }
            
            
            timelinebet.stop();
            timelineBackground.stop();
            timeline.stop();
            
            MainApp.setRoot("shop", "Shop");
            
            
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timelinebet.setCycleCount(Timeline.INDEFINITE);
        timelinebet.play();
        timelineBackground.setCycleCount(Timeline.INDEFINITE);
        timelineBackground.play();
        lblMoney.setText("Money: 100");
        lblOut.setText("");
        

        /*
         
         
         * make the main menu better
         * make buttons feel responsive
          Update Fonts
          Add Credits page
          add textures
          make the background music button work
          Make the lengths of the cars fit the stats
          make the text fit
          
         
         
         */

    }

}
