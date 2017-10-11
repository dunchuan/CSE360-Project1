
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.io.IOException;
import java.net.URL;

/**
 * The Tutor class is a ItsPane containing an JEditorPane inside a JScrollPane.
 * The HTML file displayed is determined by the state value of it's superclass,
 * ItsPane.
 *
 * Recitation Project 1
 * Completion time: 2 hours
 *
 * @author Robert Wasinger @version 1.0
 */

public class Tutor extends ItsPane implements  HyperlinkListener {
    private JEditorPane editorPane = new JEditorPane();


    public Tutor() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.addHyperlinkListener(this);

        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(getPreferredSize());
        scrollPane.setMaximumSize(getMaximumSize());
        scrollPane.setMinimumSize(getMinimumSize());
        scrollPane.setBorder(null); // Removes Black Border

        add(scrollPane);
        updateComponent();
    }

    @Override
    void updateComponent() {
        URL currentPage;

        switch(state) {
            case 0:
            default:
                currentPage = getClass().getResource("/default.html");
                break;
            case 1:
                currentPage = getClass().getResource("/P1.html");
                break;
            case 2:
                currentPage = getClass().getResource("/P2.html");
                break;
            case 3:
                currentPage = getClass().getResource("/P3.html");
                break;
            case 4:
                currentPage = getClass().getResource("/P4.html");
                break;
        }
        try {
            editorPane.setPage(currentPage);

        } catch (IOException e) {
            editorPane.setText("Failed loading page: " + state + ".");
            e.printStackTrace();
        }
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {

        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                editorPane.setPage(e.getURL());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
