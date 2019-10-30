package sample;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board extends Parent {

    protected List<Integer> winningComboList = new ArrayList<>();
    protected List<Integer> shuffledList = new ArrayList<>();
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
                winningComboList.add(tiles[j][i].getNumber()); // Adda en instans av en tile (tiles[x][y]) till listan tilesList.
                shuffledList.add(tiles[j][i].getNumber());
                grid.add(tiles[j][i], j, i);
                number++;
            }
        }
        getChildren().add(grid);
        Collections.shuffle(shuffledList);
        System.out.println(winningComboList);
        System.out.println(shuffledList);
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
