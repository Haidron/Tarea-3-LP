public class Jugador{

    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion; 
    private static float factorRecargaJugador = 0.65f;
    private static float factorConsumo = 0.5f; 
    
    private Nave nave;
    private Inventario inventario;

    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.nave = new Nave();
        this.inventario = new Inventario();
    }

    private void setEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }

    private void setEficienciaProteccion(float eficienciaEnergiaProteccion){
        this.eficienciaEnergiaProteccion = eficienciaEnergiaProteccion;
    }

    public float getEnergiaProteccion(){
        return unidadesEnergiaProteccion;
    }

    public float getEficienciaProteccion(){
        return eficienciaEnergiaProteccion;
    }

    public Nave getNave(){
        return nave;
    }

    public Inventario getInventario(){
        return inventario;
    }

    public void mostrarEnergia(){
        System.out.println("-----------------------------");
        System.out.println("Energia del traje de proteccion restante: " + getEnergiaProteccion());
        System.out.println("Eficiencia actual del traje: " + getEficienciaProteccion());
        System.out.println("-----------------------------");
    }

    public void recargarEnergiaProteccion(int sodio){
        float unidadesRecargadas = factorRecargaJugador * sodio * (1 + getEficienciaProteccion());
        setEnergiaProteccion(unidadesRecargadas);
    }

    public void consumirEnergiaProteccion(int cantidadRecurso, double consumoEnergia){
        float unidadesConsumidas = factorConsumo * cantidadRecurso * (float)(consumoEnergia/100) * (1 - eficienciaEnergiaProteccion);
        setEnergiaProteccion(getEnergiaProteccion() - unidadesConsumidas);
    }
}

