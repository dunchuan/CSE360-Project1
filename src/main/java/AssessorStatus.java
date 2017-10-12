import java.util.Observable;

public class AssessorStatus extends Observable {

    public enum ProblemStatus {
        PERFECT, TROUBLE, BAD, SOLVED
    }

    private ProblemStatus status = ProblemStatus.PERFECT;

    public void setValue(ProblemStatus newStatus) {
        status = newStatus;
        setChanged();
        notifyObservers();
    }

    public ProblemStatus getValue()
    {
        return status;
    }
}
