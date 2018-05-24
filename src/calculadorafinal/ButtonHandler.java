/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class ButtonHandler implements ActionListener {
    private JTextField tF;
    private DefaultListModel<String> model;
    private JList<String> l;
    private JLabel label;
    private ArrayList al;
	
    public ButtonHandler (JTextField tF, JList l, DefaultListModel model, JLabel label, ArrayList al){
        this.tF = tF;
        this.l = l;
        this.model = model;
        this.label = label;
        this.al = al;
    }
    
    public void readHistory(){
        try {
            FileInput fi = new FileInput();
            al = fi.Leer();
            model.clear();
            al.forEach((o) -> {
                model.addElement((String) o);
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            Logger.getLogger(ButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tF.getText(), response;
        if((response = ExpEval.eval(str)) != null){
            tF.setText(response);
            try {
                FileOutput.Escribir(str);
            } catch (IOException ex) {
                Logger.getLogger(ButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            readHistory();
            l.setVisible(true);
            label.setVisible(true);
        }else{
            tF.setText("Ingresa una expresión válida");
        }
    }
}
