import javax.swing.*;
import java.awt.*;

public abstract class ItsPane extends JPanel {
    int state = 0;

    public ItsPane() {
        final Dimension MIN_SIZE= new Dimension(400, 300);
        final Dimension MAX_SIZE = new Dimension(800, 600);
        setMinimumSize(MIN_SIZE);
        setMaximumSize(MAX_SIZE);
        setPreferredSize(MAX_SIZE);
    }


    void changeState(int state) {
        this.state = state;
        revalidate();
        repaint();
    };
}
