/**
 * Clase JButtonMenu que extiende JButton y proporciona un botón diseñado para menús.
 * 
 * Este botón personalizado incluye características como fondo de color, color de texto,
 * tamaño de fuente, icono, texto, mensaje emergente y un cursor personalizado.
 * 
 * @version 1.4
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */

package Utilerias;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * Clase JButtonMenu que extiende JButton y proporciona un botón diseñado para menús.
 * 
 * Este botón personalizado incluye características como fondo de color, color de texto,
 * tamaño de fuente, icono, texto, mensaje emergente y un cursor personalizado.
 */
public class JButtonMenu extends JButton{
    
    /**
     * Constructor para crear un JButtonMenu con características específicas.
     *
     * @param x       Coordenada X del botón en el contenedor.
     * @param y       Coordenada Y del botón en el contenedor.
     * @param ancho   Ancho del botón.
     * @param alto    Alto del botón.
     * @param texto   Texto a mostrar en el botón.
     * @param mensaje Mensaje emergente al pasar el mouse sobre el botón.
     * @param imagen  Ruta de la imagen a mostrar en el botón.
     * @param letra   Mnemotecnia para activar el botón con una tecla de acceso rápido.
     * @param vt      Componente padre del botón.
     */
    
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
