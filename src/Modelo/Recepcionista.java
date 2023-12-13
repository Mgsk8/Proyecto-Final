/**
 * Clase que representa a un Recepcionista en el sistema, que hereda de la clase Administrador.
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
 * La clase Recepcionista es una extensión de la clase Administrador y representa a un recepcionista en el sistema.
 */
public class Recepcionista extends Administrador {
    
    /** 
     * Atributo que representa el turno del Recepcionista.
     */
    String turno;
    
    /**
     * Constructor por defecto de la clase Recepcionista.
     * Llama al constructor de la clase padre (Administrador) mediante super(),
     * inicializa el turno como una cadena vacía.
     */
    public Recepcionista() {
        super();
        turno = "";
    }

    /**
     * Establece el turno del Recepcionista.
     *
     * @param turno El nuevo turno a asignar.
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * Obtiene el turno del Recepcionista.
     *
     * @return El turno del Recepcionista.
     */
    public String getTurno() {
        return turno;
    }
    
    /**
     * Calcula el salario del Recepcionista, que es un 30% adicional al salario base.
     * El resultado se almacena en el atributo "salario" como una cadena de texto.
     */
    @Override
    public void calcSalario() {
        Long entrada = (long) (salarioBase * 0.3) + salarioBase;
        salario = Long.toString(entrada);
    }

    /**
     * Devuelve una representación en cadena de texto del Recepcionista,
     * utilizando la implementación de la clase padre (Administrador) y agregando el turno.
     *
     * @return Representación en cadena de texto del Recepcionista.
     */
    @Override
    public String toString() {
        return super.toString() + ";" + turno;
    }
}
