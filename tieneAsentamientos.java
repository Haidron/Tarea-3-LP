import java.util.Scanner;

public interface tieneAsentamientos{

    default void visitarAsentamientos(Jugador jugador) {

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
}