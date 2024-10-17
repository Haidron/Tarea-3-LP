public class Volcanico extends Planeta {
    
    private static double factorHidrogeno = 0.30;
    private static double factorConsumo = 0.08; 
    private static double factorPlatino = 0.25;

    private int temperatura;

    /* Constructor de la subclase Radiactivo, inicializa las instancias de Radiactivo con el radio introducido. Todos los planetas se generan en la funcion generadorPlaneta() 
    de la clase MapaGalactico, la logica del radio se hace en dicha funcion*/
    public Volcanico(int radio) {
        super(radio);
    }

    /* Esta funcion se encarga de inicializar todos los recursos disponibles en el planeta, usando las funciones setters definidas */
    @Override
    protected void generarRecursos() {

        double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        int cristales = (int)(factorHidrogeno * area);
        temperatura = rand(120, 256);
        double consumoEnergia = factorConsumo * (temperatura);
        int platino = (int)((factorPlatino * area) - 20.5 * Math.pow(temperatura, 2));

        setHidrogeno(cristales);
        setSodio(0);
        setConsumo(consumoEnergia);
        setPlatino(platino);
        setUranio(0);

    }

    //Funcion para visitar asentamientos, dado que en los planetas volcanicos no hay asentamientos, solo muestra en pantalla que no se han avistado asentamientos
    @Override
    public void visitarAsentamientos(Jugador jugador){
        System.out.println("\nNo se han avistado asentamientos");
    }

    //Funcion getter retorna el atributo privado temperatura
    public int getTemperatura(){
        return temperatura;
    }

    //Funcion rand() retorna un numero aleatorio entre los parametros a y b
    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}