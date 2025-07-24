import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Welcome extends Application {

    public static String username = "User";
    

    @Override
    public void start(Stage primaryStage) {
        // Main container with gradient background
        StackPane root = new StackPane();
        root.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);"
        );

        // Welcome message label
       Label welcomeLabel = new Label("Hello, " + username + "!");

        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        welcomeLabel.setTextFill(Color.WHITE);
        
        // Add drop shadow effect
        welcomeLabel.setStyle(
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"
        );

        root.getChildren().add(welcomeLabel);
        StackPane.setAlignment(welcomeLabel, Pos.CENTER);
        
        // Create scene and show stage
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
