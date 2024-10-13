import java.util.Scanner;

public class Juego {
    private MapaGalactico mapa;
    private Jugador jugador;
    private Scanner scanner;

    public Juego() {
        this.mapa = new MapaGalactico();
        this.jugador = new Jugador();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        System.out.println("¡Bienvenido a No Java's Sky!");

        boolean jugando = true;

        while (jugando) {
            mostrarMenu();

            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese direccion de salto (-1 hacia la izquieda, 1 hacia la derecha): ");
                    int direccion = scanner.nextInt();
                    System.out.println("Ingrese tamano del salto: ");
                    int salto = scanner.nextInt();

                    int nuevaPos = mapa.getPosicion() + (direccion * salto);

                    if(nuevaPos >= mapa.getTamanoPlanetas()){
                        int diferencia = nuevaPos - mapa.getTamanoPlanetas() + 1;

                        for(int i = 0 ; i < diferencia ; i++){
                            mapa.generadorPlaneta();
                        }
                    }

                    jugador.getNave().viajarPlaneta(mapa, direccion, salto);

                    break;

                case 2:

                    mapa.getPlaneta().visitar(jugador);
                    break;

                case 3:
                    //comercio
                    break;

                case 4:

                    jugador.getInventario().mostrarInventario();
                    break;

                case 5:

                    jugando = false; // Salir del juego
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

            if (jugador.getEnergiaProteccion() <= 0) {
                System.out.println("¡Te has quedado sin energía! Fin del juego.");
                jugando = false;
            }
        }

        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
    }

    // Muestra el menú principal de opciones
    private void mostrarMenu() {
        System.out.println("\n--- Menú de Juego ---");
        System.out.println("\nActualmente estas en la orbita de un planeta " + mapa.getPlaneta());
        jugador.getNave().mostrarDatos();
        jugador.mostrarEnergia();
        System.out.println("1. Viajar a otro planeta");
        System.out.println("2. Extraer recursos");
        System.out.println("3. Comerciar con los asentamientos");
        System.out.println("4. Ver inventario");
        System.out.println("5. Salir del juego");
        System.out.print("Seleccione una opción: ");
    }
}