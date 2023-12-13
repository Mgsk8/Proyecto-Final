/**
 * Clase que representa a un Supervisor en el sistema, que hereda de la clase Recepcionista.
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
 * La clase Supervisor es una extensión de la clase Recepcionista y representa a un supervisor en el sistema.
 */
public class Supervisor extends Recepcionista {
    
    /**
     * Constructor por defecto de la clase Supervisor.
     * Llama al constructor de la clase padre (Recepcionista) mediante super().
     */
    public Supervisor() {
        super();
    }

    /**
     * Establece el salario base del Supervisor.
     *
     * @param salarioBase El nuevo salario base a asignar.
     */
    public void setSalarioBase(long salarioBase) {
        this.salarioBase = salarioBase;
    }
     
    /**
     * Calcula el salario del Supervisor, que es el doble del salario base.
     * El resultado se almacena en el atributo "salario" como una cadena de texto.
     */
    @Override
    public void calcSalario() {
        Long entrada = salarioBase * 2;
        salario = Long.toString(entrada);
    }
    
    /**
     * Devuelve una representación en cadena de texto del Supervisor,
     * utilizando la implementación de la clase padre (Recepcionista).
     *
     * @return Representación en cadena de texto del Supervisor.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}

