import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NumericalPane extends QuestionsPane implements ActionListener {
    private AssessorStatus status;
    private CardLayout cl = new CardLayout();
    private JPanel questionsPanel = new JPanel();

    private int currentCard = 0;
    ArrayList<Bin2DecPanel> questions = new ArrayList<>();

    public NumericalPane(AssessorStatus status) {
        this.status = status;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);

        questionsPanel.setLayout(cl);

        for (int i = 0; i < 10; i++)
            questions.add(new Bin2DecPanel(status));

        for (Bin2DecPanel q : questions)
            questionsPanel.add(q);

        add(questionsPanel);
        add(createNavigationPane(this));
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            questions.get(currentCard).verify();
        }
        else if (e.getActionCommand().equals("Next")) {
            cl.next(questionsPanel);
            status.setValue(ProblemStatus.NEW);
            currentCard++;
            currentCard %= 10;
        }
            else if (e.getActionCommand().equals("Previous")) {
            cl.previous(questionsPanel);
            status.setValue(ProblemStatus.NEW);
            currentCard--;
            currentCard %= 10;

        }
    }
}
