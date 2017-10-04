import javax.swing.*;
import java.awt.*;

public class BooleanQuestionPane extends JPanel {
    private BooleanCircuit circuit = new BooleanCircuit("A (B + C) + C", BooleanCircuit.TreeType.SOP);

    private JLabel questionLabel = new JLabel(circuit.toString());

    public BooleanQuestionPane() {
        setLayout(new GridLayout(2, 1));
        add(questionLabel, 1, 0);
        add(new AnswerPanel());
    }

    private class AnswerPanel extends JPanel {
        private JButton answer1 = new JButton("A");
        private JButton answer2 = new JButton("B");
        private JButton answer3 = new JButton("C");
        private JButton answer4 = new JButton("D");

        public AnswerPanel() {
            setLayout(new GridLayout(2, 2));
            add(answer1);
            add(answer2);
            add(answer3);
            add(answer4);
        }
    }
}
