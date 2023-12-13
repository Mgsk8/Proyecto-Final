/**
 * Clase que extiende JLabel y personaliza la apariencia de etiquetas utilizadas
 * como títulos en la interfaz gráfica.
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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase que extiende JLabel y personaliza la apariencia de etiquetas utilizadas
 * como títulos en la interfaz gráfica.
 */

public class JLabelTitulo extends JLabel{
    /**
     * Constructor que inicializa la etiqueta con el alto, texto y componente
     * visual asociado.
     *
     * @param alto Alto de la etiqueta.
     * @param texto Texto de la etiqueta.
     * @param vt Componente visual asociado.
     */
    
    public JLabelTitulo(int alto, String texto, 
            Component vt){
        init(alto, texto, vt);
    }
    
    /**
     * Constructor que inicializa la etiqueta con el alto, texto, componente
     * visual asociado e imagen.
     *
     * @param alto Alto de la etiqueta.
     * @param texto Texto de la etiqueta.
     * @param vt Componente visual asociado.
     * @param imagen Ruta de la imagen a mostrar en la etiqueta.
     */
    public JLabelTitulo(int alto, String texto, 
            Component vt, String imagen){
        init(alto, texto, vt);
        ImageIcon img = new ImageIcon(
            vt.getClass().getResource(imagen));
        setIcon(img);
    }
    
    /**
     * Inicializa los atributos y la apariencia de la etiqueta.
     *
     * @param alto Alto de la etiqueta.
     * @param texto Texto de la etiqueta.
     * @param vt Componente visual asociado.
     */
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
