import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application {

    
    

    @Override
    public void start(Stage primaryStage) {
         DatabaseHelper.initializeDatabase();

        // Create main grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(40, 40, 40, 40));
        grid.setStyle("-fx-background-color: #f4f4f4;");
        
        // Create a container for the form to add depth
        StackPane formContainer = new StackPane();
        formContainer.setPadding(new Insets(40, 40, 40, 40));
        formContainer.setStyle("-fx-background-color: white; " +
                               "-fx-background-radius: 10; " +
                               "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);");
        
        // Create form elements
        Text title = new Text("DEMO LOGIN");
        title.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
        title.setFill(Color.web("#444444"));
        grid.add(title, 0, 0, 2, 1);
        
        // Username field
        Label usernameLabel = new Label("USERNAME");
        usernameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        usernameLabel.setTextFill(Color.web("#666666"));
        grid.add(usernameLabel, 0, 1);
        
        TextField usernameField = new TextField();
        usernameField.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #dddddd; " +
                              "-fx-pref-height: 36px; -fx-font-size: 14px;");
        usernameField.setPromptText("Enter your username");
        grid.add(usernameField, 0, 2, 2, 1);
        
        // Password field
        Label passwordLabel = new Label("PASSWORD");
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        passwordLabel.setTextFill(Color.web("#666666"));
        grid.add(passwordLabel, 0, 3);
        
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #dddddd; " +
                              "-fx-pref-height: 36px; -fx-font-size: 14px;");
        passwordField.setPromptText("Enter your password");
        grid.add(passwordField, 0, 4, 2, 1);
        
        // Submit button
        Button submitButton = new Button("LOGIN");
        submitButton.setStyle("-fx-background-color: #4a90e2; " +
                             "-fx-text-fill: white; " +
                             "-fx-font-weight: bold; " +
                             "-fx-font-size: 14px; " +
                             "-fx-pref-width: 120px; " +
                             "-fx-pref-height: 40px; " +
                             "-fx-background-radius: 5; " +
                             "-fx-cursor: hand;");
        
        // Hover effect for login button
        submitButton.setOnMouseEntered(e -> submitButton.setStyle("-fx-background-color: #3a7bc8; " +
                                                                 "-fx-text-fill: white; " +
                                                                 "-fx-font-weight: bold; " +
                                                                 "-fx-font-size: 14px; " +
                                                                 "-fx-pref-width: 120px; " +
                                                                 "-fx-pref-height: 40px; " +
                                                                 "-fx-background-radius: 5; " +
                                                                 "-fx-cursor: hand;"));
        
        submitButton.setOnMouseExited(e -> submitButton.setStyle("-fx-background-color: #4a90e2; " +
                                                                "-fx-text-fill: white; " +
                                                                "-fx-font-weight: bold; " +
                                                                "-fx-font-size: 14px; " +
                                                                "-fx-pref-width: 120px; " +
                                                                "-fx-pref-height: 40px; " +
                                                                "-fx-background-radius: 5; " +
                                                                "-fx-cursor: hand;"));
        
        // Sign Up button
        Button signUpButton = new Button("SIGN UP");
        signUpButton.setStyle("-fx-background-color: #4CAF50; " +
                             "-fx-text-fill: white; " +
                             "-fx-font-weight: bold; " +
                             "-fx-font-size: 14px; " +
                             "-fx-pref-width: 120px; " +
                             "-fx-pref-height: 40px; " +
                             "-fx-background-radius: 5; " +
                             "-fx-cursor: hand;");
        
        // Hover effect for sign up button
        signUpButton.setOnMouseEntered(e -> signUpButton.setStyle("-fx-background-color: #45a049; " +
                                                                 "-fx-text-fill: white; " +
                                                                 "-fx-font-weight: bold; " +
                                                                 "-fx-font-size: 14px; " +
                                                                 "-fx-pref-width: 120px; " +
                                                                 "-fx-pref-height: 40px; " +
                                                                 "-fx-background-radius: 5; " +
                                                                 "-fx-cursor: hand;"));
        
        signUpButton.setOnMouseExited(e -> signUpButton.setStyle("-fx-background-color: #4CAF50; " +
                                                                "-fx-text-fill: white; " +
                                                                "-fx-font-weight: bold; " +
                                                                "-fx-font-size: 14px; " +
                                                                "-fx-pref-width: 120px; " +
                                                                "-fx-pref-height: 40px; " +
                                                                "-fx-background-radius: 5; " +
                                                                "-fx-cursor: hand;"));
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(submitButton, signUpButton);
        grid.add(buttonBox, 0, 5, 2, 1);
        
        // Button actions
       submitButton.setOnAction(e -> {
    String username = usernameField.getText();
    String password = passwordField.getText();
    if (DatabaseHelper.validateLogin(username, password)) {
        Welcome.username = username;
        new Welcome().start(new Stage());
        primaryStage.close();
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText("Invalid username or password!");
        alert.showAndWait();
    }
});

        
        signUpButton.setOnAction(e -> {
    try {
        new SignUpPage().start(new Stage());
        primaryStage.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});

        
        formContainer.getChildren().add(grid);
        
        // Create scene and show stage
        Scene scene = new Scene(formContainer, 400, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demo Login");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
