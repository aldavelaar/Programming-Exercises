module exercise.java {
    requires javafx.controls;
    requires javafx.fxml;

    opens exercise.java to javafx.fxml;
    exports exercise.java;
}
