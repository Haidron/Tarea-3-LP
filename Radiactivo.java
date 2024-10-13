public class Radiactivo extends Planeta {
    
    private static double factorHidrogeno = 0.20;
    private static double factorSodio = 0.20;
    private static double factorConsumo = 0.30; 
    private static double factorUranio = 0.25;

    private int radiacion;

    public Radiactivo(int radio) {
        super(radio);
    }

    @Override
    protected void generarRecursos(){

        double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        int cristales = (int)(factorHidrogeno * area);
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

    public int getRadiacion(){
        return radiacion;
    }


    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}