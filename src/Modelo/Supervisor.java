/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Supervisor extends Recepcionista{
    
    public Supervisor(){
        super();
    }

    public void setSalarioBase(long salarioBase) {
        this.salarioBase = salarioBase;
    }
     
    @Override
    public void calcSalario(){
        Long entrada = salarioBase * 2 ;
        salario = Long.toString(entrada);
    }
    
    public String toString() {
        return super.toString();
    }
}
