import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bin2DecPanel extends QuestionsPane {
    NumberSystemProblem system = new NumberSystemProblem(3);

    private ArrayList<JTextField> answerFields = new ArrayList<>();
    AssessorStatus status;

    public Bin2DecPanel(AssessorStatus status) {
        setBackground(Color.WHITE);
        this.status = status;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(createHeader(system.getQuestion()));
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

        add(panel);
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

    public void verify() {
        boolean correct = false;
        for (int i = 0; i < answerFields.size(); i ++) {
            JTextField field = answerFields.get(i);
            correct = system.verifyBinToDec(field.getText(), i);
            if (correct)
                field.setBackground(Color.GREEN);
            else
                field.setBackground(Color.RED);
        }
        if (correct)
            status.setValue(ProblemStatus.PERFECT);
        else
            status.setValue(ProblemStatus.TROUBLE);
    }

}
