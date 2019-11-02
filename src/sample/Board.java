package sample;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board extends Parent {

    protected Tile[][] tiles;
    protected List<Tile> winningComboList = new ArrayList<>();
    protected List<Tile> shuffledList = new ArrayList<>();
    private int height;
    private int length;
    protected GridPane grid;

    public Board(int height, int length) {

        this.tiles = new Tile[4][4];
        this.grid = new GridPane();
    }

    public void fillBoardWithCells() {
        int numberOnTile = 1;
        int numberInList = 0;
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles.length; j++) {
                tiles[j][i] = new Tile(numberOnTile); // Tiles skapas.
                winningComboList.add(tiles[j][i]); // Fyll en lista med den kombinationen som gör att man vinner.
                shuffledList.add(tiles[j][i]); // Gör en likandan lista som sen blandas om.
                numberOnTile++;
            }
        }
        Collections.shuffle(shuffledList);
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles.length; j++) {
                grid.setRowIndex(shuffledList.get(numberInList), j);
                grid.setColumnIndex(shuffledList.get(numberInList), i);
                grid.add(shuffledList.get(numberInList), j, i); // Lägg till den blandade listan till grid'en.
                numberInList++;
            }
        }

        getChildren().add(grid);
//        System.out.println(winningComboList);
        System.out.println(shuffledList);
    }

    public void updateList(Tile clickedTile, Tile blankTile) {
        int x = shuffledList.indexOf(clickedTile);
        int y = shuffledList.indexOf(blankTile);
        Collections.swap(shuffledList, x, y);
        System.out.println(shuffledList);
        // Call win method
    }

    public void win() {
        // Compare shuffledList to winningComboList.
        // Om listorna är lika, visa ett meddelande att man har klarat spelet.
        // Två knappar ska visas, "Nytt spel" och "Avsluta".
    }

    public void newGame() {
        // rensa gamla spelplanen och kalla på fillBoardWithCells()?
    }
}
