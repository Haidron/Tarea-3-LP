public class Oceanico extends Planeta {
    
    private static double factorHidrogeno = 0.20;
    private static double factorSodio = 0.65;
    private static double factorConsumo = 0.002; 

    private int profundidad;

    public Oceanico(int radio) {
        super(radio);
    }

    @Override
    protected void generarRecursos() {

        double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        int cristales = (int)(factorHidrogeno * area);
        int flores = (int)(factorSodio * area);
        profundidad = rand(30, 1000);
        double consumoEnergia = factorConsumo * profundidad;

        setHidrogeno(cristales);
        setSodio(flores);
        setConsumo(consumoEnergia);
        setPlatino(0);
        setUranio(0);
        
    }

    public int getProfundidad(){
        return profundidad;
    }

    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}