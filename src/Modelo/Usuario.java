/*
 Proposito: Nos permite representar los datos y la lógica de la aplicación.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
 */
package Modelo;

public class Usuario {
    String cedula, nombre, apellido, tipoUsuario, grupoSanguineo ,fechaNacimiento, email, password;

    public Usuario(String cedula, String nombre, String apellido, String tipoUsuario, String grupoSanguineo, String fechaNacimiento, String email, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoUsuario = tipoUsuario;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}