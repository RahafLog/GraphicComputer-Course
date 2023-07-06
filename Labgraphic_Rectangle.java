
package labgraphic_rectangle;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;


import javafx.stage.Stage;

public class Labgraphic_Rectangle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //الازاراير
        Button Down = new Button();
        Down.setText("Down v");
        
        Button Right = new Button();
        Right.setText("Right >");
      
        Button Left = new Button();
        Left.setText("< Left");

        Button Up = new Button();        
        Up.setText("Up ^");

        HBox btns = new HBox();
        btns.getChildren().addAll(Left,Up,Down,Right);


        //موقع المربع الذهبي
        Random rand = new Random();
        int Num1 = rand.nextInt(41);
        int Num2 = rand.nextInt(41);
        
        int incx = Num1*10;
        int incY = Num2*10;
        
        //حجم المربعات و الوانها
        Rectangle main = new Rectangle(100,100,150,150);
                main.setFill(Color.GOLD);
                main.setTranslateX(incx);
                main.setTranslateY(incY);
                
        Rectangle r2 = new Rectangle(100,100,150,150);
                r2.setFill(Color.CYAN);
                r2.setTranslateX(200);
                r2.setTranslateY(200);
                
        Rectangle r3 = new Rectangle(100,100,150,150);
                r3.setFill(Color.CYAN);
                r3.setTranslateX(-100);
                r3.setTranslateY(200);
                
        //message
        Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("You Got it Right :)");
           alert.setHeaderText("");
           alert.setContentText("");
                   
        // الاكشن لكل زر
        Right.setOnAction(new EventHandler<ActionEvent>() {
            @Override            
            public void handle(ActionEvent event) {
                Translate right = new Translate();
                right.setX(10);
                right.setY(0);                 
                main.getTransforms().addAll(right);

                if((main.getX()== 200.0 && main.getY()== 200.0)||(main.getX()== -100.0 && main.getY()==200.0)){
                      alert.show();
                  }}
        });
        Left.setOnAction(new EventHandler<ActionEvent>() {
            @Override            
            public void handle(ActionEvent event) {
                Translate left = new Translate();
                left.setX(-10);
                left.setY(0);                 
                main.getTransforms().addAll(left);

                if((main.getX()== 200.0 && main.getY()==200.0)||(main.getX()== -100.0 && main.getY()==200.0)){
                      alert.show();
                  }}
        });
        Up.setOnAction(new EventHandler<ActionEvent>() {
            @Override            
            public void handle(ActionEvent event) {
                Translate up = new Translate();
                up.setX(0);
                up.setY(-10);                 
                main.getTransforms().addAll(up);

                if((main.getX()== 200.0 && main.getY()==200.0)||(main.getX()== -100.0 && main.getY()==200.0)){
                      alert.show();
                  }}
        });
        Down.setOnAction(new EventHandler<ActionEvent>() {
            @Override            
            public void handle(ActionEvent event) {
                Translate down = new Translate();
                down.setX(0);
                down.setY(10);                
                main.getTransforms().addAll(down);

                if((main.getX() == 200.0 && main.getY()== 200.0)||(main.getX()== -100.0 && main.getY()==200.0)){
                      alert.show();
                  }}
        });
          
                Pane p = new Pane();
                p.getChildren().addAll(main,r2,r3,btns);
                
                Group root = new Group(p);
                Scene s = new Scene(root,400,400);
                
                primaryStage.setScene(s);
                primaryStage.show();
                
    } 
    public static void main(String[] args) {
        launch(args);

        
    }
    
}
