/**
 * ControlAcercaDe es la clase que maneja las interacciones del usuario
 * en la ventana AcercaDe.
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.4
 * @since 4-12-2023
 */
package Controlador;

import Vista.AcercaDe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase ControlAcercaDe implementa la interfaz ActionListener para
 * gestionar eventos en la ventana AcercaDe.
 */
public class ControlAcercaDe implements ActionListener {

    /** La instancia de la ventana AcercaDe */
    AcercaDe ad;

    /**
     * Constructor de la clase ControlAcercaDe.
     *
     * @param obj Instancia de la ventana AcercaDe
     */
    public ControlAcercaDe(AcercaDe obj) {
        ad = obj;
    }

    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ad.jbVolver)) {
            volver();
        }
    }

    /**
     * Método que oculta y cierra la ventana AcercaDe.
     */
    public void volver() {
        ad.setVisible(false);
        ad.dispose();
    }

}
