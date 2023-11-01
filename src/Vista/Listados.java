/*
Proposito: Muestra en pantalla un submenú con botones que permiten ir a listados con
información de los usuarios ya registrados.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.ControlListados;
import Utilerias.JButtonFuncion;
import Utilerias.JButtonMenu;
import Utilerias.JLabelTitulo;

public class Listados extends JFrame{
    
    public JButton jbListadoGeneral, jbListadoEstadoxTipo, jbListadoEstadoxSanguineo;
    public ControlListados cl;
    public MenuAdmin mp;
    public JButton jbVolver;

    public Listados(MenuAdmin obj){
        super("Listados");
        mp = obj;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cl = new ControlListados(this);
        addWindowListener(cl);
        crearGUI();
        
        setVisible(true);
    }

    public void crearGUI(){

        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 800, 500);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);

         JLabelTitulo jt = new JLabelTitulo(
                60, "Listados", this, "/Imagenes/Consultar.png");
        add(jt);
        cl = new ControlListados(this);

        jbListadoGeneral = new JButtonMenu((800-400)/2, 100, 400, 50, 
                "Listado general", "Ir a Listado general", 
                "/imagenes/Consultar.png", 'L', this);
        jbListadoGeneral.setBorderPainted(false);
        jbListadoGeneral.setFocusPainted(false);
        jbListadoGeneral.addActionListener(cl);
        jp.add(jbListadoGeneral);
        
        jbListadoEstadoxSanguineo = new JButtonMenu((800-500)/2, 200, 500, 50, 
                "Listados por Estado y Saguineo", "Ir a Listados Estado x Sanguineo", 
                "/imagenes/Consultar.png", 'L', this);
        jbListadoEstadoxSanguineo.addActionListener(cl);
        jp.add(jbListadoEstadoxSanguineo);
        
        jbListadoEstadoxTipo = new JButtonMenu((800-500)/2, 300, 500, 50, 
                "Listado por Estado y Tipo", "Ir a Listado Estado x Tipo", 
                "/imagenes/Consultar.png", 'L', this);
        jbListadoEstadoxTipo.addActionListener(cl);
        jp.add(jbListadoEstadoxTipo);
    
        jbVolver = new JButtonFuncion(320, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cl);
        jp.add(jbVolver);
    }

}
