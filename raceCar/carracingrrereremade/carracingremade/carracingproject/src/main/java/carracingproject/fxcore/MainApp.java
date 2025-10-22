
package carracingproject.fxcore;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainApp extends Application {
    public static MediaPlayer Backgroundplayer;

    private static Stage stage;
    public static int upgradeLuck = 0;
    public static double money = 100;
    public static double bet = 0;
    public static int upgradeBet = 0;
    public static int normaltrack = 0;
    public static int watertrack = 0;
    public static boolean backgroundmusicon = true;
    public static int soundeffectson = 0;
    public static  int upgradelevelmoney = 0;
  public static int upgradelevelluck = 0;
  public static int normalCar = 1;
    public static  int RaceCar = 0;
  public static int Limo = 0;
  public static int goldenCar = 0;
   
    
    
    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage = s;
        setRoot("menu", "");
        
        Backgroundplayer = new MediaPlayer((new Media(getClass().getResource("/main theme.mp3").toString())));
        Backgroundplayer.setCycleCount(200000);
        Backgroundplayer.setVolume(0.1);
        Backgroundplayer.play();
        System.out.println("Music Playing");
        
        
       
        
        
        
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml, stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> System.exit(0));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
