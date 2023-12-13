/**
 * Clase que representa a un Administrador en el sistema, que hereda de la clase Usuario.
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
 * La clase Administrador es una extensión de la clase Usuario y representa a un administrador en el sistema.
 */
public class Administrador extends Usuario {
    
    /**
     * Atributo que representa el salario base del Administrador.
     */
    long salarioBase;
    
    /**
     * Atributo que representa la contraseña del Administrador.
     */
    String password, salario;
    
    /**
     * Constructor por defecto de la clase Administrador.
     * Llama al constructor de la clase padre (Usuario) mediante super(),
     * inicializa el salario base, la contraseña y el salario como cadenas vacías.
     */
    public Administrador() {
        super();
        salarioBase = 1300000;
        password = salario = "";
    }

    /**
     * Establece el salario base del Administrador.
     *
     * @param salarioBase El nuevo salario base a asignar.
     */
    public void setSalarioBase(long salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * Obtiene la contraseña del Administrador.
     *
     * @return La contraseña del Administrador.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del Administrador.
     *
     * @param password La nueva contraseña a asignar.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Obtiene el salario del Administrador.
     * Realiza el cálculo del salario llamando al método calcSalario.
     *
     * @return El salario del Administrador.
     */
    public String getSalario() {
        calcSalario();
        return salario;
    }
    
    /**
     * Calcula el salario del Administrador, que es tres veces el salario base.
     * El resultado se almacena en el atributo "salario" como una cadena de texto.
     */
    public void calcSalario() {
        Long entrada = salarioBase * 3;
        salario = Long.toString(entrada);
    }

    /**
     * Devuelve una representación en cadena de texto del Administrador,
     * utilizando la implementación de la clase padre (Usuario) y agregando el salario.
     *
     * @return Representación en cadena de texto del Administrador.
     */
    @Override
    public String toString() {
        return super.toString() + ";" + salario;
    }
}
