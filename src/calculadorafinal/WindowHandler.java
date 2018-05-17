/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafinal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author alex
 */
public class WindowHandler extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {

        Window v = (Window)e.getSource();
        v.dispose();

    }
}
