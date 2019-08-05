import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main
        extends Application {

    private Text resultText = new Text("");

    private TextField userName = new TextField();

    private PasswordField password = new PasswordField();

    private class LoginButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            resultText.setText("The button was clicked");
        }
    }

    private class ResetButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            userName.setText("");
            password.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First Form");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10.0);
        root.setVgap(10.0);
        root.setPadding(new Insets(25, 25, 25, 25));

        Text welcomeText = new Text("Welcome");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        root.add(welcomeText, 0, 0, 2, 1);

        root.add(new Label("User Name:"), 0, 1);
        root.add(new Label("Password:"), 0, 2);

        //TextField userName = new TextField();
        root.add(userName, 1, 1);

        //PasswordField password = new PasswordField();
        root.add(password, 1, 2);

        Button login = new Button("Login");
        login.setOnAction(event -> this.loginButtonClick());

        HBox box = new HBox(10);
        box.setAlignment(Pos.BOTTOM_LEFT);
        box.getChildren().add(login);

        root.add(box, 0, 3);

        Button reset = new Button("Reset");
        reset.setOnAction(new ResetButtonHandler());
        HBox resetBox = new HBox(10);
        resetBox.setAlignment(Pos.BOTTOM_RIGHT);
        resetBox.getChildren().add(reset);

        root.add(resetBox, 1, 3);

        root.add(this.resultText, 0, 4, 2, 1);

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    private void loginButtonClick() {
        resultText.setText("Lambda expression button click!");
    }
}