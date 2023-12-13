/**
 * Clase que representa a un Cliente en el sistema, que hereda de la clase Usuario.
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
 * La clase Clientes es una extensión de la clase Usuario y representa a un cliente en el sistema.
 */
public class Clientes extends Usuario {
    
    /**
     * Atributo que representa el grupo sanguíneo del Cliente.
     */
    String grupoSanguineo;
            
    /**
     * Constructor por defecto de la clase Clientes.
     * Llama al constructor de la clase padre (Usuario) mediante super(),
     * inicializa el grupo sanguíneo como una cadena vacía.
     */
    public Clientes() {
        super();
        grupoSanguineo = "";
    }

    /**
     * Establece el grupo sanguíneo del Cliente.
     *
     * @param grupoSanguineo El nuevo grupo sanguíneo a asignar.
     */
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    /**
     * Obtiene el grupo sanguíneo del Cliente.
     *
     * @return El grupo sanguíneo del Cliente.
     */
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}
