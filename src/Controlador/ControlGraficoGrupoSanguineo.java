package Controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Vista.GraficoGrupoSanguineo;

public class ControlGraficoGrupoSanguineo implements WindowListener{

    public GraficoGrupoSanguineo ggs;

    public ControlGraficoGrupoSanguineo(GraficoGrupoSanguineo obj){
        ggs = obj;
    }

    public void volver(){
        ggs.setVisible(false);
        ggs.dispose();
        ggs.g.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        volver();
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
