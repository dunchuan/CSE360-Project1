import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class QuestionsPane extends JPanel {
    protected JPanel createHeader(String title) {
        JPanel header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));
        header.add(Box.createHorizontalGlue());

        JLabel label = new JLabel();
        label.setFont(new Font("Time New Roman",Font.PLAIN, 18));
        label.setText(title);
        header.add(label);
        header.add(Box.createHorizontalGlue());
        return header;
    }

    protected JPanel createNavigationPane(ActionListener listener) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(1, 3));
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(listener);
        panel.add(prevButton);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(listener);
        panel.add(submitButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(listener);
        panel.add(nextButton);

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        return panel;
    }
}
