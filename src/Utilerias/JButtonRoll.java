/**
 * Clase JButtonRoll que extiende JButton y proporciona un botón con efecto rollover.
 * 
 * Este botón personalizado incluye características como un icono, texto, mensaje emergente,
 * y un efecto visual cuando el mouse pasa sobre el botón.
 * 
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */

package Utilerias;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase JButtonRoll que extiende JButton y proporciona un botón con efecto rollover.
 * 
 * Este botón personalizado incluye características como un icono, texto, mensaje emergente,
 * y un efecto visual cuando el mouse pasa sobre el botón.
 */

public class JButtonRoll extends JButton{
    
    /**
     * Constructor para crear un JButtonRoll con características específicas.
     *
     * @param x       Coordenada X del botón en el contenedor.
     * @param y       Coordenada Y del botón en el contenedor.
     * @param ancho   Ancho del botón.
     * @param alto    Alto del botón.
     * @param texto   Texto a mostrar en el botón.
     * @param mensaje Mensaje emergente al pasar el mouse sobre el botón.
     * @param imagen1 Ruta de la imagen a mostrar en el botón.
     * @param letra   Mnemotecnia para activar el botón con una tecla de acceso rápido.
     * @param vt      Componente padre del botón.
     */
    
    public JButtonRoll(int x, int y, int ancho, int alto,
            String texto, String mensaje, String imagen1,
            char letra, Component vt){
        setBounds(x, y, ancho, alto);        
        setFont(new Font("Tahoma", 0, 15));
        ImageIcon ii1 = new ImageIcon(
                vt.getClass().getResource(imagen1));
        setIcon(ii1);
        setMnemonic(letra);
        setToolTipText(mensaje);
        setText(texto);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
