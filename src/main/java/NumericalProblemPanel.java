import java.awt.*;

public class NumericalProblemPanel extends QuestionsPane {
    private CardLayout cl = new CardLayout();
    private QuestionsPane[] steps = new QuestionsPane[2];
    private int currentStep = 0;
    private boolean currentCorrect = false;
    NumberSystemProblem problem = new NumberSystemProblem(3);
    public NumericalProblemPanel() {
        setLayout(cl);
        steps[0] = new Bin2DecPanel(problem);
        steps[1] = new Bin2HexPanel(problem);
        add(steps[0]);
        add(steps[1]);
    }

    @Override
    public boolean next() {
        if (currentStep == 0 && currentCorrect) {
            currentStep++;
            cl.next(this);
            return true;
        }
        if (currentStep == 1 && currentCorrect) {
            return false;
        }
        return true;
    }

    @Override
    boolean previous() {
        return false;
    }

    @Override
    boolean verify()
    {
        currentCorrect = steps[currentStep].verify();
        return currentCorrect;
    }
}
