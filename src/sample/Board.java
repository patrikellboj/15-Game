package sample;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class Board extends Parent {

    private Tile[][] tiles;
    private int height;
    private int length;
    private GridPane grid;

    public Board(int height, int length) {

        this.tiles = new Tile[4][4];
        this.grid = new GridPane();
    }

    public void fillBoardWithCells() {
        int number = 1;
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = new Tile(0, 0, number);
                tiles[i][j].setOnMouseClicked(e -> {
                    swapTiles(1, 1);
                });

                grid.add(tiles[i][j], j, i);
                number++;
            }
        }
        getChildren().add(grid);
    }

    public void swapTiles (int i, int j) {
        Tile temp1 = tiles[1][2];
        Tile temp2 = tiles[2][2];
//        grid.getChildren().removeAll(tiles[0][0]);
//        grid.getChildren().removeAll(tiles[0][1]);

//        Tile tempTile = tiles[1][2];
//        tiles[1][2] = tiles[2][2];
//        tiles[2][2] = tempTile;
        grid.add(temp1, 2, 2);
//        grid.add(temp2, 1, 2);
    }

    public void cleanBoard() {
        getChildren().remove(grid);
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }








}
