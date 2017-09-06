package cse.pkg360;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/** The Companion class is a state machine reflecting the progress
 *      of the student.
 *
 *
 */

public class Companion extends javax.swing.JPanel  {
   private javax.swing.JLabel jLabel1;
   private Image image;

    public Companion() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        updateComponent();
    }

    void updateComponent() {
        URL imagePath = null;
        removeAll();
        
        switch(state) {
            default:
            case 0:
                add(label);
                break;
            case 1:
                initHappy();
                //imagePath = Companion.class.getClassLoader().getResource("happy.png");
                break;
            case 2:
                initThink();
                //imagePath = Companion.class.getClassLoader().getResource("thinking.png");
                break;
            case 3:
                initWorry();
                //imagePath = Companion.class.getClassLoader().getResource("worry.png");
                break;
            case 4:
                initSad();
                //imagePath = Companion.class.getClassLoader().getResource("sad.png");
                break;
        }
        if (imagePath != null) {
            try {
                image = ImageIO.read(imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")                          
    private void initHappy() {

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/happy.png"))); // NOI18N
        jLabel1.setMaximumSize(getPreferredSize());
        jLabel1.setMinimumSize(getPreferredSize());
        jLabel1.setPreferredSize(getPreferredSize());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Happy");
        jLabel1.getAccessibleContext().setAccessibleDescription("Happy Face");
    }
    
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initThink() {

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/thinking.png"))); // NOI18N
        jLabel1.setMaximumSize(getPreferredSize());
        jLabel1.setMinimumSize(getPreferredSize());
        jLabel1.setPreferredSize(getPreferredSize());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Thinking");
        jLabel1.getAccessibleContext().setAccessibleDescription("Think Face");
    }// 
    
    private void initWorry() {

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/worry.png"))); // NOI18N
        jLabel1.setMaximumSize(getPreferredSize());
        jLabel1.setMinimumSize(getPreferredSize());
        jLabel1.setPreferredSize(getPreferredSize());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Worry");
        jLabel1.getAccessibleContext().setAccessibleDescription("Worried Face");
    }
    
    private void initSad() {

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sad.png"))); // NOI18N
        jLabel1.setMaximumSize(getPreferredSize());
        jLabel1.setMinimumSize(getPreferredSize());
        jLabel1.setPreferredSize(getPreferredSize());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Sad");
        jLabel1.getAccessibleContext().setAccessibleDescription("Sad Face");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

    }
}
