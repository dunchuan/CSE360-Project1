import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/** The Tutor Class shows the meaningful feedback based
 *      upon student progress within the steps.
 *
 *
 */

public class Tutor extends ItsPane {
    private JEditorPane editorPane = new JEditorPane("text/html", "<HTML><h1>Tutor.java</h1></HTML>");

    public Tutor() {
        JScrollPane scrollPane = new JScrollPane(editorPane);
        add(scrollPane);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        URL currentPage;

        switch(state) {
            case 0:
            default:

                currentPage = this.getClass().getClassLoader().getResource("p1.html");
                break;
            case 1:
                currentPage = this.getClass().getClassLoader().getResource("p1.html");
                break;
            case 2:
                currentPage = this.getClass().getClassLoader().getResource("p2.html");
                break;
            case 3:
                currentPage = this.getClass().getClassLoader().getResource("p3.html");
                break;
            case 4:
                currentPage = this.getClass().getClassLoader().getResource("p4.html");
                break;
        }

        try {
            editorPane.setPage(currentPage);
        } catch (IOException e) {
            e.printStackTrace();
            g.drawString("Error parsing file", 0, 0);
        }
    }

}
