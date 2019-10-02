import javax.swing.*;
import java.awt.*;

public class MazeUI extends JFrame {

    public MazeUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(IMaze.MAZE_SIZE + 10, IMaze.FRAME_SIZE);
        JPanel root = new JPanel(new BorderLayout());
        root.add(new Maze(), BorderLayout.CENTER);
        setContentPane(root);
    }
}
