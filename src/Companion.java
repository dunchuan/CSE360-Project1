import java.awt.*;

/** The Companion class is a state machine reflecting the progress
 *      of the student.
 *
 *
 */

public class Companion extends ItsPane {

    public Companion() {
        setBackground(Color.YELLOW);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(state) {
            default:
            case 0:
                g.drawString("Companion.java", 20, 20);
                break;
            case 1:
                g.drawString("Case 1", 20, 20);
                break;
            case 2:
                g.drawString("Case 2", 20, 20);
                break;
            case 3:
                g.drawString("Case 3", 20, 20);
                break;
            case 4:
                g.drawString("Case 4", 20, 20);
                break;
        }
    }
}
