
package Modelo;


public class Administrador extends Usuario{
    
    long salarioBase;
    String password, salario;
    
    public Administrador(){
        super();
        salarioBase = 1300000;
        password  = salario = "";
    }

    public void setSalarioBase(long salarioBase) {
        this.salarioBase = salarioBase;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String getSalario(){
        calcSalario();
        return salario;
    }
    
    public void calcSalario(){
        Long Entrada = salarioBase * 3;
        salario = Long.toString(Entrada);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + salario;
    }
    
    
}
