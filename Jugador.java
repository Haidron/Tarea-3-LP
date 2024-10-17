public class Jugador{

    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion; 
    private float capacidadEnergia;
    private static float factorRecargaJugador = 0.65f;
    private static float factorConsumo = 0.5f; 
    
    private Nave nave;
    private Inventario inventario;

    //Constructor de la clase, inicializa los atributos a sus valores iniciales y crea instancias de las clases Nave e Inventario para asociarlas a la instancia de Jugador
    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.capacidadEnergia = 100.0f;
        this.nave = new Nave();
        this.inventario = new Inventario();
    }

    //Funcion setter de la energia de proteccion, asigna la cantidad introducida al atributo privado unidadesEnergiaProteccion
    public void setEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }

    //Funcion setter de la eficiencia de energia, asigna la cantidad introducida al atributo privado eficienciaEnergiaProteccion
    public void setEficienciaProteccion(float eficienciaEnergiaProteccion){
        this.eficienciaEnergiaProteccion = eficienciaEnergiaProteccion;
    }

    //Funcion setter de la capacidad maxima de energia, asigna la cantidad introducida al atributo privado capacidadEnergia
    public void setCapacidadEnergia(float capacidadEnergia){
        this.capacidadEnergia = capacidadEnergia;
    }

    //Funcion getter retorna el atributo privado unidadesEnergiaProteccion
    public float getEnergiaProteccion(){
        return unidadesEnergiaProteccion;
    }

    //Funcion getter retorna el atributo privado eficienciaEnergiaProteccion
    public float getEficienciaProteccion(){
        return eficienciaEnergiaProteccion;
    }

    //Funcion getter retorna el atributo privado capacidadEnergia
    public float getCapacidadEnergia(){
        return capacidadEnergia;
    }

    //Funcion getter retorna una instancia de Nave
    public Nave getNave(){
        return nave;
    }

    //Funcion getter retorna una instancia de Inventario
    public Inventario getInventario(){
        return inventario;
    }

    //Esta funcion muestra en consola la energia restante actualmente y su eficiencia
    public void mostrarEnergia(){
        System.out.println("-----------------------------");
        System.out.println("Energia del traje de proteccion restante: " + getEnergiaProteccion());
        System.out.println("Eficiencia actual del traje: " + (int)(getEficienciaProteccion()*100.0f) + "%");
        System.out.println("-----------------------------");
    }

    //Esta funcion aumenta la cantidad de energia de proteccion segun la cantidad de sodio que se ingrese a la funcion
    public void recargarEnergiaProteccion(int sodio){
        float unidadesRecargadas = factorRecargaJugador * sodio * (1 + getEficienciaProteccion());

        if(unidadesRecargadas + getEnergiaProteccion() >= capacidadEnergia){
            setEnergiaProteccion(capacidadEnergia);
        }
        else{
            setEnergiaProteccion(unidadesRecargadas + getEnergiaProteccion());
        }
        
    }

    //Este metodo reduce la cantidad de energia de proteccion en funcion del consumo de energia del planeta actual y de la cantidad de recursos que se esté extrayendo
    public void consumirEnergiaProteccion(int cantidadRecurso, double consumoEnergia){
        float unidadesConsumidas = factorConsumo * cantidadRecurso * (float)(consumoEnergia/100) * (1 - eficienciaEnergiaProteccion);

        if(getEnergiaProteccion() <= unidadesConsumidas){
            setEnergiaProteccion(0);
            
        }
        else{
            setEnergiaProteccion(getEnergiaProteccion() - unidadesConsumidas);
        }
    }
}

