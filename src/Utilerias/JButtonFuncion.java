/*
Proposito: está clase nos permite implementar un botón de manera rápida y general para la vista que lo necesite.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Utilerias;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonFuncion extends JButton {
    
    public JButtonFuncion(int x, String texto, char letra, String imagen){

        setBounds(x, 360, 150, 80);
        setText(texto);
        ImageIcon ii = new ImageIcon(getClass().getResource(imagen));
        setIcon(ii);
        setMnemonic(letra);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
