public class Volcanico extends Planeta {
    
    private static double factorHidrogeno = 0.30;
    private static double factorConsumo = 0.08; 
    private static double factorPlatino = 0.25;

    private int temperatura;


    public Volcanico(int radio) {
        super(radio);
    }

    @Override
    protected void generarRecursos() {

        double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        int cristales = (int)(factorHidrogeno * area);
        double consumoEnergia = factorConsumo * (temperatura);
        temperatura = rand(120, 256);
        int platino = (int)((factorPlatino * area) - 20.5 * Math.pow(temperatura, 2));

        setHidrogeno(cristales);
        setSodio(0);
        setConsumo(consumoEnergia);
        setPlatino(platino);
        setUranio(0);

    }

    public int getTemperatura(){
        return temperatura;
    }

    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}