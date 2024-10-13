import java.util.Random;
import java.util.Scanner;

public class Helado extends Planeta{
    
    private static double factorHidrogeno = 0.65;
    private static double factorSodio = 0.35;
    private static double factorConsumo = 0.15; 
    
    private int temperatura;

    private Scanner scanner;

    public Helado(int radio) {
        super(radio);
    }

    @Override
    protected void generarRecursos() {

        double area = 4 * Math.PI * Math.pow(getRadio(), 2);
        int cristales = (int)(factorHidrogeno * area);
        int flores = (int)(factorSodio * area);
        temperatura = rand(-120, -30);
        double consumoEnergia = factorConsumo * Math.abs(temperatura);

        setHidrogeno(cristales);
        setSodio(flores);
        setConsumo(consumoEnergia);
        setPlatino(0);
        setUranio(0);
        
        
    }

    public int getTemperatura(){
        return temperatura;
    }

    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}