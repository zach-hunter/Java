import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class Main
        extends Application {

    private Stage myStage;

    private ComboBox<String> nameComboBox = new ComboBox<>();

    private class OpenFileHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileDialog = new FileChooser();
            File file = fileDialog.showOpenDialog(myStage);
            if (file != null) {
                try (Scanner input = new Scanner(
                        new BufferedReader(
                                new FileReader(file)))) {
                    List<String> names = new ArrayList<>();
                    while (input.hasNextLine()) {
                        names.add(input.nextLine());
                    }
                    ObservableList<String> observableList =
                            FXCollections.observableArrayList(names);
                    nameComboBox.getItems().addAll(observableList);

                } catch (IOException iOEx) {
                    System.out.println(iOEx.getMessage());
                }
            } else {
                System.out.println("No file selected!");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.myStage = primaryStage;
        primaryStage.setTitle("File Example");

        Button openFileButton = new Button("Open File");
        openFileButton.setOnAction(new OpenFileHandler());
        //ComboBox nameComboBox = new ComboBox();

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.getChildren().addAll(nameComboBox, openFileButton);

        Scene scene = new Scene(root, 200, 200);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}