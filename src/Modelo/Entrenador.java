/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Entrenador extends Recepcionista {
    
    public Entrenador(){
        super();
    }
    
    @Override
    public void calcSalario(){
        Long entrada = salarioBase ;
        salario = Long.toString(entrada);
    }
     @Override
    public String toString() {
        return super.toString() + ";" + turno;
    }
}
