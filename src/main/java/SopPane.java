import javax.swing.*;
import java.awt.*;

public class SopPane extends QuestionsPane {
    public SopPane(AssessorStatus status) {
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
