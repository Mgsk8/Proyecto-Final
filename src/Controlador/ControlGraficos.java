/*
Proposito: Gestiona las interacciones del usuario en el submenú graficos.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Vista.Graficos;

public class ControlGraficos implements ActionListener, WindowListener{

    public Graficos g;

    public ControlGraficos(Graficos obj){
        g = obj;
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(g.jtGraficoPersonal)){
            if(g.jpGraficoEstado.isVisible()){g.jpGraficoEstado.setVisible(false);}
            if(g.jpGrupoSanguineo.isVisible()){g.jpGrupoSanguineo.setVisible(false);}
            
            g.jpGraficoPersonal.setVisible(true);
        }
        if(e.getSource().equals(g.jtGraficoEstado)){
            if(g.jpGraficoPersonal.isVisible()){g.jpGraficoPersonal.setVisible(false);}
            if(g.jpGrupoSanguineo.isVisible()){g.jpGrupoSanguineo.setVisible(false);}
            
            g.jpGraficoEstado.setVisible(true);
            
            if(e.getSource().equals(g.jbConsultar)){}
        }
        if(e.getSource().equals(g.jtGraficoGrupoSanquineo)){
            if(g.jpGraficoPersonal.isVisible()){g.jpGraficoPersonal.setVisible(false);}
            if(g.jpGraficoEstado.isVisible()){g.jpGraficoEstado.setVisible(false);}
            
            g.jpGrupoSanguineo.setVisible(true);
        }
        if(e.getSource().equals(g.jbVolver)){
            volver();
        }
    }

    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(g,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }
    public void volver(){
        g.setVisible(false);
        g.dispose();
        g.mp.setVisible(true);
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
