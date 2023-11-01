/*
Proposito: está clase nos permite implementar un botón con efecto roll over general para la vista que lo necesite.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Utilerias;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class JButtonRoll extends JButton{
    
    public JButtonRoll(int x, int y, int ancho, int alto,
            String texto, String mensaje, String imagen1, String imagen2,
            char letra, Component vt){
        setBounds(x, y, ancho, alto);        
        setFont(new Font("Tahoma", 0, 15));
        ImageIcon ii1 = new ImageIcon(
                vt.getClass().getResource(imagen1));
        setIcon(ii1);
        ImageIcon ii2 = new ImageIcon(
                vt.getClass().getResource(imagen2));
        setRolloverIcon(ii2);
        setMnemonic(letra);
        setToolTipText(mensaje);
        setText(texto);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
