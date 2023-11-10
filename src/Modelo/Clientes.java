
package Modelo;


public class Clientes extends Usuario{
    
    String grupoSanguineo, membresia;
            
    public Clientes(){
        super();
        grupoSanguineo = membresia = "";
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Clientes{" + "grupoSanguineo=" + grupoSanguineo + ", membresia=" + membresia + '}';
    }
    
}
