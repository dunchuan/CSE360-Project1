import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bin2HexPanel extends QuestionsPane {

    NumberSystemProblem system;
    ArrayList<JTextField> fields = new ArrayList<>();

    public Bin2HexPanel(NumberSystemProblem system) {
        this.system = system;

        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(createHeader(system.getBin2HexQuestion()));
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        String given = system.hexGroups();
        String[] givenSplit = given.split(" ");

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < givenSplit.length; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
            panel.add(buildPrettyLabel(givenSplit[i]), gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField field = buildPrettyTextField();
        fields.add(field);
        panel.add(field, gbc);

        add(panel);
    }

    @Override
    public boolean verify() {
        boolean isCorrect = false;
        int incorrectCount = 0;
        for (int i =0; i < fields.size(); i++) {
            JTextField field = fields.get(i);
            String answer = field.getText();
            isCorrect = system.verifyBinToHex(answer, i);
            if (isCorrect)
                field.setBackground(Color.GREEN);
            else {
                incorrectCount++;
                field.setBackground(Color.RED);
            }
        }
        return incorrectCount == 0;
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
