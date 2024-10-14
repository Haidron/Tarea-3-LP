import java.util.Scanner;

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

    @Override
    public void visitarAsentamientos(Jugador jugador) {

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while(flag){
            System.out.println("\nSeleccione que quiere comprar: ");
            System.out.println("1. 5% extra de eficiencia de combustible en la nave: 5.000 Platino");
            System.out.println("2. 5% extra de eficiencia de energia de proteccion: 5.000 Uranio");
            System.out.println("3. +100 capacidad de combustible en la nave: 2.500 Platino");
            System.out.println("4. +100 capacidad de energia de proteccion:  2.500 Uranio");
            System.out.println("5. Salir del asentamiento");
            System.out.println("\nSu eleccion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    if(jugador.getInventario().getPlatino() < 5000){
                        System.out.println("\nPlatino insuficiente");
                        break;
                    }

                    else{
                        jugador.getNave().setEficienciaPropulsor(jugador.getNave().getEficienciaPropulsor() + 0.05f);
                        jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 5000);
                        break;
                    }
                case 2:
                    if(jugador.getInventario().getUranio() < 5000){
                        System.out.println("\nUranio insuficiente");
                        break;
                    }

                    else{
                        jugador.setEficienciaProteccion(jugador.getEficienciaProteccion() + 0.05f);
                        jugador.getInventario().setUranio(jugador.getInventario().getUranio() - 5000);
                        System.out.println("\nIntercambio exitoso");
                        break;
                    }
                case 3:
                    if(jugador.getInventario().getPlatino() < 2500){
                        System.out.println("\nPlatino insuficiente");
                        break;
                    }

                    else{
                        jugador.getNave().setCapacidadCombustible(jugador.getNave().getCapacidadCombustible() + 100.0f);
                        jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 2500);
                        System.out.println("\nIntercambio exitoso");
                        break;
                    }
                
                case 4:
                    if(jugador.getInventario().getUranio() < 250){
                        System.out.println("\nUranio insuficiente");
                        break;
                    }

                    else{
                        jugador.setCapacidadEnergia(jugador.getCapacidadEnergia() + 100.0f);
                        jugador.getInventario().setUranio(jugador.getInventario().getUranio() - 250);
                        System.out.println("\nIntercambio exitoso");
                        break;
                    }
                
                case 5:
                    flag = false;
                    break;
            }       
        
        }
    } 

    public int getProfundidad(){
        return profundidad;
    }

    private int rand(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}