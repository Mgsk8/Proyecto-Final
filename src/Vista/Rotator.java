/*
Proposito: clase que tiene como función darle el efecto rotatorio a las gráficas estadisticas. 
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;
// ****************************************************************************
// * JFREECHART DEVELOPER GUIDE                                               *
// * The JFreeChart Developer Guide, written by David Gilbert, is available   *
// * to purchase from Object Refinery Limited:                                *
// *                                                                          *
// * http://www.object-refinery.com/jfreechart/guide.html                     *
// *                                                                          *
// * Sales are used to provide funding for the JFreeChart project - please    * 
// * support us so that we can continue developing free software.             *
// ****************************************************************************

/**
 * The rotator.
 *
 */
 
 //http://www.java2s.com/Code/Java/Chart/JFreeChartPieChart3DDemo2withRotation.htm
 
 import java.awt.event.*;
 import javax.swing.*;
 
 import org.jfree.chart.plot.PiePlot3D;
 
class Rotator extends Timer implements ActionListener {

	/** The plot. */
	private PiePlot3D plot;
	
	/** The angle. */
	private int angle = 270;
	
	/**
	* Constructor.
	*
	* @param plot  the plot.
	*/
	Rotator(final PiePlot3D plot) {
		super(100, null);
		this.plot = plot;
		addActionListener(this);
	}
	
	/**
	* Modifies the starting angle.
	*
	* @param event  the action event.
	*/
	public void actionPerformed(final ActionEvent event) {
		this.plot.setStartAngle(this.angle);
		this.angle = this.angle + 1;
		if (this.angle == 360) {
			this.angle = 0;
		}
	}

}