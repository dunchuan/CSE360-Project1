import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NumericalPane extends QuestionsPane implements ActionListener {
    private AssessorStatus status;
    private CardLayout cl = new CardLayout();
    private JPanel questionsPanel = new JPanel();



    private boolean currentCorrect = false;

    private int currentCard = 0;
    ArrayList<QuestionsPane> questions = new ArrayList<>();

    public NumericalPane(AssessorStatus status) {
        this.status = status;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        questionsPanel.setLayout(cl);

        for (int i = 0; i < 10; i++) {
            NumericalProblemPanel curProb = new NumericalProblemPanel();
            questionsPanel.add(curProb);
            questions.add(curProb);
        }

        add(questionsPanel);
        add(createNavigationPane(this));
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            currentCorrect = questions.get(currentCard).verify();
            if (currentCorrect)
                status.setValue(ProblemStatus.PERFECT);
            else
                status.setValue(ProblemStatus.TROUBLE);
        }
        else if (e.getActionCommand().equals("Next") && currentCorrect) {
            boolean nextStepPresent = questions.get(currentCard).next();
            if (!nextStepPresent) {
                cl.next(questionsPanel);
                currentCard++;
            }
            status.setValue(ProblemStatus.NEW);
            currentCorrect = false;
        } else if (e.getActionCommand().equalsIgnoreCase("Next") && !currentCorrect)
            status.setValue(ProblemStatus.WRONG);
    }

    @Override
    boolean verify() {
        return questions.get(currentCard).verify();
    }

    @Override
    boolean next() {
//        currentCard++;
//        currentCard %= 10;
//        return questions.get(currentCard).next();
        return false;
}

    @Override
    boolean previous() {
//        currentCard--;
//        currentCard %= 2;
//        return questions.get(currentCard).previous();
        return false;
    }
}
