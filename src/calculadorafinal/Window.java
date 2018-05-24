/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafinal;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author alex
 */
public class Window extends Frame {
    
    private ArrayList al;
    
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
            JList<String> jList1 = new JList<>(model);
            JButton submit = new JButton("Aceptar");

            
            ButtonHandler butHand = new ButtonHandler(display, jList1, model, JLabel1, al);
            ListHandler lHandler = new ListHandler(display, model, jList1);
            
            
            display.setBounds(10, 50, 480, 30);
            this.add(display);
            display.addActionListener((ActionListener) butHand);


            JLabel1.setBounds(10, 90, 100, 30);
            this.add(JLabel1);
            JLabel1.setVisible(true);
            
            jList1.setBounds(10, 120, 480, 130);
            this.add(jList1);
            jList1.setVisible(true);
            jList1.addMouseListener((MouseListener)lHandler);
            
            JScrollPane jScrollPane1 = new JScrollPane(jList1);
            this.add(jScrollPane1);
            jScrollPane1.setBounds(10, 120, 480, 130);
            jScrollPane1.getViewport().add(jList1);
            jList1.setMinimumSize(new Dimension(100,100));
            
            submit.setBounds(200, 260, 100, 30);
            this.add(submit);
            submit.addActionListener((ActionListener)butHand);

            
            this.setVisible(true);
            
            butHand.readHistory();
	}
}
