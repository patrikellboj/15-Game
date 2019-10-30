package sample;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Board extends Parent {

    protected List<Tile> tilesList = new ArrayList<>();
    protected Tile[][] tiles;
    private int height;
    private int length;
    protected GridPane grid;

    public Board(int height, int length) {

        this.tiles = new Tile[4][4];
        this.grid = new GridPane();
    }

    public void fillBoardWithCells() {
        int number = 1;
        for (int i = 0; i < tiles.length; i++) { //tiles[0].length
            for (int j = 0; j < tiles.length; j++) {
                tiles[j][i] = new Tile(j, i, number); // Tiles skapas.
//                System.out.println(tiles[i][j].toString());

//                tiles[i][j].setOnMouseClicked(e -> {
//                    swapTiles(1, 1);
//                });
                tilesList.add(tiles[j][i]); // Adda en instans av en tile (tiles[x][y]) till listan tilesList.
                grid.add(tiles[j][i], j, i); // [i][j] , i, j addar i fel ordning.
                number++;
            }
        }
        getChildren().add(grid);
    }

//    public void swapTiles (int i, int j) {
//        Tile temp1 = tiles[1][2];
//        Tile temp2 = tiles[2][2];
////        grid.getChildren().removeAll(tiles[0][0]);
////        grid.getChildren().removeAll(tiles[0][1]);
//
////        Tile tempTile = tiles[1][2];
////        tiles[1][2] = tiles[2][2];
////        tiles[2][2] = tempTile;
//        grid.add(temp1, 2, 2);
////        grid.add(temp2, 1, 2);
//    }

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
