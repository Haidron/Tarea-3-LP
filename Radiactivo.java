public class Radiactivo extends Planeta {
    
    private static double factorHidrogeno = 0.20;
    private static double factorSodio = 0.20;
    private static double factorConsumo = 0.30; 
    private static double factorUranio = 0.25;

    private int radiacion;

    /* Constructor de la subclase Radiactivo, inicializa las instancias de Radiactivo con el radio introducido. Todos los planetas se generan en la funcion generadorPlaneta() 
    de la clase MapaGalactico, la logica del radio se hace en dicha funcion*/ 
    public Radiactivo(int radio) {
        super(radio);
    }

    /* Esta funcion se encarga de inicializar todos los recursos disponibles en el planeta, usando las funciones setters definidas */
    @Override
    protected void generarRecursos(){

        double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        int cristales = 0; //(int)(factorHidrogeno * area);
        int flores = (int)(factorSodio * area);
        radiacion = rand(10, 50);
        int uranio = (int)(factorUranio * area * radiacion);
        double consumoEnergia = factorConsumo * radiacion;

        setHidrogeno(cristales);
        setSodio(flores);
        setConsumo(consumoEnergia);
        setPlatino(0);
        setUranio(uranio);
        
        
    }

    //Funcion para visitar asentamientos, dado que en los planetas radiactivos no hay asentamientos, solo muestra en pantalla que no se han avistado asentamientos
    @Override
    public void visitarAsentamientos(Jugador jugador){
        System.out.println("\nNo se han avistado asentamientos");
    }

    //Funcion getter retorna el atributo privado radiacion
    public int getRadiacion(){
        return radiacion;
    }

    //Funcion rand() retorna un numero aleatorio entre los parametros a y b
    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}