package exercise.java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FourImage extends Application {
    @Override // Override the start method in the Application class 
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
      // Create a pane to hold the image views 
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(50, 50, 50, 50));
      Image image = new Image("http://liveexample.pearsoncmg.com/book/image/us.gif");
      pane.add(new ImageView(image), 0, 0);
      pane.add(new ImageView(image), 0, 1);
      pane.add(new ImageView(image), 1, 0);
      pane.add(new ImageView(image), 1, 1);

      // Create a scene and place it in the stage
      Scene scene = new Scene(pane);
      primaryStage.setTitle("Four Images"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage 
      primaryStage.show(); // Display the stage 
    }

    public static void main(String[] args) {
      launch();
    }
}