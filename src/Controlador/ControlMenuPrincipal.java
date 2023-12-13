/**
 * Nos permite controlar la acciones de la vista menu principal
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 20-10-2023
 */
package Controlador;

import Vista.AcercaDe;
import Vista.ActualizarUsuario;
import Vista.ConsultarUsuario;
import Vista.CrearProducto;
import Vista.CrearUsuario;
import Vista.Graficos;
import Vista.Listados;
import Vista.Membresia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuPrincipal;
import Vista.ModificarProducto;
import Vista.TipoConsulta;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;


/**
 * Nos permite controlar la acciones de la vista menu principal
 */
public class ControlMenuPrincipal implements ActionListener, WindowListener {
    /**
     * Instancia de MenuPrincipal.
     */
    MenuPrincipal mp; // crea un obj de la clase que controla
    /**
     * Almacena el nivel de privilegios del usuario.
     */    
    String privilegios = "";
    /**
     * Constructor que recibe una instancia de MenuPrincipal y los privilegios del usuario.
     *
     * @param obj Instancia de MenuPrincipal.
     * @param privi Privilegios del usuario.
     */
    public ControlMenuPrincipal(MenuPrincipal obj, String privi) {
        mp = obj; // Guarda el objeto que recibe de MenuAdministrador en la variable antes creado
        privilegios = privi;
    }
    /**
     * {@inheritDoc}
     */    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mp.jbNuevoUsuario)) {
            CrearUsuario cu = new CrearUsuario(mp, privilegios);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbAcerca)) {
            AcercaDe ad = new AcercaDe(mp);
            mp.setVisible(true);
        }

        if (e.getSource().equals(mp.jbConsultarUsuario)) {
            // System.out.println("Clic en jbGrafica");
            TipoConsulta tc = new TipoConsulta(mp, privilegios);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbListados)) {
            // System.out.println("Clic en jbGrafica");
            Listados l = new Listados(mp, privilegios);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbActualizar)) {
            // System.out.println("Clic en jbGrafica");
            ActualizarUsuario au = new ActualizarUsuario(mp, privilegios);
            mp.setVisible(false);
        }

        if (e.getSource().equals(mp.jbEstadistica)) {
            Graficos g = new Graficos(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbProducto)) {
            CrearProducto cp = new CrearProducto(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbActualizarProd)) {
            ModificarProducto cp = new ModificarProducto(mp);
            mp.setVisible(false);
        }
        if(e.getSource().equals(mp.jbRenovarMembresia)){
            Membresia rm = new Membresia(mp);
            mp.setVisible(false);
        }
    }
    /**
     * Método para manejar el evento de salir de la aplicación.
     */
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(mp,
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
    /**
     * {@inheritDoc}
     */
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