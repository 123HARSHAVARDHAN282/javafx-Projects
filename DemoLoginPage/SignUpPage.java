import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.converter.LocalDateStringConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.stage.Stage;


public class SignUpPage extends Application {

    
    @Override
    public void start(Stage primaryStage) {
       
       
         DatabaseHelper.initializeDatabase();

        // Main container with gradient background
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #f5f7fa, #e4e7eb);");
        
        // Form container with shadow effect
        VBox formContainer = new VBox(20);
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setPadding(new Insets(30, 40, 30, 40));
        formContainer.setStyle(
            "-fx-background-color: white; " +
            "-fx-background-radius: 15; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 15, 0, 0, 5);"
        );

        

        
        // Title
        Text title = new Text("SIGN UP");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        title.setFill(Color.web("#4a90e2"));
        
        // Form Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 0, 20, 0));
        
        // Username Field
        Label usernameLabel = createFormLabel("Username:");
        TextField usernameField = createFormTextField();
        usernameField.setPromptText("Enter username");
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        
        // Full Name Field
        Label fullNameLabel = createFormLabel("Full Name:");
        TextField fullNameField = createFormTextField();
        fullNameField.setPromptText("Enter full name");
        grid.add(fullNameLabel, 0, 1);
        grid.add(fullNameField, 1, 1);
        
        // Date of Birth Field
        Label dobLabel = createFormLabel("Date of Birth:");
        DatePicker dobPicker = new DatePicker();
        dobPicker.setConverter(new LocalDateStringConverter(DateTimeFormatter.ofPattern("MM/dd/yyyy"), null));
        dobPicker.setValue(LocalDate.now().minusYears(18));
        dobPicker.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #e2e8f0; " +
                          "-fx-pref-height: 36px; -fx-font-size: 14px;");
        grid.add(dobLabel, 0, 2);
        grid.add(dobPicker, 1, 2);
        
        // Password Fields
        Label passwordLabel = createFormLabel("Password:");
        PasswordField passwordField = createPasswordField();
        passwordField.setPromptText("Enter password");
        grid.add(passwordLabel, 0, 3);
        grid.add(passwordField, 1, 3);
        
        Label confirmPasswordLabel = createFormLabel("Confirm Password:");
        PasswordField confirmPasswordField = createPasswordField();
        confirmPasswordField.setPromptText("Re-enter password");
        grid.add(confirmPasswordLabel, 0, 4);
        grid.add(confirmPasswordField, 1, 4);
        
        // Register Button
        Button registerButton = createActionButton("REGISTER", "#4a90e2");
        
        // Button action
        registerButton.setOnAction(e -> {
    if (validateInput(usernameField, fullNameField, passwordField, confirmPasswordField)) {
        String username = usernameField.getText();
        String fullname = fullNameField.getText();
        String dob = dobPicker.getValue().toString();
        String password = passwordField.getText();

        boolean success = DatabaseHelper.registerUser(username, fullname, dob, password);
        if (success) {
            showSuccessAlert("Registration Successful", "Welcome, " + fullname + "!");
        } else {
            showAlert("Registration Failed", "Username already exists!");
        }
    }
});

        // Bottom panel with register button
       HBox buttonPanel = new HBox(15);
buttonPanel.setAlignment(Pos.CENTER);

// Home Button
Button homeButton = createActionButton("HOME", "#999999");
homeButton.setOnAction(ev -> {
    try {
        new LoginPage().start(new Stage()); // Launch login window
        primaryStage.close();               // Close current signup window
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});

buttonPanel.getChildren().addAll(registerButton, homeButton);
 
        
        // Add all components to form container
        formContainer.getChildren().addAll(title, grid, buttonPanel);
        root.getChildren().add(formContainer);
        
        // Create scene and show stage
        Scene scene = new Scene(root, 450, 550);
        primaryStage.setTitle("Sign Up");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private Label createFormLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(Color.web("#4a5568"));
        return label;
    }
    
    private TextField createFormTextField() {
        TextField field = new TextField();
        field.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #e2e8f0; " +
                      "-fx-pref-height: 36px; -fx-font-size: 14px; -fx-padding: 0 10px;");
        return field;
    }
    
    private PasswordField createPasswordField() {
        PasswordField field = new PasswordField();
        field.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #e2e8f0; " +
                      "-fx-pref-height: 36px; -fx-font-size: 14px; -fx-padding: 0 10px;");
        return field;
    }
    
    private Button createActionButton(String text, String color) {
    Button button = new Button(text);

    // Determine hover color before using in lambdas
    final String hoverColor;
    if (color.equals("#4a90e2")) {
        hoverColor = "#3a78c2"; // darker version of blue
    } else if (color.equals("#999999")) {
        hoverColor = "#777777"; // darker version of gray
    } else {
        hoverColor = color; // fallback to original
    }

    button.setStyle("-fx-background-color: " + color + "; " +
                  "-fx-text-fill: white; " +
                  "-fx-font-weight: bold; " +
                  "-fx-font-size: 14px; " +
                  "-fx-pref-width: 150px; " +
                  "-fx-pref-height: 40px; " +
                  "-fx-background-radius: 5; " +
                  "-fx-cursor: hand;");

    // Lambda-safe usage of final hoverColor
    button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: " + hoverColor + "; " +
                  "-fx-text-fill: white; " +
                  "-fx-font-weight: bold; " +
                  "-fx-font-size: 14px; " +
                  "-fx-pref-width: 150px; " +
                  "-fx-pref-height: 40px; " +
                  "-fx-background-radius: 5; " +
                  "-fx-cursor: hand;"));

    button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + color + "; " +
                  "-fx-text-fill: white; " +
                  "-fx-font-weight: bold; " +
                  "-fx-font-size: 14px; " +
                  "-fx-pref-width: 150px; " +
                  "-fx-pref-height: 40px; " +
                  "-fx-background-radius: 5; " +
                  "-fx-cursor: hand;"));

    return button;
}

    
    private boolean validateInput(TextField username, TextField fullName, 
                                PasswordField password, PasswordField confirmPassword) {
        if (username.getText().isEmpty()) {
            showAlert("Validation Error", "Username cannot be empty");
            return false;
        }
        if (fullName.getText().isEmpty()) {
            showAlert("Validation Error", "Full name cannot be empty");
            return false;
        }
        if (password.getText().isEmpty()) {
            showAlert("Validation Error", "Password cannot be empty");
            return false;
        }
        if (!password.getText().equals(confirmPassword.getText())) {
            showAlert("Validation Error", "Passwords do not match");
            return false;
        }
        if (password.getText().length() < 6) {
            showAlert("Validation Error", "Password must be at least 6 characters");
            return false;
        }
        return true;
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
