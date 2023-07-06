
package spheretexture;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Spheretexture extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Sphere sphere = new Sphere(50); 
        sphere.translateXProperty().set(400 / 2); 
        sphere.translateYProperty().set(400 / 2);
        
        Camera camera = new PerspectiveCamera();
        
       
        Group group = new Group(); 
        group.getChildren().add(sphere);
        
        Scene scene = new Scene(group, 400, 400);
        scene.setFill(Color.CYAN); 
        scene.setCamera(camera);
        
        
        //------------- add some moving -----------
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> { switch (event.getCode()) {
            case UP:
                sphere.translateZProperty().set(sphere.getTranslateZ() + 100); 
                break;
            case DOWN:
                sphere.translateZProperty().set(sphere.getTranslateZ() - 100); 
                break;
        } });
        //-----------------------------------------
        
        //------------ add some texture التغطيه -----------
        PhongMaterial material = new PhongMaterial(); 
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("home.jpg")));
        sphere.setMaterial(material);
        
        
        
        //-----------------------------------------
        primaryStage.setTitle("3D sphere!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}