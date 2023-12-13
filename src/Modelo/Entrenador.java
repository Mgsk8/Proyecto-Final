/**
 * Clase que representa a un Entrenador en el sistema, que hereda de la clase Recepcionista.
 * 
 * Autores:
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 *
 * @version 1.4
 * @since 4-12-2023
 * Fecha de última modificación: 11/12/2023
 */
package Modelo;

/**
 * La clase Entrenador es una extensión de la clase Recepcionista y representa a un entrenador en el sistema.
 */
public class Entrenador extends Recepcionista {
    
    /**
     * Constructor por defecto de la clase Entrenador.
     * Llama al constructor de la clase padre (Recepcionista) mediante super().
     */
    public Entrenador() {
        super();
    }

    /**
     * Calcula el salario del Entrenador, que es igual al salario base.
     * El resultado se almacena en el atributo "salario" como una cadena de texto.
     */
    @Override
    public void calcSalario() {
        Long entrada = salarioBase;
        salario = Long.toString(entrada);
    }

    /**
     * Devuelve una representación en cadena de texto del Entrenador,
     * utilizando la implementación de la clase padre (Recepcionista) y agregando el turno.
     *
     * @return Representación en cadena de texto del Entrenador.
     */
    @Override
    public String toString() {
        return super.toString() + ";" + turno;
    }
}
