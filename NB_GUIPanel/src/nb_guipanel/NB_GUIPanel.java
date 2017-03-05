/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_guipanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Gio
 */
public class NB_GUIPanel extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private morepanel.CanvasLineSimple frame1 = null;
    private morepanel.CanvasLine frame2 = null;
    private morepanel.BounceThreadFrame frame3 = null;

    public NB_GUIPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180, 200);
        setLayout(new FlowLayout());

        //create button
        button1 = new JButton("Disegna Linee parallele");
        button1.addActionListener(this);
        add(button1);

        //create button
        button2 = new JButton("Disegna Linee");
        button2.addActionListener(this);
        add(button2);

        //create button
        button3 = new JButton("Palline rimbalzanti");
        button3.addActionListener(this);
        add(button3);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            if (frame1 == null) {
                frame1 = new morepanel.CanvasLineSimple();
            }
            showFrame(frame1);
        } else if (e.getSource() == button2) {
            if (frame2 == null) {
                frame2 = new morepanel.CanvasLine();
            }
            showFrame(frame2);
        } else if (e.getSource() == button3) {
            if (frame3 == null) {
                frame3 = new morepanel.BounceThreadFrame();
            }
            showFrame(frame3);
        }
    }

    private static void showFrame(JFrame f) {
        if (!f.isVisible()) {
            f.setVisible(true);
        } else if (f.isVisible()) {
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        try {
            NB_GUIPanel frame = new NB_GUIPanel();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
