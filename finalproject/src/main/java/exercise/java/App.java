package exercise.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

  public class App extends Application {
    // Indicate which player has a turn, initially it is the X player
    private char whoseTurn = 'Y';

    // Set the size of the board (I've included multiple board layouts that you can play around with)
    
    // teeny tiny 5x5
    //private final int h = 5; private final int w = 5; private final int cellSize = 100;

    // classic/defualt 7x6
    private final int h = 6; private final int w = 7; private final int cellSize = 100;

    // HUGE
    //private final int h = 20; private final int w = 37; private final int cellSize = 70;

    // EVEN BIGGER
    //private final int h = 35; private final int w = 65; private final int cellSize = 40;

    // Create and initialize cell
    private final Cell[][] cell = new Cell[h][w];

    // Create and initialize a status label
    private final static Label lblStatus = new Label("Yellow's turn to play");

    @SuppressWarnings("exports")
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      lblStatus.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
      lblStatus.setTextFill(Color.YELLOW);

      // Pane to hold cell
      GridPane pane = new GridPane();
      pane.setStyle("-fx-border-color: black;");
      for (int i = 0; i < h; i++)
        for (int j = 0; j < w; j++)
          pane.add(cell[i][j] = new Cell(), j, i);

      BorderPane borderPane = new BorderPane();
      borderPane.setStyle("-fx-background-color: lightblue;");
      borderPane.setTop(lblStatus);
      borderPane.setCenter(pane);

      // Create a scene and place it in the stage
      Scene scene = new Scene(borderPane, w * cellSize, h * cellSize, Color.YELLOW);
      primaryStage.setTitle("Connect 4"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }

    /** Determine if the cell are all occupied */
    public boolean isFull() {
      for (int i = 0; i < h; i++)
        for (int j = 0; j < w; j++)
          if (cell[i][j].getToken() == ' ')
            return false;

      return true;
    }

    /** Determine if the move is legal by checking
     * to see if the cell below the active cell is full */
    public boolean isLegal() {
      for (int i = 0; i < h - 1; i++)
        for (int j = 0; j < w; j++)
          if (cell[i][j].getToken() != ' ' && cell[i + 1][j].getToken() == ' ')
            return false;

      return true;
    }

    /** Determine if the player with the specified token wins */
    public boolean isWon(char token) {
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w - 3; j++) {
          if (cell[i][j].getToken() == token
              && cell[i][j + 1].getToken() == token
              && cell[i][j + 2].getToken() == token
              && cell[i][j + 3].getToken() == token) {
          return true;
          }
        }
      }
      for (int i = 0; i < h - 3; i++) {
        for (int j = 0; j < w; j++) {
          if (cell[i][j].getToken() == token
              && cell[i + 1][j].getToken() == token
              && cell[i + 2][j].getToken() == token
              && cell[i + 3][j].getToken() == token) {
          return true;
          }
        }
      }
      for (int i = 0; i < h - 3; i++) {
        for (int j = 0; j < w - 3; j++) {
          if (cell[i][j].getToken() == token
              && cell[i + 1][j + 1].getToken() == token
              && cell[i + 2][j + 2].getToken() == token
              && cell[i + 3][j + 3].getToken() == token) {
          return true;
          }
        }
      }
      for (int i = 0; i < h - 3; i++) {
        for (int j = 3; j < w; j++) {
          if (cell[i][j].getToken() == token
              && cell[i + 1][j - 1].getToken() == token
              && cell[i + 2][j - 2].getToken() == token
              && cell[i + 3][j - 3].getToken() == token) {
          return true;
          }
        }
      }
      return false;
    }

    // An inner class for a cell
    public class Cell extends Pane {
      // Token used for this cell
      private char token = ' ';

      public Cell() {
        setStyle("-fx-border-color: black");
        this.setPrefSize(2000, 2000);
        this.setOnMouseClicked(e -> handleMouseClick());
      }

      /** Return token */
      public char getToken() {
        return token;
      }

      /** Set a new token */
      public void setToken(char c) {
        Ellipse ellipse = new Ellipse(this.getWidth() / 2,
        this.getHeight() / 2, this.getWidth() / 2 - 10,
        this.getHeight() / 2 - 10);
        ellipse.centerXProperty().bind(
        this.widthProperty().divide(2));
        ellipse.centerYProperty().bind(
        this.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(
        this.widthProperty().divide(2).subtract(10));
        ellipse.radiusYProperty().bind(
        this.heightProperty().divide(2).subtract(10));

        if (token == 'Y') {
          ellipse.setFill(Color.YELLOW);
        }
        else if (token == 'R') {
          ellipse.setFill(Color.RED);
        }
        ellipse.setStroke(Color.BLACK);

        getChildren().add(ellipse); // Add the ellipse to the pane

      }

      /* Handle a mouse click event */
      private void handleMouseClick() {
        // If cell is empty and game is not over
        if (token == ' ' && whoseTurn != ' ') {
          token = whoseTurn; // Set token in the cell
          if (isLegal()) {
            setToken(whoseTurn);
            // Check game status
            if (isWon(whoseTurn)) {
              if (whoseTurn == 'Y') {
                lblStatus.setText("Yellow won! The game is over");
              }
              if (whoseTurn == 'R') {
                lblStatus.setText("Red won! The game is over");
              }
              whoseTurn = ' '; // Game is over
            }
            else if (isFull()) {
              lblStatus.setText("Draw! The game is over");
              whoseTurn = ' '; // Game is over
            }
            else if (whoseTurn == 'Y') {
              whoseTurn = 'R';
              lblStatus.setText("Red's turn");
              lblStatus.setTextFill(Color.RED);
            }
            else if (whoseTurn == 'R') {
              whoseTurn = 'Y';
              lblStatus.setText("Yellow's turn");
              lblStatus.setTextFill(Color.YELLOW);
            }
          } else {
            token = ' ';
            lblStatus.setText("Place pieces in the lowest availible slot");
          }
        }
      }
    }

    public static void main(String[] args) {
      launch();
    }
  }