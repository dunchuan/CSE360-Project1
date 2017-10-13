import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bin2DecPanel extends QuestionsPane {
    NumberSystemProblem system;

    private ArrayList<JTextField> answerFields = new ArrayList<>();

    public Bin2DecPanel(NumberSystemProblem system) {
        this.system = system;
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(createHeader(system.getBin2DecQuestion()));
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        String given = system.getGiven();

        panel.setLayout(new GridLayout(3, given.length()));
        for (int i = 0; i < given.length(); i++)
            panel.add(buildPrettyLabel(given.substring(i, i + 1)));


        for (int i = 0; i < given.length(); i++) {
            panel.add(buildPrettyLabel("2^" + (given.length() - 1 - i)));
        }

        JTextField field;
        for (int i = 0; i < given.length(); i++) {
            field = buildPrettyTextField();
            answerFields.add(field);
            panel.add(field);
        }

        add(panel);
    }



    @Override
    public boolean verify() {
        boolean isCorrect;

        int incorrect = 0;
        for (int i = 0; i < answerFields.size(); i ++) {
            JTextField field = answerFields.get(i);
            isCorrect = system.verifyBinToDec(field.getText(), i);
            if (isCorrect) {
                field.setBackground(Color.GREEN);
            }
            else {
                field.setBackground(Color.RED);
                incorrect++;
            }
        }
        return incorrect == 0;
    }

    @Override
    boolean next() {
        return false;
    }

    @Override
    boolean previous() {
        return false;
    }


}
