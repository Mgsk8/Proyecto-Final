
package Modelo;


public class Clientes extends Usuario{
    
    String grupoSanguineo;
            
    public Clientes(){
        super();
        grupoSanguineo = "";
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}
