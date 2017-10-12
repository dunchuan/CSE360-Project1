
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * The Universe Class uses the BoxLayout to align child horizontally and
 * vertically with n rows of two panes.  The panes maintain their alignment as
 * the panel is resized.
 *
 * Recitation Project 2
 * Completion time: 2 hours
 *
 * @author Robert Wasinger * @version 1.1
 */

public class Universe extends JFrame implements ChangeListener {
    private Tutor tutor = new Tutor();
    private Companion companion = new Companion();
    private Assessor assessor = new Assessor();
    private EmptyPane emptyPane = new EmptyPane();
    private ItsPane[] panes = {tutor, assessor, companion, emptyPane};

    private final int BORDER_GIRTH = 10;

    public Universe() {

        setName("Universe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel upperPanel = createRow(tutor, companion);
        Border border = BorderFactory.createEmptyBorder(BORDER_GIRTH, BORDER_GIRTH,
                BORDER_GIRTH, BORDER_GIRTH);
        upperPanel.setBorder(border);

        JPanel lowerPanel = createRow(assessor, emptyPane);
        border = BorderFactory.createEmptyBorder(0, BORDER_GIRTH, BORDER_GIRTH,
                BORDER_GIRTH);
        lowerPanel.setBorder(border);

        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.PAGE_AXIS));
        masterPanel.add(Box.createVerticalGlue());
        masterPanel.add(upperPanel);
        masterPanel.add(Box.createVerticalGlue());
        masterPanel.add(lowerPanel);
        masterPanel.add(Box.createVerticalGlue());

        JSlider slider = new JSlider(1, 4, 1);
        slider.addChangeListener(this);
        masterPanel.add(slider);
        setContentPane(masterPanel);

        final int MIN_WIDTH = upperPanel.getMinimumSize().width + 3 * BORDER_GIRTH;

        final int MIN_HEIGHT = upperPanel.getMinimumSize().height * 2 +
                3 * BORDER_GIRTH + slider.getMinimumSize().height;

        final Dimension PREF_DIMENSION = new Dimension(MIN_WIDTH, MIN_HEIGHT);
        setMinimumSize(PREF_DIMENSION);
        setPreferredSize(PREF_DIMENSION);
        assessor.status.addObserver(companion);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Universe();
    }

    private JPanel createRow(JPanel left, JPanel right) {

        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.LINE_AXIS));
        row.add(Box.createHorizontalGlue());
        row.add(left);
        row.add(Box.createHorizontalGlue());
        row.add(Box.createRigidArea(new Dimension(BORDER_GIRTH, 1)));
        row.add(Box.createHorizontalGlue());
        row.add(right);
        row.add(Box.createHorizontalGlue());

        return row;
    }

    // This method needed to be updated because multiple events were being
    // sent by the slider
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        int newState = slider.getValue();

        if (newState != ItsPane.state) {
            for (ItsPane pane : panes) {
                pane.changeState(newState);
            }
        }

    }
}
