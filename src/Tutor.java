import java.awt.*;

/** The Tutor Class shows the meaningful feedback based
 *      upon student progress within the steps.
 *
 *
 */

public class Tutor extends ItsPane {
    public Tutor() {
        setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(state) {
            case 0:
            default:
                g.drawString("Tutor.java", 20, 20);
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
