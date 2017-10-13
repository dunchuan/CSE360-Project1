
import java.awt.*;

import javax.swing.*;


/**
 * (basic description of program)
 *
 * Recitation Project 1
 * Completion time: 12 hours
 *
 * @author Ian Mwangi , Robert Wasinger * @version 1.1
 */

public class Assessor extends ItsPane {

//    private JCheckBox[] checkBoxes = new JCheckBox[3];

    private CardLayout cl = new CardLayout();

    public AssessorStatus status =  new AssessorStatus();

    public Assessor() {
        setLayout(cl);
        setBackground(Color.WHITE);
        addPanels();
        updateComponent();
    }

    private void addPanels() {
        add("0", buildPanel0());
        add("1", new NumericalPane(status));
        add("2", new BooleanPane(status));
        add("3", new KmapsPane(status));
        add("4", new SopPane(status));

    }

    @Override
    void updateComponent() {
            cl.show(this, "" + state);
    }

    private JPanel buildPanel0() {
        JLabel question0 = new JLabel();

        question0.setFont(new Font("Time New Roman",Font.PLAIN, 18));

        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.PAGE_AXIS));
        panel0.setBackground(Color.WHITE);
        panel0.add(Box.createVerticalGlue());
        panel0.add(new Label("Ian Mwangi"));
        panel0.add(Box.createVerticalGlue());

        return panel0;
    }
}