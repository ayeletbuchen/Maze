import javax.swing.*;
import java.awt.*;

public class Cell extends JComponent {
    private boolean visited = false;
    private int topBorder = 1;
    private int bottomBorder = 1;
    private int leftBorder = 1;
    private int rightBorder = 1;

    public Cell() {
        setBorders();
    }

    public void setVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
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
}
