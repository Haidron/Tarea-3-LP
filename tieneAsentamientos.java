import java.util.Scanner;

public interface tieneAsentamientos{

    default void visitarAsentamientos(Jugador jugador) {

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while(flag){
            System.out.println("Visitando asentamientos en el planeta helado...");
            System.out.println("Seleccione que quiere comprar: ");
            System.out.println("1. 5% extra de eficiencia de combustible en la nave: 500.000.000 Platino");
            System.out.println("2. 5% extra de eficiencia de energia de proteccion: 500.000.000 Uranio");
            System.out.println("3. +100 capacidad de combustible en la nave: 250.000.000 Platino");
            System.out.println("4. +100 capacidad de energia de proteccion: 250.000.000 Uranio");
            System.out.println("5. Salir del asentamiento");
            
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    if(jugador.getInventario().getPlatino() < 500000000){
                        System.out.println("Platino insuficiente");
                        break;
                    }

                    else{
                        jugador.getNave().setEficienciaPropulsor(jugador.getNave().getEficienciaPropulsor() + 0.05f);
                        jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 500000000);
                        break;
                    }
                case 2:
                    if(jugador.getInventario().getUranio() < 500000000){
                        System.out.println("Uranio insuficiente");
                        break;
                    }

                    else{
                        jugador.setEficienciaProteccion(jugador.getEficienciaProteccion() + 0.05f);
                        jugador.getInventario().setUranio(jugador.getInventario().getUranio() - 500000000);
                        System.out.println("Intercambio exitoso");
                        break;
                    }
                case 3:
                    if(jugador.getInventario().getPlatino() < 250000000){
                        System.out.println("Platino insuficiente");
                        break;
                    }

                    else{
                        jugador.getNave().setCapacidadCombustible(jugador.getNave().getCapacidadCombustible() + 100.0f);
                        jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 250000000);
                        System.out.println("Intercambio exitoso");
                        break;
                    }
                
                case 4:
                    if(jugador.getInventario().getUranio() < 250000000){
                        System.out.println("Uranio insuficiente");
                        break;
                    }

                    else{
                        jugador.setCapacidadEnergia(jugador.getCapacidadEnergia() + 100.0f);
                        jugador.getInventario().setUranio(jugador.getInventario().getUranio() - 250000000);
                        System.out.println("Intercambio exitoso");
                        break;
                    }
                
                case 5:
                    flag = false;
                    break;
            }       
        
        }
    }    
}