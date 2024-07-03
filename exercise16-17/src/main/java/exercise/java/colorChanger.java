package exercise.java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class colorChanger extends Application {

Slider[] slider = new Slider[4];
@Override
public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {

    Text text = new Text("SHOW COLORS");
    text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

    // Bottom pane
    Label[] labels = new Label[4];
    String[] stringLabels = {"Red", "Green", "Blue", "Opacity"};
 
    //initialize the grid
    GridPane gridPane = new GridPane();
    gridPane.setHgap(40);
    gridPane.setVgap(20);
    gridPane.setPadding(new Insets(25));
    gridPane.setAlignment(Pos.CENTER);

    //create sliders and labels
    for (int i = 0; i < slider.length; i++) {

        //create a slider
        slider[i] = new Slider();
        slider[i].setMin(0);
        if (!stringLabels[i].equals("Opacity")) {
            slider[i].setMax(255);
            slider[i].setValue(0);
        } else {
            slider[i].setMax(1);
            slider[i].setValue(1);
        }

        //create a label to go with the slider
        labels[i] = new Label(stringLabels[i]);
        labels[i].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        switch (i) {
            case 0:
                labels[i].setTextFill(Color.RED);
                break;
            case 1:
                labels[i].setTextFill(Color.GREEN);
                break;
            case 2:
                labels[i].setTextFill(Color.BLUE);
                break;
            default:
                break;
        }

        //snap the labels and sliders into place
        gridPane.add(labels[i], 0, i);
        gridPane.add(slider[i], 1, i);

        //change text color, see getNewColor method
        slider[i].valueProperty().addListener((obser, old, newV) -> text.setFill(getNewColor()));

    }

    StackPane stackPane = new StackPane(text);
    stackPane.setPrefSize(315, 65);
    BorderPane borderPane = new BorderPane(stackPane);
    borderPane.setBottom(gridPane);

    //set the scene
    primaryStage.setScene(new Scene(borderPane));
    primaryStage.setTitle("Color Changer - Project 16.17");
    primaryStage.show();
}


private Color getNewColor() {
    // r g b o
    double[] rgb = new double[4];
    for (int i = 0; i < rgb.length; i++) {
        rgb[i] = slider[i].getValue();
    }
    return Color.rgb((int)rgb[0], (int)rgb[1], (int)rgb[2], rgb[3]);
}
public static void main(String[] args) {
    launch();
}}