import javax.swing.*;
import java.awt.*;


/**
 * (basic description of program)
 *
 * Recitation Project 1
 * Completion time: 0.25 hours
 *
 * @author Robert Wasinger * @version 1.0
 */

public abstract class ItsPane extends JPanel {
    static int state = 0;

    private final Dimension MIN_SIZE= new Dimension(400, 300);
    private final Dimension MAX_SIZE = new Dimension(800, 600);

    public ItsPane() {

    }


    public Dimension getMaximumSize() {
       return MAX_SIZE;
    }


    public Dimension getMinimumSize() {
       return MIN_SIZE;
    }


    public Dimension getPreferredSize() {
        return MAX_SIZE;
    }

    void changeState(int newState) {
        state = newState;
        updateComponent();
        revalidate();
        repaint();
    }

    abstract void updateComponent();
}
