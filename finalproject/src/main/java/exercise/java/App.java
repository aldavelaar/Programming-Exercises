package exercise.java;

  import javafx.application.Application;
  import javafx.scene.Scene;
  import javafx.scene.control.Label;
  import javafx.scene.layout.BorderPane;
  import javafx.scene.layout.GridPane;
  import javafx.scene.layout.Pane;
  import javafx.scene.paint.Color;
  import javafx.scene.shape.Ellipse;
  import javafx.stage.Stage;

  public class App extends Application {
    // Indicate which player has a turn, initially it is the X player
    private char whoseTurn = 'X';

    // Create and initialize cell
    private final Cell[][] cell = new Cell[6][7];

    // Create and initialize a status label
    private final Label lblStatus = new Label("X's turn to play");

    @SuppressWarnings("exports")
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Pane to hold cell
      GridPane pane = new GridPane();
      for (int i = 0; i < 6; i++)
        for (int j = 0; j < 7; j++)
          pane.add(cell[i][j] = new Cell(), j, i);

      BorderPane borderPane = new BorderPane();
      borderPane.setCenter(pane);
      borderPane.setBottom(lblStatus);

      // Create a scene and place it in the stage
      Scene scene = new Scene(borderPane, 700, 600);
      primaryStage.setTitle("Connect 4"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }

    /** Determine if the cell are all occupied */
    public boolean isFull() {
      for (int i = 0; i < 6; i++)
        for (int j = 0; j < 7; j++)
          if (cell[i][j].getToken() == ' ')
            return false;

      return true;
    }

    /** Determine if the player with the specified token wins */
    public boolean isWon(char token) {
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 7; j++) {
          if (cell[i][j].getToken() == token
              && cell[i][j + 1].getToken() == token
              && cell[i][j + 2].getToken() == token
              && cell[i][j + 3].getToken() == token) {
          return true;
          }
          if (cell[i][j].getToken() == token
              && cell[i][j + 1].getToken() == token
              && cell[i][j + 2].getToken() == token
              && cell[i][j + 3].getToken() == token) {
          return true;
          }
          if (cell[i][j].getToken() == token
              && cell[i + 1][j + 1].getToken() == token
              && cell[i + 2][j + 2].getToken() == token
              && cell[i + 3][j + 3].getToken() == token) {
          return true;
          }
          if (cell[i][j].getToken() == token
              && cell[i - 1][j + 1].getToken() == token
              && cell[i - 2][j + 2].getToken() == token
              && cell[i - 3][j + 3].getToken() == token) {
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
        token = c;
        
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

        if (token == 'X') {
          ellipse.setStroke(Color.YELLOWGREEN);
          ellipse.setFill(Color.YELLOW);
        }
        else if (token == 'O') {
          ellipse.setStroke(Color.DARKRED);
          ellipse.setFill(Color.RED);
        }

        getChildren().add(ellipse); // Add the ellipse to the pane

      }

      /* Handle a mouse click event */
      private void handleMouseClick() {
        // If cell is empty and game is not over
        if (token == ' ' && whoseTurn != ' ') {
          setToken(whoseTurn); // Set token in the cell

          // Check game status
          if (isWon(whoseTurn)) {
            lblStatus.setText(whoseTurn + " won! The game is over");
            whoseTurn = ' '; // Game is over
          }
          else if (isFull()) {
            lblStatus.setText("Draw! The game is over");
            whoseTurn = ' '; // Game is over
          }
          else if (whoseTurn == 'X') {
            whoseTurn = 'O';
            lblStatus.setText(whoseTurn + "'s turn");
          }
          else if (whoseTurn == 'O') {
            whoseTurn = 'X';
            lblStatus.setText(whoseTurn + "'s turn");
          }
        }
      }
    }

    public static void main(String[] args) {
      launch();
    }
  }