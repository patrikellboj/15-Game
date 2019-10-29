package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    Board board;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        board = new Board(400, 400);

        board.fillBoardWithCells();

        root.setPrefSize(400, 400);
        Scene scene = new Scene(root);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("15 Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        root.getChildren().add(board);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
