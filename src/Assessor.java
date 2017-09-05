import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/** The Accessor Class Shows the questions and uses listeners to change the model
 *
 *
 */
@SuppressWarnings("serial")
public class Assessor  extends ItsPane implements ActionListener {
    public Assessor() {
        setBackground(Color.BLUE);
    }
    
    String names = "Hello World,\n My name is Ian Mwangi"; 
    JTextField name= new JTextField(names);
    
    String options [] = {"Option 1","Option 2","Option 3","Option 4","Option 5"};
    @SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox combo= new JComboBox(options);
   
    
    JTextArea txtArea = new JTextArea("Type Here ");
    
    JCheckBox check1= new JCheckBox("Option 1");
    JCheckBox check2= new JCheckBox("Option 2");
    JCheckBox check3= new JCheckBox("Option 3");

    JRadioButton b1=new JRadioButton(" Option 1");    
    JRadioButton b2=new JRadioButton(" Option 2"); 
    JRadioButton b3=new JRadioButton(" Option 3"); 
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
		switch (state) {
            case 0:
            default:
                g.drawString("Accessor.java", 20, 20);    
                name.setBounds(55,150,300,40);
                add(name);
 
                break;
            case 1:
                g.drawString("Menu", 20, 20);
               combo.setBounds(75,60,100,40); 
                add(combo);
                
                combo.addActionListener(this);
               
                break;
            case 2:
                g.drawString("CheckBoxes", 20, 20);
                check1.setBounds(75,50,100,30); 
                check2.setBounds(75,75,100,30); 
                check3.setBounds(75,100,100,30); 
                add(check1);  
                add(check2); 
                add(check3);
                check1.addActionListener(this);
                check2.addActionListener(this);
                check3.addActionListener(this);
                        
                break;
            case 3:
            	
                g.drawString("Buttons", 20, 20);
                b1.setBounds(75,50,100,30); 
                b2.setBounds(75,75,100,30); 
                b3.setBounds(75,100,100,30); 
                ButtonGroup item=new ButtonGroup();  
                item.add(b1);
                item.add(b2); 
                item.add(b3);
                add(b1);
                add(b2);
                add(b3);
                b1.addActionListener(this); 
                b2.addActionListener(this); 
                b3.addActionListener(this);
                             
                break;
            case 4:
                g.drawString("Text field", 20, 20);
                txtArea.setBounds(75,50,250,150); 
                add(txtArea);
                txtArea.setEditable(true);
                
                break;
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(check3.isSelected())
		System.out.println("Option 3 is correct");
		else 
			System.out.println("Option valid");
		
		
			
			
	}
}