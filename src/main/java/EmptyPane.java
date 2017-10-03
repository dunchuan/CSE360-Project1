
import java.awt.*;

/**
 * EmptyPane is a simple JPane that displays a name until the state is set to a
 * non-zero value.
 *
 * Recitation Project 1
 * Completion time: 0.1 hours
 *
 * @author Robert Wasinger * @version 1.0
 */

public class EmptyPane extends ItsPane{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(state) {
            case 0:
                g.drawString("Robert Wasinger", 20, 20);
                break;
            default:
        }
    }

    @Override
    void updateComponent() {

    }
}
