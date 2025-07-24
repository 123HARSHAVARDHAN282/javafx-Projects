import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Click Me! 😃");

        // Apply Noto Color Emoji font (if available)
        button.setStyle("-fx-font-family: 'Noto Color Emoji'; -fx-font-size: 20px;");

        button.setOnAction(e -> button.setText("Hello, JavaFX! 😜"));

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("JavaFX Demo 😃");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
