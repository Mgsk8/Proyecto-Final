/*
Proposito: Muestra información sobre los programadores
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/


package Vista;

import Utilerias.JLabelTitulo;
import Vista.MenuPrincipal;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class AcercaDe extends JFrame{
    
    public MenuPrincipal mp;
    public JLabel texto, texto2, texto3;
    public JButton jbVolver;
    
    public AcercaDe(MenuPrincipal mp){
        super("Acerca de");
        this.mp = mp;
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JLabelTitulo titulo = new JLabelTitulo(110, "Acerca de", this, "");
        add(titulo);
        texto = new JLabel("Miguel Angel Escobar Marin - 2264305");
        texto.setBounds(0, 200, 900, 60);
        texto.setFont(new Font("Tahoma", Font.BOLD, 25));
        texto.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        add(texto);
        
        texto2 = new JLabel("Jhon Alex Rodriguez Benitez - 2264363");
        texto2.setBounds(0, 300, 900, 60);
        texto2.setFont(new Font("Tahoma", Font.BOLD, 25));
        texto2.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        add(texto2);
        
        texto3 = new JLabel("John Alejandro Vallarino Cruz - 2264332");
        texto3.setBounds(0, 400, 900, 60);
        texto3.setFont(new Font("Tahoma", Font.BOLD, 25));
        texto3.setHorizontalAlignment(SwingConstants.CENTER);//centrar texto
        add(texto3);
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(680, 520, 200, 30);
        jbVolver.addActionListener((e) -> {
            evento_jbVolver();
        });
        add(jbVolver);
    }
    public void evento_jbVolver(){
        setVisible(false);
        dispose();
        mp.setVisible(true);
    }
}

