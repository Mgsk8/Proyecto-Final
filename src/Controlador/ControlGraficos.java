/**
 * Proposito: Gestiona las interacciones del usuario en el submenú graficos.
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 4-12-2023
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Vista.Graficos;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartPanel;

/**
 * Proposito: Gestiona las interacciones del usuario en el submenú graficos.
 */
public class ControlGraficos implements ActionListener, WindowListener{
    /** Instancia de la vista Graficos. */
    public Graficos g;
    /**
     * Constructor que recibe la instancia de la vista Graficos.
     *
     * @param obj Instancia de Graficos.
     */
    public ControlGraficos(Graficos obj){
        g = obj;
    }
    // Métodos de ActionListener
    
    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */  
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(g.jtGraficoCli)){
            ocultarPaneles();
            configurarYMostrarGrafico("Cliente", "Estadistica estado de clientes");
            g.jpGraficoEstadoxTipoUsuario.setVisible(true);
        } 
        if(e.getSource().equals(g.jtGraficoEnt)){
            ocultarPaneles();
            configurarYMostrarGrafico("Entrenador", "Estadistica estado de entrenadores");
            g.jpGraficoEstadoxTipoUsuario.setVisible(true);
        }
        if(e.getSource().equals(g.jtGraficoRec)){
            ocultarPaneles();
            configurarYMostrarGrafico("Recepcionista", "Estadistica estado de recepcionistas");
            g.jpGraficoEstadoxTipoUsuario.setVisible(true);
        }
        if(e.getSource().equals(g.jtGraficoSup)){
            ocultarPaneles();
            configurarYMostrarGrafico("Supervisor", "Estadistica estado de supervisores");
            g.jpGraficoEstadoxTipoUsuario.setVisible(true);
        }
        if(e.getSource().equals(g.jtGraficoAdm)){
            ocultarPaneles();
            configurarYMostrarGrafico("Administrador", "Estadistica estado de administradores");
            g.jpGraficoEstadoxTipoUsuario.setVisible(true);
        } 
        if(e.getSource().equals(g.jtGraficoPersonal)){
            ocultarPaneles();
            g.jpGraficoPersonal.setVisible(true);
        }
        if(e.getSource().equals(g.jtGraficoEstado)){
            ocultarPaneles();
            g.jpGraficoEstado.setVisible(true);
        }
        if(e.getSource().equals(g.jtGraficoGrupoSanquineo)){
            ocultarPaneles();
            g.jpGrupoSanguineo.setVisible(true);
        }
        if(e.getSource().equals(g.jbVolver)){
            volver();
        }
    }
    /**
     * Método privado para configurar y mostrar un gráfico estadístico según el tipo de usuario.
     *
     * @param tipoUsuario Tipo de usuario (Cliente, Entrenador, etc.).
     * @param titulo Título del gráfico.
     */    
    private void configurarYMostrarGrafico(String tipoUsuario, String titulo) {
        // Ocultar otros paneles y establecer el borde del panel específico
        ocultarPaneles();
        g.jpGraficoEstadoxTipoUsuario.setBorder(new TitledBorder(titulo));

        // Obtener datos estadísticos y crear el gráfico
        int[] estadoxTipoUsuario = g.listadoEstadoxTipoUsuario(tipoUsuario);
        g.crearGraficoEstadoxTipoUsuario(estadoxTipoUsuario);
        ChartPanel panelEstadoxTipoUsuario = new ChartPanel(g.chart, false);
        panelEstadoxTipoUsuario.setBounds(10, 30, 760, 520);
        g.jpGraficoEstadoxTipoUsuario.removeAll();
        g.jpGraficoEstadoxTipoUsuario.add(panelEstadoxTipoUsuario);

        // Mostrar el panel con el gráfico
        g.jpGraficoEstadoxTipoUsuario.setVisible(true);
    }

    /**
     * Método privado para ocultar todos los paneles de gráficos.
     */
    private void ocultarPaneles() {
        g.jpGraficoEstadoxTipoUsuario.setVisible(false);
        g.jpGraficoPersonal.setVisible(false);
        g.jpGraficoEstado.setVisible(false);
        g.jpGrupoSanguineo.setVisible(false);
    }
    
    /**
     * Método para manejar el evento de salir de la aplicación.
     */
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(g,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }
    /**
     * Método para volver a la ventana principal.
     */
    public void volver(){
        g.setVisible(false);
        g.dispose();
        g.mp.setVisible(true);
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