import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NumericalPane extends QuestionsPane implements ActionListener {
    NumberSystemProblem system = new NumberSystemProblem(4);
    ArrayList<JTextField> answerFields = new ArrayList<>();

    public NumericalPane() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);

        JPanel header = createHeader(system.getQuestion());
        add(header);
        add(buildStep1());
        add(createNavigationPane(this));
    }

    JPanel buildStep1() {
        System.out.println(system.getGiven().length() + " X " + "2");
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        String given = system.getGiven();

        panel.setLayout(new GridLayout(3, given.length()));
        for (int i = 0; i < given.length(); i++)
            panel.add(buildPrettyLabel(given.substring(i, i + 1)));

        for (int i = 0; i < given.length(); i++)
            panel.add(buildPrettyLabel("2^" + (given.length() - 1 - i)));

        for (int i = 0; i < given.length(); i++)
            panel.add(buildPrettyTextField());

        return panel;
    }

    private JLabel buildPrettyLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("Time New Roman",Font.PLAIN, 18));

        return label;
    }

    private JTextField buildPrettyTextField() {
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        answerFields.add(textField);

        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            for (int i = 0; i < answerFields.size(); i ++) {
                JTextField field = answerFields.get(i);
                boolean correct = system.verifyBinToDec(field.getText(), i);
                if (correct)
                    field.setBackground(Color.GREEN);
                else
                    field.setBackground(Color.RED);
            }

        }

    }
}
