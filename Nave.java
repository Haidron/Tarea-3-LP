public class Nave{

    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private static float factorRecargaNave = 0.6f;
    private static float factorConsumoNave = 0.75f;

    public Nave(){
        this.unidadesCombustible = 100.0f;
        this.eficienciaPropulsor = 0.0f;
    }

    private void setCombustible(float unidadesCombustible){
        this.unidadesCombustible = unidadesCombustible;
    }

    
    private void setEficienciaPropulsor(float eficienciaPropulsor){
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    public float getCombustible(){
        return unidadesCombustible;
    }

    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    public void mostrarDatos(){
        System.out.println("------------------------------------");
        System.out.println("Combustible restante en la nave: " + getCombustible());
        System.out.println("Eficiencia actual de la nave: " + getEficienciaPropulsor());
    }

    public void recargarPropulsores(int hidrogeno){
        float unidadesRecargadas = factorRecargaNave * hidrogeno * (1 + eficienciaPropulsor);
        setCombustible(unidadesRecargadas);
    }

    public void consumirCombustible(int salto){
        float unidadesConsumidas = factorConsumoNave * (float)(Math.pow(salto , 2)) * (1 - eficienciaPropulsor);
        setCombustible(getCombustible() - unidadesConsumidas);
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