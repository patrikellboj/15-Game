package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    Board board;
    Button newGameBtn;
    Label label;

    @Override
    public void start(Stage primaryStage) throws Exception {

        newGameBtn = new Button();
        newGameBtn.setText("New Game");
        newGameBtn.setOnAction(e -> newGame());

        label = new Label();
        label.setText("Congratulations, you won the game!");

        BorderPane root = new BorderPane();
        board = new Board();
        board.fillBoardWithCells();
        root.setTop(newGameBtn);
        root.setCenter(board);
        root.setBottom(label);
        label.setVisible(false);

        Scene scene = new Scene(root, 400, 400);

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("15 Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // TODO: 2019-10-30 Gör något åt det här
        board.tiles[0][0].setOnMouseClicked(e -> swapTiles(board.tiles[0][0], board.tiles[3][3]));
        board.tiles[0][1].setOnMouseClicked(e -> swapTiles(board.tiles[0][1], board.tiles[3][3]));
        board.tiles[0][2].setOnMouseClicked(e -> swapTiles(board.tiles[0][2], board.tiles[3][3]));
        board.tiles[0][3].setOnMouseClicked(e -> swapTiles(board.tiles[0][3], board.tiles[3][3]));
        board.tiles[1][0].setOnMouseClicked(e -> swapTiles(board.tiles[1][0], board.tiles[3][3]));
        board.tiles[1][1].setOnMouseClicked(e -> swapTiles(board.tiles[1][1], board.tiles[3][3]));
        board.tiles[1][2].setOnMouseClicked(e -> swapTiles(board.tiles[1][2], board.tiles[3][3]));
        board.tiles[1][3].setOnMouseClicked(e -> swapTiles(board.tiles[1][3], board.tiles[3][3]));
        board.tiles[2][0].setOnMouseClicked(e -> swapTiles(board.tiles[2][0], board.tiles[3][3]));
        board.tiles[2][1].setOnMouseClicked(e -> swapTiles(board.tiles[2][1], board.tiles[3][3]));
        board.tiles[2][2].setOnMouseClicked(e -> swapTiles(board.tiles[2][2], board.tiles[3][3]));
        board.tiles[2][3].setOnMouseClicked(e -> swapTiles(board.tiles[2][3], board.tiles[3][3]));
        board.tiles[3][0].setOnMouseClicked(e -> swapTiles(board.tiles[3][0], board.tiles[3][3]));
        board.tiles[3][1].setOnMouseClicked(e -> swapTiles(board.tiles[3][1], board.tiles[3][3]));
        board.tiles[3][2].setOnMouseClicked(e -> swapTiles(board.tiles[3][2], board.tiles[3][3]));
        board.tiles[3][3].setOnMouseClicked(e -> swapTiles(board.tiles[3][3], board.tiles[3][3]));
    }

    public void swapTiles(Tile clickedTile, Tile blankTile) {
        boolean isGameCompleted = false;

        // om clikedTile ligger bredvid blanktile -> byt plats på dem.
        if(board.grid.getRowIndex(clickedTile) == board.grid.getRowIndex(blankTile) -1 &&
                board.grid.getColumnIndex(clickedTile) == board.grid.getColumnIndex(blankTile)) {
        int temp = board.grid.getRowIndex(clickedTile);
        board.grid.setRowIndex(clickedTile, board.grid.getRowIndex(blankTile));
        board.grid.setRowIndex(blankTile, temp);
        temp = board.grid.getColumnIndex(clickedTile);
        board.grid.setColumnIndex(clickedTile, board.grid.getColumnIndex(blankTile));
        board.grid.setColumnIndex(blankTile, temp);
        board.updateList(clickedTile, blankTile);
        isGameCompleted = board.isGameCompleted();
        label.setVisible(isGameCompleted);

        } else if(board.grid.getRowIndex(clickedTile) == board.grid.getRowIndex(blankTile) +1 &&
                board.grid.getColumnIndex(clickedTile) == board.grid.getColumnIndex(blankTile)) {
            int temp = board.grid.getRowIndex(clickedTile);
            board.grid.setRowIndex(clickedTile, board.grid.getRowIndex(blankTile));
            board.grid.setRowIndex(blankTile, temp);
            temp = board.grid.getColumnIndex(clickedTile);
            board.grid.setColumnIndex(clickedTile, board.grid.getColumnIndex(blankTile));
            board.grid.setColumnIndex(blankTile, temp);
            board.updateList(clickedTile, blankTile);
            isGameCompleted = board.isGameCompleted();
            label.setVisible(isGameCompleted);

        } else if(board.grid.getColumnIndex(clickedTile) == board.grid.getColumnIndex(blankTile) -1 &&
                board.grid.getRowIndex(clickedTile) == board.grid.getRowIndex(blankTile)) {
            int temp = board.grid.getRowIndex(clickedTile);
            board.grid.setRowIndex(clickedTile, board.grid.getRowIndex(blankTile));
            board.grid.setRowIndex(blankTile, temp);
            temp = board.grid.getColumnIndex(clickedTile);
            board.grid.setColumnIndex(clickedTile, board.grid.getColumnIndex(blankTile));
            board.grid.setColumnIndex(blankTile, temp);
            board.updateList(clickedTile, blankTile);
            isGameCompleted = board.isGameCompleted();
            label.setVisible(isGameCompleted);

        } else if(board.grid.getColumnIndex(clickedTile) == board.grid.getColumnIndex(blankTile) +1 &&
                board.grid.getRowIndex(clickedTile) == board.grid.getRowIndex(blankTile)) {
            int temp = board.grid.getRowIndex(clickedTile);
            board.grid.setRowIndex(clickedTile, board.grid.getRowIndex(blankTile));
            board.grid.setRowIndex(blankTile, temp);
            temp = board.grid.getColumnIndex(clickedTile);
            board.grid.setColumnIndex(clickedTile, board.grid.getColumnIndex(blankTile));
            board.grid.setColumnIndex(blankTile, temp);
            board.updateList(clickedTile, blankTile);
            isGameCompleted = board.isGameCompleted();
            label.setVisible(isGameCompleted);


        }
    }

    public void newGame() {
        System.out.println("You clicked new game!");
        board.shuffleNewGame();
        label.setVisible(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
