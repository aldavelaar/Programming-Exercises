module exercise.java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens exercise.java to javafx.fxml;
    exports exercise.java;
}
