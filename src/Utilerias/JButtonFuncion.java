/**
 * Clase JButtonFuncion que extiende JButton y proporciona un botón diseñado para funciones específicas.
 * 
 * Este botón personalizado incluye características como posición del texto, mnemotecnia, imagen,
 * y configuraciones visuales para representar funciones específicas.
 * 
 * @version 1.4
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */

package Utilerias;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Clase JButtonFuncion que extiende JButton y proporciona un botón diseñado para funciones específicas.
 * 
 * Este botón personalizado incluye características como posición del texto, mnemotecnia, imagen,
 * y configuraciones visuales para representar funciones específicas.
 */

public class JButtonFuncion extends JButton {
    
    /**
     * Constructor para crear un JButtonFuncion con características específicas.
     *
     * @param x      Coordenada X del botón en el contenedor.
     * @param y      Coordenada Y del botón en el contenedor.
     * @param texto  Texto a mostrar en el botón.
     * @param letra  Mnemotecnia para activar el botón con una tecla de acceso rápido.
     * @param imagen Ruta de la imagen a mostrar en el botón.
     */
    
    public JButtonFuncion(int x,int y, String texto, char letra, String imagen){

        setBounds(x, y, 150, 80);
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
