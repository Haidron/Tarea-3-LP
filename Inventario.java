public class Inventario{

    private int cristalesHidrogeno;
    private int floresSodio;
    private int platino;
    private int uranio;

    //Constructor de la clase, inicializa el inventario con todos los atributos en 0
    public Inventario(){
        this.cristalesHidrogeno = 0;
        this.floresSodio = 0;
        this.platino = 0;
        this.uranio = 0;
    }

    //Funcion setter del hidrogeno, asigna la cantidad introducida al atributo privado hidrogeno
    public void setHidrogeno(int cant){
        this.cristalesHidrogeno = cant;
    }
    
    //Funcion setter del sodio, asigna la cantidad introducida al atributo privado sodio
    public void setSodio(int cant){
        this.floresSodio = cant;
    }
    
    //Funcion setter del platino, asigna la cantidad introducida al atributo privado platino
    public void setPlatino(int cant){
        this.platino = cant;
    }
    
    //Funcion setter del uranio, asigna la cantidad introducida al atributo privado uranio
    public void setUranio(int cant){
        this.uranio = cant;
    }

    //Funcion getter retorna el atributo privado hidrogeno
    public int getHidrogeno(){
        return this.cristalesHidrogeno;
    }
    
    //Funcion getter retorna el atributo privado sodio
    public int getSodio(){
        return this.floresSodio;
    }
    
    //Funcion getter retorna el atributo privado platino
    public int getPlatino(){
        return this.platino;
    }
    
    //Funcion getter retorna el atributo privado uranio
    public int getUranio(){
        return this.uranio;
    }

    //Esta funcion muestra en consola el inventario actual usando las funciones getters definidas para cada atributo privado de la clase
    public void mostrarInventario(){
        System.out.println("\n----------------------------");
        System.out.println("Cristales de hidrogeno: " + getHidrogeno());
        System.out.println("Flores de sodio: " + getSodio());
        System.out.println("Uranio: " + getUranio());
        System.out.println("Platino: " + getPlatino());
        System.out.println("------------------------------");
    }
}