/*
Proposito: está clase nos permite implementar un título general para todas las vistas.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.0
*/

package Utilerias;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class JLabelTitulo extends JLabel{
    
    public JLabelTitulo(int alto, String texto, 
            Component vt){
        init(alto, texto, vt);
    }
    
    public JLabelTitulo(int alto, String texto, 
            Component vt, String imagen){
        init(alto, texto, vt);
        ImageIcon img = new ImageIcon(
            vt.getClass().getResource(imagen));
        setIcon(img);
    }
    
    public void init(int alto, String texto, 
            Component vt){
        setBounds(0, 0, vt.getWidth(), alto);
        setOpaque(true);
        setBackground(new Color(38, 0, 77));
        setForeground(Color.WHITE);
        setFont(new Font("Tahoma", Font.BOLD, 30));
        setText(texto);
        setHorizontalAlignment(JLabel.CENTER);
    }    
}
