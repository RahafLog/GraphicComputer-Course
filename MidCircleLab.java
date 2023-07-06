
package midcirclelab;

import java.awt.Color;
import java.awt.Dimension;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JFrame;

public class MidCircleLab extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.print("Enter the radius of the circle(less than 300): ");
     java.util.Scanner input = new java.util.Scanner(System.in);
     MCircle circle = new MCircle(input.nextInt());
     JFrame frame = new JFrame("MCircle");
     frame.setSize(300, 300);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     circle.setPreferredSize(new Dimension(600,600));
     frame.add(circle);
     frame.pack();
     frame.setVisible(true);
    }
    
}
