/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Recepcionista extends Administrador{
    
    String turno;
    
    public Recepcionista(){
        super();
        turno = "";
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    

    public String getTurno() {
        return turno;
    }
    
    @Override
    public void calcSalario(){
        Long entrada = (long)(salarioBase * 0.3) + salarioBase;
        salario = Long.toString(entrada);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + turno;
    }
    
    
}
