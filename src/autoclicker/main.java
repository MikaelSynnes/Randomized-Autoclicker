/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclicker;

import java.awt.EventQueue;
import java.awt.Font;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.SwingWorker;

/**
 *
 * @author Mikael
 */
public class main extends Application {

    Clicker autoclicker;
    boolean go = false;
    TextField delay;
    TextField rate;
    TextField clicks;
            

    @Override
    public void start(Stage primaryStage) {
        autoclicker=new Clicker();
        Button btn = new Button();
        Button btn2 = new Button();
       
        delay = new TextField();
        rate = new TextField();
        clicks = new TextField();
       

        rate.setText("1500");
        clicks.setText("2000");
        delay.setText("420");
        Text t = new Text(10, 50, "Amount of clicks");
        Text t2 = new Text(10, 50, "Minimum(ms)");
        Text t3 = new Text(10, 50, "Max delay(ms)");

        btn.setText("Run");
        btn2.setText("Stop");

        GridPane grid = new GridPane();

        grid.add(delay, 1, 3);
        grid.add(rate, 1, 2);
        grid.add(clicks, 1, 1);
        grid.add(t, 2, 1);
        grid.add(t2, 2, 2);
        grid.add(t3, 2, 3);

        grid.add(btn, 1, 4);
        grid.add(btn2, 2, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
           runAutoClicker();
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                go=false;
                autoclicker.Stop();
            }
        

        });
        
        Scene scene = new Scene(grid, 350, 200);

        primaryStage.setTitle("Autoclicker");
        primaryStage.setScene(scene);

        primaryStage.setMinWidth(
                600);
        primaryStage.setMinHeight(
                300);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void runAutoClicker(){
             go=true;
                int delayValue = Integer.parseInt(delay.getText());
                int rateValue = Integer.parseInt(rate.getText());
                int clickAmount = Integer.parseInt(clicks.getText());
                autoclicker.setValues(clickAmount, rateValue, delayValue);
                {
                    EventQueue.invokeLater(new Runnable() {
                        
                        @Override
                        public void run() {
                           while(go){
                                autoclicker.go();
                           }
                           
                        }
                    });
                }
    }
   
}
