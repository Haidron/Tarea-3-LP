public class Nave{

    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float capacidadCombustible;
    private static float factorRecargaNave = 0.6f;
    private static float factorConsumoNave = 0.75f;

    //Constructor de la clase, inicializa los atributos de la Nave en sus valores iniciales
    public Nave(){
        this.unidadesCombustible = 100.0f;
        this.capacidadCombustible = 100.0f;
        this.eficienciaPropulsor = 0.0f;
    }

    //Funcion setter del combustible, asigna la cantidad introducida al atributo privado unidadesCombustible
    public void setCombustible(float unidadesCombustible){
        this.unidadesCombustible = unidadesCombustible;
    }

    //Funcion setter de la eficiencia del propulsor, asigna la cantidad introducida al atributo privado eficienciaPropulsor
    public void setEficienciaPropulsor(float eficienciaPropulsor){
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    //Funcion setter de la capacidad maxima de combustible, asigna la cantidad introducida al atributo privado capacidadCombsutible
    public void setCapacidadCombustible(float capacidadCombustible){
        this.capacidadCombustible = capacidadCombustible;
    }

    //Funcion getter retorna el atributo privado unidadesCombustible
    public float getCombustible(){
        return unidadesCombustible;
    }

    //Funcion getter retorna el atributo privado eficienciaPropulsor
    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    //Funcion getter retorna el atributo privado capacidadCombustible
    public float getCapacidadCombustible(){
        return capacidadCombustible;
    }

    //Esta funcion muestra en consola el combustible y la eficiencia de los propulsores llamando a la funciones getters correspondientes
    public void mostrarDatos(){
        System.out.println("------------------------------------");
        System.out.println("Combustible restante en la nave: " + getCombustible());
        System.out.println("Eficiencia actual de la nave: " + (int)(getEficienciaPropulsor()*100) + "%");
    }

    //Esta funcion aumenta la cantidad de combustible segun la cantidad de hidrogeno que se ingrese a la funcion
    public void recargarPropulsores(int hidrogeno){
        float unidadesRecargadas = factorRecargaNave * hidrogeno * (1 + eficienciaPropulsor);

        if(unidadesRecargadas + getCombustible() >= capacidadCombustible){
            setCombustible(capacidadCombustible);
        }
        else{
            setCombustible(unidadesRecargadas + getCombustible());
        }
        
    }

    //Esta funcion reduce la cantidad de combustible segun el tamaño del salto cuando el jugador decida viajar a otro planeta
    public void consumirCombustible(int salto){
        float unidadesConsumidas = factorConsumoNave * (float)(Math.pow(salto , 2)) * (1 - eficienciaPropulsor);

        if(getCombustible() <= unidadesConsumidas){
            setCombustible(0);
            
        }
        else{
            setCombustible(getCombustible() - unidadesConsumidas);
        }
        
    }

    /* Esta funcion modifica la posicion segun la direccion y el mtamaño del salto en la lista de planetas, llamando al metodo getPosicion() de la instancia de MapaGalactico recibida.
    Adicionalmente llama a consumirCombustible() para reducir el combustible correspondiente al salto */
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){

        int posicionActual = MG.getPosicion();
        int nuevaPosicion;
        if(direccion == 1){
            nuevaPosicion = posicionActual + tamanoSalto; 
        }
        else if(direccion == -1){
            nuevaPosicion = posicionActual - tamanoSalto;
        }
        else{
            System.out.println("\nDireccion invalida");
            return false;
        }

        this.consumirCombustible(tamanoSalto);
        MG.setPosicion(nuevaPosicion);
        return true;
    }


}