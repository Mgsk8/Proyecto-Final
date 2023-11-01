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
    String cedula, nombre, apellido, tipoUsuario, grupoSanguineo,dia, mes, year, email, password, estado;

    public Usuario(String cedula, String nombre, String apellido, String tipoUsuario, String grupoSanguineo, String dia, String mes, String year, String email, String password, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoUsuario = tipoUsuario;
        this.grupoSanguineo = grupoSanguineo;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.email = email;
        this.password = password;
        this.estado = estado;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getYear() {
        return year;
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
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return cedula + ";" + nombre + ";" + apellido + ";"
            + tipoUsuario + ";" + grupoSanguineo + ";" + dia + ";" + mes + ";"+ year + ";" + email + ";" + password + ";" + estado;
    }

}