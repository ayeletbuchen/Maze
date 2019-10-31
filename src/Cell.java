import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {
    private boolean visited = false;
    private int topBorder = 1;
    private int bottomBorder = 1;
    private int leftBorder = 1;
    private int rightBorder = 1;
    private Color defaultColor = Color.WHITE;
    int row;
    int col;
    Cell parent;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        setBackground(defaultColor);
        setBorders();
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    public void setVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setColor(Color color) {
        defaultColor = color;
        setBackground(defaultColor);
    }

    public void removeTopBorder() {
        topBorder = 0;
        setBorders();
    }

    public void removeBottomBorder() {
        bottomBorder = 0;
        setBorders();
    }

    public void removeLeftBorder() {
        leftBorder = 0;
        setBorders();
    }

    public void removeRightBorder() {
        rightBorder = 0;
        setBorders();
    }

    private void setBorders() {
        setBorder(BorderFactory.createMatteBorder(topBorder, leftBorder, bottomBorder, rightBorder, Color.BLACK));
    }

    public void resetBackground() {
        setBackground(defaultColor);
    }

    public boolean isOpenOnLeft() {
        return col > 0 && leftBorder == 0;
    }

    public boolean isOpenOnRight() {
        return col < IMaze.CELLS_PER_ROW - 1 && rightBorder == 0;
    }

    public boolean isOpenOnTop() {
        return row > 0 && topBorder == 0;
    }

    public boolean isOpenOnBottom() {
        return row < IMaze.CELLS_PER_ROW - 1 && bottomBorder == 0;
    }

    public int openNeighbors() {
        int count = 0;
        if (isOpenOnTop()) {
            count++;
        }
        if (isOpenOnBottom()) {
            count++;
        }
        if (isOpenOnLeft()) {
            count++;
        }
        if (isOpenOnRight()) {
            count++;
        }
        return count;
    }
}
