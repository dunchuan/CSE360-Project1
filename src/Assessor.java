import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** The Accessor Class Shows the questions and uses listeners to change the model
 *
 *
 */
public class Assessor extends ItsPane implements ActionListener {

    private JLabel questionLabel = new JLabel("Preferred Language");
    private String[] comboWords = {"Java", "Python", "Swift", "Haskell"};
    private JComboBox<String> comboBox = new JComboBox<>(comboWords);

    private JCheckBox check1 = new JCheckBox("Object Oriented Programming", false);
    private JCheckBox check2 = new JCheckBox("Functional Programming", false);
    private JCheckBox check3 = new JCheckBox("Declarative Programming", false);

    private JButton but1 = new JButton("Blue");
    private JButton but2 = new JButton("Purple");
    private JButton but3 = new JButton("Orange");
    private JButton but4 = new JButton("Green");

    private JTextArea textArea = new JTextArea();

    public Assessor() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        but2.addActionListener(this);
        but4.addActionListener(this);
        updateComponent();
    }

    @Override
    void updateComponent() {
        removeAll();
        switch (state) {
            case 0:
            default:
                add(new JLabel("Assessor.java"));
                break;
            case 1:
                questionLabel.setText("Preferred Language");
                add(questionLabel);
                add(comboBox);
                break;
            case 2:
                questionLabel.setText("Programming Paradigms");
                add(questionLabel);
                add(check1);
                add(check2);
                add(check3);
                break;
            case 3:
                questionLabel.setText("What color is the sky?");
                add(questionLabel);
                add(but1);
                add(but2);
                add(but3);
                add(but4);
                break;
            case 4:
                questionLabel.setText("What is your name?");
                add(textArea);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this,"That's strange");
    }
}