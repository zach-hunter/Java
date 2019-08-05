import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application{
    /**
     * Initializes private textfield and score variables
     */
    private TextField score = new TextField();
    private TextField scoreTotal = new TextField();
    private TextField scoreCount = new TextField();
    private TextField scoreAverage = new TextField();
    private Text resultText = new Text("");
    private double scoreNum, scoreTotalNum, scoreAverageNum = 0.0;
    private int scoreCountNum = 0;

    /**
     * Reset button event. Clears all textfields and sets score variables to 0.
     */
    private class ResetButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            score.setText("");
            scoreTotal.setText("");
            scoreCount.setText("");
            scoreAverage.setText("");
            resultText.setText("");
            scoreNum = 0;
            scoreTotalNum = 0;
            scoreAverageNum = 0;
            scoreCountNum = 0;
        }
    }

    /**
     * Add button event. Will add entered number to scoreTotalNum as long as entry is > 0 and is a valid double
     * Else displays error message and doesnt add to scoreTotalNum
     */
    private class AddButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                if (Double.parseDouble(score.getText()) > 0) { //checks if entry is >0
                    scoreNum = Double.parseDouble(score.getText());
                    scoreCountNum++;
                    scoreTotalNum = scoreTotalNum + scoreNum;
                    scoreAverageNum = scoreTotalNum / scoreCountNum;
                    scoreTotal.setText(String.format("%.2f", scoreTotalNum));
                    scoreCount.setText(String.format("%d", scoreCountNum));
                    scoreAverage.setText(String.format("%.2f", scoreAverageNum));
                    resultText.setText("Score added!");
                    resultText.setFill(Color.GREEN);
                } else { //will not add Score if <0
                    resultText.setText("Invalid Score!");
                    resultText.setFill(Color.RED);
                }

            } catch (NumberFormatException nFO) { //catches if entry is not a valid double
                resultText.setText("Invalid Entry!");
                resultText.setFill(Color.RED);
            }
        }
    }

    /**
     * Exits the program
     */
    private class ExitButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Platform.exit();
        }
    }

    public static void main(String[] args) {
	launch(args);
    }

    /**
     * Starts the JavaFX application
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Score Calculator");

        /**
         * Creates root and padding
         */
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20.0);
        root.setVgap(5.0);
        root.setPadding(new Insets(25, 25, 25, 25));

        /**
         * Adds labels and their index position to root
         */
        root.add(new Label("Score:"), 0, 0);
        root.add(new Label("Score Total:"), 0, 1);
        root.add(new Label("Score Count:"), 0, 2);
        root.add(new Label("Average:"), 0, 3);

        /**
         * Sets width of text fields
         */
        score.setPrefWidth(50);
        scoreTotal.setPrefWidth(50);
        scoreCount.setPrefWidth(50);
        scoreAverage.setPrefWidth(50);

        /**
         * Adds text fields to root
         */
        root.add(score, 1, 0);
        root.add(scoreTotal, 1, 1);
        scoreTotal.setEditable(false);
        root.add(scoreCount, 1, 2);
        scoreCount.setEditable(false);
        root.add(scoreAverage, 1, 3);
        scoreAverage.setEditable(false);

        /**
         * Creates "Clear Scores" button, attaches to event, adds to HBox, adds HBox to root
         */
        Button reset = new Button("Clear Scores");
        reset.setPrefSize(85, 10);
        reset.setOnAction(new ResetButtonHandler());
        HBox resetBox = new HBox();
        resetBox.setAlignment(Pos.BOTTOM_RIGHT);
        resetBox.setPadding(new Insets(10, 0, 0, 0));
        resetBox.getChildren().add(reset);
        root.add(resetBox, 0, 5, 2, 1);

        /**
         * Creates "Add" button, attaches event, and adds to root
         */
        Button add = new Button("Add");
        add.setPrefSize(85, 10);
        add.setOnAction(new AddButtonHandler());
        root.add(add, 2, 0);

        /**
         * Creates exit button, attaches event, adds to HBox, adds HBox to root
         */
        Button exit = new Button("Exit");
        exit.setPrefSize(85, 10);
        exit.setOnAction(new ExitButtonHandler());
        HBox exitBox = new HBox();
        exitBox.setAlignment(Pos.CENTER);
        exitBox.setPadding(new Insets(10, 0, 0, 0));
        exitBox.getChildren().add(exit);
        root.add(exitBox, 2, 5);

        /**
         * Adds resultText to HBox and adds HBox to root
         */
        HBox resultBox = new HBox();
        resultBox.setAlignment(Pos.CENTER);
        resultBox.getChildren().add(resultText);
        root.add(resultBox, 2, 1);

        /**
         * Sets the scene, starts the show
         */
        primaryStage.setScene(new Scene(root, 300, 210));
        primaryStage.show();
    }
}
