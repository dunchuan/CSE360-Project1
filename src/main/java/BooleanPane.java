import javax.swing.*;
import java.awt.*;

public class BooleanPane extends QuestionsPane {

    public BooleanPane(AssessorStatus status) {
        setBackground(Color.WHITE);
        add(new JLabel("Not yet implemented"));
    }

    @Override
    boolean verify() {
        return false;
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
