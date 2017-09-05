import java.awt.*;

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
