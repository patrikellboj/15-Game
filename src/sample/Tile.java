package sample;

import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

public class Tile<square> extends Parent {

    private Rectangle square;
    private int posX;
    private int posY;
    private int number;
    private boolean isEmpty;

    public Tile(int posX, int posY, int number) {
        this.posX = posX;
        this.posY = posY;
        this.number = number;
        this.isEmpty = this.number != 16;

        square = new Rectangle(50, 50);
        setStyle();

        Text text = new Text(Integer.toString(number));
        StackPane tile = new StackPane();

        tile.getChildren().addAll(square, text);

        getChildren().add(tile);
    }

    private void setStyle() {
        if (this.number == 16) {
            square.setFill(Color.BLACK);
        } else {
            square.setFill(Color.RED);
        }
        square.setStroke(Color.BLACK);
        square.setStrokeType(StrokeType.INSIDE);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "number=" + number +
                '}';
    }
}
