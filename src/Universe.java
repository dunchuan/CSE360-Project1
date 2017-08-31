import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Universe extends JFrame implements ChangeListener {
    private Tutor tutor = new Tutor();
    private Companion companion = new Companion();
    private Assessor assessor = new Assessor();
    private EmptyPane emptyPane = new EmptyPane();
    private ItsPane[] panes = {tutor, companion, assessor, emptyPane};

    public Universe() {
        final int BORDER_GIRTH = 10;

        setName("Universe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.LINE_AXIS));
        upperPanel.add(Box.createHorizontalGlue());
        upperPanel.add(tutor);
        upperPanel.add(Box.createHorizontalGlue());
        upperPanel.add(Box.createRigidArea(new Dimension(BORDER_GIRTH, 1)));
        upperPanel.add(Box.createHorizontalGlue());
        upperPanel.add(companion);
        upperPanel.add(Box.createHorizontalGlue());

        Border border = BorderFactory.createEmptyBorder(BORDER_GIRTH, BORDER_GIRTH, BORDER_GIRTH, BORDER_GIRTH);
        upperPanel.setBorder(border);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.LINE_AXIS));
        lowerPanel.add(Box.createHorizontalGlue());
        lowerPanel.add(assessor);
        lowerPanel.add(Box.createHorizontalGlue());
        lowerPanel.add(Box.createRigidArea(new Dimension(BORDER_GIRTH, 1)));
        lowerPanel.add(Box.createHorizontalGlue());
        lowerPanel.add(emptyPane);
        lowerPanel.add(Box.createHorizontalGlue());
        border = BorderFactory.createEmptyBorder(0, BORDER_GIRTH, BORDER_GIRTH, BORDER_GIRTH);
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
        final int MIN_HEIGHT = upperPanel.getMinimumSize().height * 2 + 3 * BORDER_GIRTH + slider.getMinimumSize().height;
        final Dimension PREF_DIMENSION = new Dimension(MIN_WIDTH, MIN_HEIGHT);
        setMinimumSize(PREF_DIMENSION);
        setPreferredSize(PREF_DIMENSION);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Universe();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        int newState = slider.getValue();

        for (ItsPane pane : panes) {
            pane.changeState(newState);
        }

    }
}
