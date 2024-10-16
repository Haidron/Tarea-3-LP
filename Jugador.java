public class Jugador{

    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion; 
    private float capacidadEnergia;
    private static float factorRecargaJugador = 0.65f;
    private static float factorConsumo = 0.5f; 
    
    private Nave nave;
    private Inventario inventario;

    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.capacidadEnergia = 100.0f;
        this.nave = new Nave();
        this.inventario = new Inventario();
    }

    public void setEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion = unidadesEnergiaProteccion;
    }

    public void setEficienciaProteccion(float eficienciaEnergiaProteccion){
        this.eficienciaEnergiaProteccion = eficienciaEnergiaProteccion;
    }

    public void setCapacidadEnergia(float capacidadEnergia){
        this.capacidadEnergia = capacidadEnergia;
    }

    public float getEnergiaProteccion(){
        return unidadesEnergiaProteccion;
    }

    public float getEficienciaProteccion(){
        return eficienciaEnergiaProteccion;
    }

    public float getCapacidadEnergia(){
        return capacidadEnergia;
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
        System.out.println("Eficiencia actual del traje: " + (int)(getEficienciaProteccion()*100.0f) + "%");
        System.out.println("-----------------------------");
    }

    public void recargarEnergiaProteccion(int sodio){
        float unidadesRecargadas = factorRecargaJugador * sodio * (1 + getEficienciaProteccion());

        if(unidadesRecargadas + getEnergiaProteccion() >= capacidadEnergia){
            setEnergiaProteccion(capacidadEnergia);
        }
        else{
            setEnergiaProteccion(unidadesRecargadas + getEnergiaProteccion());
        }
        
    }

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

