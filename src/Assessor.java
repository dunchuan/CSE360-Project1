import java.awt.*;


/** The Accessor Class Shows the questions and uses listeners to change the model
 *
 *
 */
public class Assessor extends ItsPane {
    public Assessor() {
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (state) {
            case 0:
            default:
                g.drawString("Accessor.java", 20, 20);
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