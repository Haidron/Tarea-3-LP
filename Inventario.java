public class Inventario{

    private int cristalesHidrogeno;
    private int floresSodio;
    private int platino;
    private int uranio;

    public Inventario(){
        this.cristalesHidrogeno = 0;
        this.floresSodio = 0;
        this.platino = 0;
        this.uranio = 0;
    }

    //setters
    public void setHidrogeno(int cant){
        this.cristalesHidrogeno = cant;
    }
    
    public void setSodio(int cant){
        this.floresSodio = cant;
    }
    
    public void setPlatino(int cant){
        this.platino = cant;
    }
    
    public void setUranio(int cant){
        this.uranio = cant;
    }

    //getters
    public int getHidrogeno(){
        return this.cristalesHidrogeno;
    }
    
    public int getSodio(){
        return this.floresSodio;
    }
    
    public int getPlatino(){
        return this.platino;
    }
    
    public int getUranio(){
        return this.uranio;
    }

    public void mostrarInventario(){
        System.out.println("\n----------------------------");
        System.out.println("Cristales de hidrogeno: " + getHidrogeno());
        System.out.println("Flores de sodio: " + getSodio());
        System.out.println("Uranio: " + getUranio());
        System.out.println("Platino: " + getPlatino());
        System.out.println("------------------------------");
    }
}