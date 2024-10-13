public class Nave{

    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private float capacidadCombustible;
    private static float factorRecargaNave = 0.6f;
    private static float factorConsumoNave = 0.75f;

    public Nave(){
        this.unidadesCombustible = 100.0f;
        this.capacidadCombustible = 100.0f;
        this.eficienciaPropulsor = 0.0f;
    }

    public void setCombustible(float unidadesCombustible){
        this.unidadesCombustible = unidadesCombustible;
    }

    
    public void setEficienciaPropulsor(float eficienciaPropulsor){
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    public void setCapacidadCombustible(float capacidadCombustible){
        this.capacidadCombustible = capacidadCombustible;
    }

    public float getCombustible(){
        return unidadesCombustible;
    }

    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    public float getCapacidadCombustible(){
        return capacidadCombustible;
    }

    public void mostrarDatos(){
        System.out.println("------------------------------------");
        System.out.println("Combustible restante en la nave: " + getCombustible());
        System.out.println("Eficiencia actual de la nave: " + getEficienciaPropulsor());
    }

    public void recargarPropulsores(int hidrogeno){
        float unidadesRecargadas = factorRecargaNave * hidrogeno * (1 + eficienciaPropulsor);

        if(unidadesRecargadas >= capacidadCombustible){
            setCombustible(capacidadCombustible);
        }
        else{
            setCombustible(unidadesRecargadas);
        }
        
    }

    public void consumirCombustible(int salto){
        float unidadesConsumidas = factorConsumoNave * (float)(Math.pow(salto , 2)) * (1 - eficienciaPropulsor);

        if(getCombustible() <= unidadesConsumidas){
            setCombustible(0);
            
        }
        else{
            setCombustible(getCombustible() - unidadesConsumidas);
        }
        
    }

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
            System.out.println("Direccion invalida");
            return false;
        }

        this.consumirCombustible(tamanoSalto);
        MG.setPosicion(nuevaPosicion);
        return true;
    }


    

}