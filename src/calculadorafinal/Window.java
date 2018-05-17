/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafinal;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

/**
 *
 * @author alex
 */
public class Window extends Frame {
    public Window(){
		
	}
	
	public Window(String titulo, int x, int y, int width, int height){
	
            super(titulo);
            this.setBounds(x, y, width, height);
            this.setLayout(null);
            WindowHandler winHand = new WindowHandler();
            this.addWindowListener(winHand);

            DefaultListModel<String> model = new DefaultListModel<>();

            JTextField display = new JTextField();
            JLabel JLabel1 = new JLabel("Historial");
            JList<String> JList1 = new JList<>(model);
            JButton submit = new JButton("Aceptar");

            
            buttonHandler butHand = new buttonHandler(display, JList1, model, JLabel1);
            ListHandler lHandler = new ListHandler(display, model, JList1);
            
            
            display.setBounds(10, 50, 480, 30);
            this.add(display);
            display.addActionListener((ActionListener) butHand);


            JLabel1.setBounds(10, 90, 100, 30);
            this.add(JLabel1);
            JLabel1.setVisible(false);


            JList1.setBounds(10, 120, 480, 130);
            this.add(JList1);
            JList1.setVisible(false);
            JList1.addMouseListener((MouseListener)lHandler);


            submit.setBounds(200, 260, 100, 30);
            this.add(submit);
            submit.addActionListener((ActionListener)butHand);

            
            this.setVisible(true);
	}
}
