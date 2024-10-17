import java.util.Scanner;

public class Juego {
    private MapaGalactico mapa;
    private Jugador jugador;
    private Scanner scanner;

    //Constructor de la clase Juego, crea instancias del mapa galactico, del jugador, y un scanner para recibir entrada del usuario
    public Juego() {
        this.mapa = new MapaGalactico();
        this.jugador = new Jugador();
        this.scanner = new Scanner(System.in);
    }

    /* Funcion principal del juego, esta funcion se encarga de recibir las entradas del jugador y llamar a las funciones correspondientes usando las instancias
    creadas en el constructor de la clase. La funcion muestra el menu de juego al jugador llamando a mostrarMenu() y luego pide retroalimentacion del jugador,
    dependiendo del numero introducido, realiza las tareas de viajar a otros planetas, visitar y extraer recursos del planeta actual, comerciar con los asentamientos,
    mostrar el inventario al usuario, recargar la energia del traje de proteccion o el combustible de la nave, entrar al centro galactico (si es que corresponde), o
    salir del juego si es que el jugador lo desea */ 
    public void iniciar(){
        System.out.println("¡Bienvenido a No Java's Sky!");

        boolean jugando = true;

        while (jugando) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            if(mapa.getPlaneta() instanceof CentroGalactico){
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

                        if(jugador.getNave().getCombustible() <= 0){
                            System.out.println("\nTe has quedado sin combustible en la nave, regresando al planeta 1, perderas tu inventario y mejoras, y se recargaran tu energia y combustible");
                            perder();
                        }
                        break;
                    
                    
                    case 2: 
                        mapa.getPlaneta().visitar(jugador);
                        break;
                    

                    case 3: 
                        jugador.getInventario().mostrarInventario();
                        break;
                    

                    case 4: 
                        System.out.println("\n1. Recargar energia de proteccion");
                        System.out.println("2. Recargar combustible de la nave");
                        System.out.println("Su eleccion: ");
                        int recarga = scanner.nextInt();
                        int sodio;
                        int hidrogeno;
                        switch (recarga){

                            case 1:
                                System.out.println("\nIngrese la cantidad de sodio que se usara para recargar: ");
                                sodio = scanner.nextInt();
                                if(sodio > jugador.getInventario().getSodio()){
                                    System.out.println("\nSodio insuficiente");
                                }
                                else{
                                    jugador.recargarEnergiaProteccion(sodio);
                                    jugador.getInventario().setSodio(jugador.getInventario().getSodio() - sodio); 
                                    System.out.println("Traje de proteccion recargado con exito"); 
                                }
                                break;

                            case 2:
                                System.out.println("\nIngrese la cantidad de hidrogeno que se usara para recargar: ");
                                hidrogeno = scanner.nextInt();
                                if(hidrogeno > jugador.getInventario().getHidrogeno()){
                                    System.out.println("\nHidrogeno insuficiente");
                                }
                                else{
                                    jugador.getNave().recargarPropulsores(hidrogeno);
                                    jugador.getInventario().setHidrogeno(jugador.getInventario().getHidrogeno() - hidrogeno);
                                    System.out.println("Propulsores recargados con exito");
                                }
                                break;
                        }
                        break;

                    case 5:

                        jugando = false; 
                        break;
                    
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        break;
                }
            }
            else{
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

                        if(jugador.getNave().getCombustible() <= 0){
                            System.out.println("\nTe has quedado sin combustible en la nave, regresando al planeta 0, perderas tu inventario y mejoras, y se recargaran tu energia y combustible");
                            perder();
                        }

                        break;

                    case 2:

                        if(!mapa.getPlaneta().visitar(jugador)){
                            System.out.println("\nTe has quedado sin energia de proteccion, regresando al planeta 0, perderas tu inventario y mejoras, y se recargaran tu energia y combustible");
                            perder();
                        }
                        break;
                            
                    case 3:
                        System.out.println("\nVisitando asentamientos...");
                        mapa.getPlaneta().visitarAsentamientos(jugador);
                        break;

                    case 4:

                        jugador.getInventario().mostrarInventario();
                        break;

                    case 5:
                        
                        System.out.println("\n1. Recargar energia de proteccion");
                        System.out.println("2. Recargar combustible de la nave");
                        System.out.println("Su eleccion: ");
                        int recarga = scanner.nextInt();
                        int sodio;
                        int hidrogeno;
                        switch (recarga){

                            case 1:
                                System.out.println("\nIngrese la cantidad de sodio que se usara para recargar: ");
                                sodio = scanner.nextInt();
                                if(sodio > jugador.getInventario().getSodio()){
                                    System.out.println("\nSodio insuficiente");
                                }
                                else{
                                    jugador.recargarEnergiaProteccion(sodio);
                                    jugador.getInventario().setSodio(jugador.getInventario().getSodio() - sodio); 
                                    System.out.println("Traje de proteccion recargado con exito"); 
                                }
                                break;

                            case 2:
                                System.out.println("\nIngrese la cantidad de hidrogeno que se usara para recargar: ");
                                hidrogeno = scanner.nextInt();
                                if(hidrogeno > jugador.getInventario().getHidrogeno()){
                                    System.out.println("\nHidrogeno insuficiente");
                                }
                                else{
                                    jugador.getNave().recargarPropulsores(hidrogeno);
                                    jugador.getInventario().setHidrogeno(jugador.getInventario().getHidrogeno() - hidrogeno);
                                    System.out.println("Propulsores recargados con exito");
                                }
                                break;
                        }
                        break;

                    case 6:

                        jugando = false; 
                        break;

                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo.");
                        break;
                }
            }
        }
        System.out.println("\nGracias por jugar. ¡Hasta la próxima!");
    }

        

    // Muestra el menú principal de opciones, cambiando a un menú alternativo si es que el planeta actual es el centro galactico
    private void mostrarMenu() {
        System.out.println("\n--- Menú de Juego ---");
        if(mapa.getPlaneta() instanceof CentroGalactico){
            System.out.println("\nEstas en la orbita del Centro Galactico, en la posicion " + mapa.getPosicion());
            jugador.getNave().mostrarDatos();
            jugador.mostrarEnergia();
            System.out.println("1. Viajar a otro planeta");
            System.out.println("2. Entrar al Centro Galactico (Necesitas minimo un 50% de eficiencia)");  
            System.out.println("3. Ver inventario");
            System.out.println("4. Recargar energia o combustible");
            System.out.println("5. Salir del juego");
            System.out.println("Seleccione una opcion: ");
        }
        else{
            System.out.println("\nActualmente estas en la orbita del planeta numero " + mapa.getPosicion() + ", un planeta " + mapa.getPlaneta());
            jugador.getNave().mostrarDatos();
            jugador.mostrarEnergia();
            System.out.println("1. Viajar a otro planeta");
            System.out.println("2. Extraer recursos");
            System.out.println("3. Comerciar con los asentamientos");
            System.out.println("4. Ver inventario");
            System.out.println("5. Recargar energia o combustible");
            System.out.println("6. Salir del juego");
            System.out.print("Seleccione una opción: ");
        }
    }


    /*Esta funcion resetea todos los parametros del jugador, su nave, y su inventario a los valores inciales. Adicionalmente se devuelve al primer
    planeta generado en el mapa galactico*/
    private void perder(){

        int distancia = mapa.getPosicion();
        jugador.getNave().viajarPlaneta(mapa, -1 , distancia);
        jugador.getInventario().setHidrogeno(0);
        jugador.getInventario().setSodio(0);
        jugador.getInventario().setUranio(0);
        jugador.getInventario().setPlatino(0);
        jugador.getNave().setCombustible(100.0f);
        jugador.getNave().setCapacidadCombustible(100.0f);
        jugador.getNave().setEficienciaPropulsor(0.0f);
        jugador.setEnergiaProteccion(100.0f);
        jugador.setCapacidadEnergia(100.0f);
        jugador.setEficienciaProteccion(0.0f);
    
    }
}
