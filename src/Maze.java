import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Maze extends JPanel {

    private Cell[][] maze;
    private Random random;

    public Maze() {
        setLayout(new GridLayout(IMaze.CELLS_PER_ROW, IMaze.CELLS_PER_ROW));
        setBackground(Color.WHITE);
        setSize(IMaze.MAZE_SIZE, IMaze.MAZE_SIZE);

        maze = new Cell[IMaze.CELLS_PER_ROW][IMaze.CELLS_PER_ROW];
        random = new Random();
        for (int row = 0; row < IMaze.CELLS_PER_ROW; row++) {
            for (int col = 0; col < IMaze.CELLS_PER_ROW; col++) {
                maze[row][col] = new Cell();
                add(maze[row][col]);
            }
        }
        maze[0][0].removeLeftBorder();
        eraseWalls(0, 0);
        maze[IMaze.CELLS_PER_ROW - 1][IMaze.CELLS_PER_ROW - 1].removeRightBorder();
    }

    private void eraseWalls(int row, int col) {
        if (!maze[row][col].isVisited()) {
            maze[row][col].setVisited();
            ArrayList<Integer> neighbors = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            Collections.shuffle(neighbors);
            while (!neighbors.isEmpty()) {
                int rand = random.nextInt(neighbors.size());
                int direction = neighbors.get(rand);
                switch (direction) {
                    case 1: // move up
                        if (row > 0) {
                            eraseWallAbove(maze[row][col], maze[row - 1][col]);
                            eraseWalls(row - 1, col);
                        }
                        break;
                    case 2: // move down
                        if (row < IMaze.CELLS_PER_ROW - 1) {
                            eraseWallAbove(maze[row + 1][col], maze[row][col]);
                            eraseWalls(row + 1, col);
                        }
                        break;
                    case 3: // move left
                        if (col > 0) {
                            eraseSideWall(maze[row][col - 1], maze[row][col]);
                            eraseWalls(row, col - 1);
                        }
                        break;
                    case 4: // move right
                        if (col < IMaze.CELLS_PER_ROW - 1) {
                            eraseSideWall(maze[row][col], maze[row][col + 1]);
                            eraseWalls(row, col + 1);
                        }
                        break;
                }
                neighbors.remove(rand);
            }
        }
    }

    private void eraseWallAbove(Cell cellBelow, Cell cellAbove) {
        if (!cellBelow.isVisited() || !cellAbove.isVisited()) {
            cellBelow.removeTopBorder();
            cellAbove.removeBottomBorder();
        }
    }

    private void eraseSideWall(Cell leftCell, Cell rightCell) {
        if (!leftCell.isVisited() || !rightCell.isVisited()) {
            leftCell.removeRightBorder();
            rightCell.removeLeftBorder();
        }
    }
}
