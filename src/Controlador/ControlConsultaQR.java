/**
 * Proposito: Gestiona las interacciones de la consulta por medio de QR.
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 4-12-2023
 */
package Controlador;

import Utilerias.Conexion;
import static Utilerias.DatosConexion.baseDatos;
import static Utilerias.DatosConexion.host;
import static Utilerias.DatosConexion.login;
import static Utilerias.DatosConexion.user;
import Vista.ConsultaQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;


/**
 * Proposito: Gestiona las interacciones de la consulta por medio de QR.
 */

public class ControlConsultaQR implements ActionListener, WindowListener {
    /**
     * Instancia de la vista ConsultaQR.
     */
    ConsultaQR cqr;
    /**
     * Constructor que recibe la instancia de la vista ConsultaQR.
     *
     * @param cqr Instancia de ConsultaQR.
     */
    public ControlConsultaQR(ConsultaQR cqr) {
        this.cqr = cqr;
    }
    // Métodos de ActionListener
    
    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cqr.jbvolver)){
            volver();
        }

        if (e.getSource().equals(cqr.jbCrear)) {
            Conexion con = new Conexion();
            boolean error = con.conectarMySQL(baseDatos, user, login, host);
            if (!error) {
                String datos[] = con.consultaFila("usuario", "cedula_usuario", cqr.jtTexto.getText());
                if (datos == null) {
                    JOptionPane.showMessageDialog(cqr, "El usuario con cedula "
                            + cqr.jtTexto.getText() + " no existe en la tabla");
                } else {
                    String contenidoCodigo = "Cédula: " + datos[0] + "\nNombre: " + datos[1] + "\nApellido: " + datos[2]
                            + "\nEmail: " + datos[6] + "\nTipo de usuario: " + datos[7] + "\nEstado: " + datos[8];
                    String nombreQr = "codigo_qr" + datos[1];
                    ByteArrayOutputStream outStream = QRCode.from(contenidoCodigo).withSize(400, 400).stream();
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(outStream.toByteArray());

                    BufferedImage bf = null;
                    try {
                        bf = ImageIO.read(inputStream);
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(cqr, f);
                    }

                    File f = new File("src/imagenesQR/" + nombreQr + ".png");
                    try {
                        ImageIO.write(bf, "png", f);
                        Thread.sleep(2000);

                        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenesQR/" + nombreQr + ".png"));
                        cqr.jlCod.setIcon(icono);

                        f.delete();

                    } catch (Exception i) {
                        JOptionPane.showMessageDialog(cqr, i);
                    }
                }
            }
        }
    }
    /**
     * Método para volver a la vista anterior.
     */    
    private void volver() {
        cqr.setVisible(false);
        cqr.dispose();
        cqr.tc.ma.setVisible(true);
    }
    /**
     * Método para manejar el evento de salir de la aplicación.
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(cqr,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    // Métodos de WindowListener (sin implementación detallada)
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowOpened(WindowEvent e) {
        
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowClosing(WindowEvent e) {
        evento_salir();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowClosed(WindowEvent e) {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowActivated(WindowEvent e) {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}