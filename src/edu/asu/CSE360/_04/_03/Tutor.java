package edu.asu.CSE360._04._03;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

/* The Tutor Class shows the meaningful feedback based
 *      upon student progress within the steps.
 */

public class Tutor extends ItsPane {
    private JEditorPane editorPane = new JEditorPane();

    public Tutor() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        editorPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
                currentPage = getClass().getResource("/p1.html");
                break;
            case 2:
                currentPage = getClass().getResource("/p2.html");
                break;
            case 3:
                currentPage = getClass().getResource("/p3.html");
                break;
            case 4:
                currentPage = getClass().getResource("/p4.html");
                break;
        }
        try {
            editorPane.setPage(currentPage);

        } catch (IOException e) {
            editorPane.setText("Failed loading page: " + state + ".");
            e.printStackTrace();
        }
    }
}