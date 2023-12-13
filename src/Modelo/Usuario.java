/**
 * Clase abstracta que representa un usuario genérico en el sistema.
 * 
 * Autores:
 * - John Alejandro Vallarino - 2264332
 * - Jhon Alex Rodriguez - 2264363
 * - Miguel Ángel Escobar Marín - 2264305
 *
 * @version 1.4
 * @since 4-12-2023
 * Fecha de última modificación: 11/12/2023
 */
package Modelo;

/**
 * La clase abstracta Usuario define los atributos y métodos comunes para todos los tipos de usuarios en el sistema.
 */
public abstract class Usuario {
    String cedula, nombre, apellido, dia, mes, year, email, tipoUsuario, estado;

    /**
     * Constructor por defecto de la clase Usuario.
     * Inicializa todos los atributos a cadenas vacías.
     */
    public Usuario() {
        cedula = nombre = apellido = dia = mes = year = email = tipoUsuario = estado = "";
    }

    /**
     * Establece la cédula del usuario.
     *
     * @param cedula La nueva cédula a asignar.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El nuevo apellido a asignar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el día de nacimiento del usuario.
     *
     * @return El día de nacimiento del usuario.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de nacimiento del usuario.
     *
     * @param dia El nuevo día de nacimiento a asignar.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Obtiene el mes de nacimiento del usuario.
     *
     * @return El mes de nacimiento del usuario.
     */
    public String getMes() {
        return mes;
    }

    /**
     * Establece el mes de nacimiento del usuario.
     *
     * @param mes El nuevo mes de nacimiento a asignar.
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Obtiene el año de nacimiento del usuario.
     *
     * @return El año de nacimiento del usuario.
     */
    public String getYear() {
        return year;
    }

    /**
     * Establece el año de nacimiento del usuario.
     *
     * @param year El nuevo año de nacimiento a asignar.
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico a asignar.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la cédula del usuario.
     *
     * @return La cédula del usuario.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Convierte la información del usuario a una cadena de texto en formato CSV.
     *
     * @return Representación en cadena de texto del usuario en formato CSV.
     */
    @Override
    public String toString() {
        return cedula + ";" + nombre + ";" + apellido + ";"
            + dia + ";" + mes + ";" + year + ";" + email;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return El tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoUsuario El nuevo tipo de usuario a asignar.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene el estado del usuario.
     *
     * @return El estado del usuario.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del usuario.
     *
     * @param estado El nuevo estado a asignar.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
