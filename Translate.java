/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translate;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;


public class Translate extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
    //dfind 2 rec
    Rectangle rect1 = new Rectangle(10,10,150,150);  
    Rectangle rect2 = new Rectangle(20,20,150,150);  
      
    // setting the color and stroke for the Rectangles    
    rect1.setFill(Color.BROWN);  
    rect2.setFill(Color.CADETBLUE);  
    
       
      //Creating the translation transformation 
      javafx.scene.transform.Translate translate = new javafx.scene.transform.Translate();       
      
      //Setting the X,Y,Z coordinates to apply the translation 
      translate.setX(300); 
      translate.setY(50); 
      translate.setZ(100);  
      
      
       // instantiating the Rotate class.   
        Rotate rotate = new Rotate();  
      
        //setting properties for the rotate object.   
        rotate.setAngle(30);  
        rotate.setPivotX(100);  
        rotate.setPivotY(300);  
        
        //creating a 2D scale   
        Scale scale = new Scale();  
      
        // setting the X-y factors for the scale   
        scale.setX(2);  
        scale.setY(1);  

    
        //creating the shear transformation   
        Shear shear1 = new Shear();  
          
        // setting properties for the shear, the Y coordinate // needs to set to (0,0) for the X-shear transformation   
       // shearX.setPivotX(200);   
       // shearX.setPivotY(250);  
        shear1.setX(0.5);   
        shear1.setY(0.0);  
        
        
        Shear shear2 = new Shear();  
          
        // setting properties for the shear, the Y coordinate // needs to set to (0,0) for the X-shear transformation   
       // shearX.setPivotX(200);   
       // shearX.setPivotY(250);  
        shear2.setX(0.0);   
        shear2.setY(0.5);  
        
      //Adding transformation to circle2 
      //rect2.getTransforms().addAll(translate,rotate,scale, shearX); 
       
      
      Button btn = new Button();
    btn.setText("move");
    btn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            rect2.getTransforms().addAll(translate,rotate, shear1); 
            //rect2.getTransforms().addAll(translate,rotate); 
            rect1.getTransforms().addAll(translate,rotate, shear2); 
        }
    });
    
        TilePane p = new TilePane();
        
        p.getChildren().addAll(btn, rect1, rect2);
      //Creating a Group object  
      Group root = new Group(p); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 1000, 1000);  
      
      //Setting title to the Stage 
      Stage stage = new Stage();
      stage.setTitle("Translation transformation example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}