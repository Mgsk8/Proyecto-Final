/**
 * Controlador para la gestión de eventos en la interfaz de listados.
 *
 * @author
 *     Jhon Alex Rodríguez Benítez - 2264363
 *     Miguel Angel Escobar Marín - 2264305
 *     John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */

package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import Vista.Listados;


/**
 * Controlador para la gestión de eventos en la interfaz de listados.
 */
public class ControlListados implements ActionListener, WindowListener{
    
    /**
     * Instancia de la clase Listados.
     */
    public Listados l;

    /**
     * Constructor que recibe una instancia de Listados.
     *
     * @param obj Instancia de la clase Listados.
     */
    public ControlListados(Listados obj){
        l = obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(l.jtListadoMembresia)) {
            if (l.jpListadoGeneral.isVisible()) {
                l.jpListadoGeneral.setVisible(false);
            }
            if (l.jpListadoEstxSan.isVisible()) {
                l.jpListadoEstxSan.setVisible(false);
            }
            if (l.jpListadoEstxTip.isVisible()) {
                l.jpListadoEstxTip.setVisible(false);
            }
            if (l.jbLimpiar.isVisible()) {
                l.jbLimpiar.setVisible(false);
            }
            if (l.jbConsultar.isVisible()) {
                l.jbConsultar.setVisible(false);
            }

            l.jpListadoMembresia.setVisible(true);
            l.llenarTablaMembresia();
        }
        
        if(e.getSource().equals(l.jtListadoGeneral)){
            if (l.jpListadoMembresia.isVisible()) {
                l.jpListadoMembresia.setVisible(false);
            }
            if (l.jpListadoEstxSan.isVisible()){
                l.jpListadoEstxSan.setVisible(false);
            }
            if (l.jpListadoEstxTip.isVisible()){
                l.jpListadoEstxTip.setVisible(false);
            }
            if (l.jbLimpiar.isVisible()){
                l.jbLimpiar.setVisible(false);
            }
            if (l.jbConsultar.isVisible()){
                l.jbConsultar.setVisible(false);
            }
            
            l.jpListadoGeneral.setVisible(true);
            l.llenarTablaGeneral();
        }
        
        if(e.getSource().equals(l.jtListadoEstxSan)){
            if (l.jpListadoMembresia.isVisible()) {
                l.jpListadoMembresia.setVisible(false);
            }
            if (l.jpListadoGeneral.isVisible()){
                l.jpListadoGeneral.setVisible(false);
            }
            if (l.jpListadoEstxTip.isVisible()){
                l.jpListadoEstxTip.setVisible(false);
            }
            if (!l.jbLimpiar.isVisible()){
                l.jbLimpiar.setVisible(true);
            }
            if (!l.jbConsultar.isVisible()){
                l.jbConsultar.setVisible(true);
            }
            
            l.jpListadoEstxSan.setVisible(true);
            if(e.getSource().equals(l.jbConsultar)){}
        }
        
        if(e.getSource().equals(l.jtListadoEstxTip)){
            if (l.jpListadoMembresia.isVisible()) {
                l.jpListadoMembresia.setVisible(false);
            }
            if(l.jpListadoGeneral.isVisible()){
                l.jpListadoGeneral.setVisible(false);
            }
            if(l.jpListadoEstxSan.isVisible()){
                l.jpListadoEstxSan.setVisible(false);
            }
            if(!l.jbLimpiar.isVisible()){
                l.jbLimpiar.setVisible(true);
            }
            if(!l.jbConsultar.isVisible()){
                l.jbConsultar.setVisible(true);
            }
            
            l.jpListadoEstxTip.setVisible(true);
        }
        if(e.getSource().equals(l.jbVolver)){
            volver();
        }
        if(e.getSource().equals(l.jbLimpiar)){
            limpiar();
        }
        if(e.getSource().equals(l.jbConsultar)){
            consultar();
        }
        
    }
    /**
     * Método que muestra un mensaje de confirmación para salir de la aplicación.
     */
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(l,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }
     /**
     * Método que oculta la ventana actual y muestra la ventana principal.
     */
    public void volver(){
        l.setVisible(false);
        l.dispose();
        l.mp.setVisible(true);
    }
    /**
     * Método que realiza la limpieza de elementos en la interfaz.
     */
    public void limpiar(){
        l.jcEstado1.setSelectedItem("Activo");
        l.jcEstado2.setSelectedItem("Activo");
        l.jcGrupoSanguineo.setSelectedItem("A+");
        l.jcTipoUsuario.setSelectedItem("Administrador");
        for (int i = l.mt2.getRowCount() - 1; i >= 0; i--) {
            l.mt2.removeRow(i);
        }
        for (int i = l.mt3.getRowCount() - 1; i >= 0; i--) {
            l.mt3.removeRow(i);
        }
    }
    /**
     * Método que realiza la consulta y actualiza la tabla correspondiente.
     */
    public void consultar(){
        if(l.jpListadoEstxSan.isVisible()){
            System.out.println(l.jcEstado1.getSelectedItem());
            String valores = "cedula_usuario = id_cliente AND usuario.estado = '" 
                    + l.jcEstado1.getSelectedItem() + "' AND cliente.grupo_sanguineo = '"
                    + l.jcGrupoSanguineo.getSelectedItem() + "';";
            l.llenarTablaEstadoxGrupoSanguineo(valores);
        }
        if(l.jpListadoEstxTip.isVisible()){
            String valores = "usuario.estado = '" 
                    + l.jcEstado2.getSelectedItem() + "' AND usuario.tipo_usuario = '"
                    + l.jcTipoUsuario.getSelectedItem() + "';";
            l.llenarTablaEstadoxTipoUsuario(valores);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        evento_salir();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}