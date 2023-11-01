/*
Proposito: Muestra en pantalla un submenú donde muestra 3 botones los cuales permiten
visualizar diferentes gráficos.
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

import Controlador.ControlGraficos;
import Utilerias.JButtonFuncion;
import Utilerias.JButtonMenu;
import Utilerias.JLabelTitulo;

public class Graficos extends JFrame{

    public JButton jbGraficoEstado, jbGraficoGrupo, jbGraficoPersonal, jbVolver;
    public ControlGraficos cg;
    public MenuAdmin mp;


    public Graficos(MenuAdmin obj){
        super("Gráficos");
        mp = obj;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cg = new ControlGraficos(this);
        addWindowListener(cg);
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
        cg = new ControlGraficos(this);

        jbGraficoEstado = new JButtonMenu((800-400)/2, 100, 400, 50, 
                "Gráfico Estado", "Ir a Gráfico Estado", 
                "", 'I', this);
        jbGraficoEstado.setBorderPainted(false);
        jbGraficoEstado.setFocusPainted(false);
        jbGraficoEstado.addActionListener(cg);
        jp.add(jbGraficoEstado);
        
        jbGraficoGrupo = new JButtonMenu((800-500)/2, 200, 500, 50, 
                "Gráfico Tipo Sanguíneo", "Ir a Gráfico Tipo Sanguíneo", 
                "", 'L', this);
        jbGraficoGrupo.addActionListener(cg);
        jp.add(jbGraficoGrupo);
        
        jbGraficoPersonal = new JButtonMenu((800-500)/2, 300, 500, 50, 
                "Gráfico Personal", "Ir a Gráfico Personal", 
                "", 'L', this);
        jbGraficoPersonal.addActionListener(cg);
        jp.add(jbGraficoPersonal);
    
        jbVolver = new JButtonFuncion(320, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(cg);
        jp.add(jbVolver);
    }

    
}
