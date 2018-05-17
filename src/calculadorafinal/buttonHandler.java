/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class buttonHandler implements ActionListener {
    private JTextField tF;
    private DefaultListModel<String> model;
    private JList<String> l;
    private JLabel label;
	
    public buttonHandler (JTextField tF, JList l, DefaultListModel model, JLabel label){
        this.tF = tF;
        this.l = l;
        this.model = model;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tF.getText(), response;
        if((response = ExpEval.eval(str)) != null){
            tF.setText(response);
            model.addElement(str);
            l.setVisible(true);
            label.setVisible(true);
        }else{
            tF.setText("Ingresa una expresión válida");
        }
    }
}
