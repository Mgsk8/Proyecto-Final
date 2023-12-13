
package Vista;
/**
 * La clase Rotator es un temporizador utilizado para rotar un gráfico de pastel
 * (PiePlot3D) en un ángulo específico. Este código está basado en el ejemplo
 * JFreeChartPieChart3DDemo2withRotation disponible en
 * http://www.java2s.com/Code/Java/Chart/JFreeChartPieChart3DDemo2withRotation.htm
 *
 * El temporizador cambia continuamente el ángulo de inicio del gráfico de pastel
 * para lograr la rotación.
 *
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */
 
 import java.awt.event.*;
 import javax.swing.*;
 
 import org.jfree.chart.plot.PiePlot3D;

/**
 * La clase Rotator es un temporizador utilizado para rotar un gráfico de pastel
 * (PiePlot3D) en un ángulo específico. Este código está basado en el ejemplo
 * JFreeChartPieChart3DDemo2withRotation disponible en
 * http://www.java2s.com/Code/Java/Chart/JFreeChartPieChart3DDemo2withRotation.htm
 *
 * El temporizador cambia continuamente el ángulo de inicio del gráfico de pastel
 * para lograr la rotación.
 * */
 
class Rotator extends Timer implements ActionListener {

	/** El gráfico de pastel. */
	private PiePlot3D plot;
	
	/** El ángulo de inicio. */
	private int angle = 270;
	
    /**
     * Constructor.
     *
     * @param plot El gráfico de pastel.
     */
	Rotator(final PiePlot3D plot) {
		super(100, null);
		this.plot = plot;
		addActionListener(this);
	}
	
    /**
     * Modifica el ángulo de inicio.
     *
     * @param event El evento de acción.
     */
	public void actionPerformed(final ActionEvent event) {
		this.plot.setStartAngle(this.angle);
		this.angle = this.angle + 1;
		if (this.angle == 360) {
			this.angle = 0;
		}
	}

}