package Controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Vista.GraficoEstado;

public class ControlGraficoEstado implements WindowListener{

    public GraficoEstado ge;

    public ControlGraficoEstado(GraficoEstado obj){
        ge = obj;
    }

    public void volver(){
        ge.setVisible(false);
        ge.dispose();
        ge.g.setVisible(true);
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
