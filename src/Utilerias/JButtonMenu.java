/*
Proposito: está clase nos permite implementar un botón general para todas las vistas.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/

package Utilerias;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonMenu extends JButton{
    
    public JButtonMenu(int x, int y, int ancho, int alto,
            String texto, String mensaje, String imagen, 
            char letra, Component vt){
        setBounds(x, y, ancho, alto);
        setBackground(new Color(226, 0, 82));
        setForeground(Color.white);
        setFont(new Font("Tahoma", 1, 25));
        ImageIcon ii = new ImageIcon(
                vt.getClass().getResource(imagen));
        setIcon(ii);
        setMnemonic(letra);
        setToolTipText(mensaje);
        setText(texto);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));  
    }
}
