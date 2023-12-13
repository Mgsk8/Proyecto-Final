/**
 * Clase que genera un documento PDF para el comprobante de membresía del cliente.
 *
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */

package Utilerias;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase que genera un documento PDF para el comprobante de membresía del cliente.
 */
public class ClienteMembresiaPDF {
    
    /**
     * Lista de datos del usuario.
     */
    ArrayList<String> datosUsu;

    /**
     * Lista de datos del cliente.
     */
    ArrayList<String> datosCli;

    /**
     * Lista de datos de la membresía.
     */
    ArrayList<String> datosMem;

    /**
     * Constructor por defecto de la clase.
     */
    public ClienteMembresiaPDF(){}
    /**
     * Constructor que recibe listas de datos como parámetros.
     *
     * @param datosUsu Lista de datos del usuario.
     * @param datosCli Lista de datos del cliente.
     * @param datosMem Lista de datos de la membresía.
     */
    public ClienteMembresiaPDF(ArrayList<String> datosUsu, ArrayList<String> datosCli, ArrayList<String> datosMem)
    {
    this.datosUsu = datosUsu;
    this.datosCli = datosCli;
    this.datosMem = datosMem;
    prueba(datosUsu, datosCli, datosMem);
    }

    /**
     * Método de prueba que genera el documento PDF.
     *
     * @param datosUsu Lista de datos del usuario.
     * @param datosCli Lista de datos del cliente.
     * @param datosMem Lista de datos de la membresía.
     */
    public void prueba(ArrayList<String> datosUsu, ArrayList<String> datosCli, ArrayList<String> datosMem) {
    //public void prueba() {
        // step 1: creation of a document-object        
        Document document = new Document();

        try {
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("recibo_de_membresia.pdf"));

            // step 3: we open the document
            document.open();
            
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());

            //--------------------- pagina 1 --------------------------
            g.setColor(Color.red);
            g.drawRect(1, 1, 593, 790);    
            
            g.setColor(new Color(154, 171, 237));
            g.fillOval(195, 160, 400, 150);
                        
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 35);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Comprobante de pago", 10, 150);
            g.drawString("brokogym_systems", 220, 230);
            
            g.setColor(Color.WHITE);
            g.drawString("brokogym_systems", 220, 230);
            
            
            Font font2 = new Font("Tahoma", Font.PLAIN, 15);
            g.setFont(font2);
            g.setColor(Color.BLACK);
            g.drawString("Señor/a " + datosUsu.get(1) + ". Identificado con la cédula " + datosUsu.get(0) + ".", 50, 360);
            g.drawString("Su pago a la incripción " + datosMem.get(3) + " se ha realizado exitosamente.", 50, 380);
            g.drawString("Fecha de inicio: " + datosMem.get(1), 50, 400);
            g.drawString("Fecha de fin: " + datosMem.get(2), 50, 420);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        JOptionPane.showMessageDialog(null, 
                "Se creo el comprobante de inscripción en la carpeta del proyecto");
    }
    
}
