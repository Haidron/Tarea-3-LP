import java.util.Scanner;

public abstract class Planeta implements tieneAsentamientos {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int uranio;
    private int platino;
    private double consumo;

    /* Constructor de la clase abstracta Planeta, inicializa las instancias de las subclases de Planeta con el radio introducido. Todos los planetas se generan en la 
    funcion generadorPlaneta() de la clase MapaGalactico, la logica del radio se hace en dicha funcion*/
    public Planeta(int radio) {
        this.radio = radio;
        generarRecursos();
    }

    //Funcion abstracta para generar los recursos del planeta, se define en cada subclase
    protected abstract void generarRecursos();

    //Funcion setter del hidrogeno, asigna la cantidad introducida al atributo privado cristalesHidrogeno
    protected void setHidrogeno(int cristalesHidrogeno){
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    //Funcion setter del sodio, asigna la cantidad introducida al atributo privado floresDeSodio
    protected void setSodio(int floresDeSodio){
        this.floresDeSodio = floresDeSodio;
    }

    //Funcion setter del consumo energetico, asigna la cantidad introducida al atributo privado consumo
    protected void setConsumo(double consumo){
        this.consumo = consumo;
    }

    //Funcion setter del uranio, asigna la cantidad introducida al atributo privado uranio
    protected void setUranio(int uranio){
        this.uranio = uranio;
    }

    //Funcion setter del platino, asigna la cantidad introducida al atributo privado platino
    protected void setPlatino(int platino){
        this.platino = platino;
    }

    //Funcion getter retorna el atributo privado radio
    public int getRadio() {
        return this.radio;
    }

    //Funcion getter retorna el atributo privado cristalesHidrogeno
    public int getHidrogeno() {
        return this.cristalesHidrogeno;
    }

    //Funcion getter retorna el atributo privado floresDeSodio
    public int getSodio() {
        return this.floresDeSodio;
    }

    //Funcion getter retorna el atributo privado uranio
    public int getUranio(){
        return this.uranio;
    }

    //Funcion getter retorna el atributo privado platino
    public int getPlatino(){
        return this.platino;
    }

    //Funcion getter retorna el atributo privado consumo
    public double getConsumoEnergia() {
        return this.consumo;
    }

    /* Esta funcion retorna true, pero no se usa en todo el codigo, el ayudante coordinador dijo en el foro de preguntas que era opcional usarla pero esta definida 
    en el diagrama de clases por lo que decidi incluirla */
    public boolean salir(){
        return true;
    }

    /*Esta funcion segun un numero del 1 al 4 recibido elige el tipo de recurso que se va a extraer, ademas recibe la cantidad de recurso que se quiere extraer, agregandolo
    al inventario del jugador, consumiendo la energia que se requiere para la extracción y restando la cantidad de recurso respectivo de la reserva del planeta actual. Si no hay 
    recursos suficientes en el planeta, o si se pudieron extraer los recursos con exito retorna 1, indicando que el juego puede continuar normalmente. En caso de que el jugador
    no tuviese suficiente energia para la extraccion de recursos, retorna 0, indicando que el jugador debe sucumbir a las adversidades del planeta*/
    public int extraerRecursos(Jugador jugador, int tipo, int cantidad){

        double consumo = this.getConsumoEnergia();

        int hidrogenoRestante = this.getHidrogeno();
        int sodioRestante = this.getSodio();
        int uranioRestante = this.getUranio();
        int platinoRestante = this.getPlatino();

        if(tipo == 1){ //tipo == 1: hidrogeno
            if(cantidad > hidrogenoRestante){
                System.out.println("No hay suficientes cristales de hidrogeno en el planeta");
                return 1;
            } 
            else{
                this.setHidrogeno(hidrogenoRestante - cantidad);
                jugador.consumirEnergiaProteccion(cantidad, consumo);
                jugador.getInventario().setHidrogeno(jugador.getInventario().getHidrogeno() + cantidad);  
            }  
        }

        else if(tipo == 2){ //tipo == 2 sodio
            if(cantidad > sodioRestante){
                System.out.println("No hay suficientes flores de sodio en el planeta");
                return 1;
            } 
            else{
                this.setSodio(sodioRestante - cantidad);
                jugador.consumirEnergiaProteccion(cantidad, consumo);
                jugador.getInventario().setSodio(jugador.getInventario().getSodio() + cantidad);
            } 
        }

        else if(tipo == 3){ //tipo == 3: Uranio
            if(cantidad > uranioRestante){
                System.out.println("No hay suficiente uranio en el planeta");
                return 1;
            } 
            else{
                this.setUranio(uranioRestante - cantidad);
                jugador.consumirEnergiaProteccion(cantidad, consumo);
                jugador.getInventario().setUranio(jugador.getInventario().getUranio() + cantidad);

            }
        }

        else if(tipo == 4){ //tipo == 4: Platino
            if(cantidad > platinoRestante){
                System.out.println("No hay suficiente platino en el planeta");
                return 1;
            } 
            else{
                this.setPlatino(platinoRestante - cantidad);
                jugador.consumirEnergiaProteccion(cantidad, consumo);
                jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() + cantidad);

            }  
        }

        else{
            System.out.println("Tipo invalido");
            return 1;
        }

        if(jugador.getEnergiaProteccion() <= 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    /* Esta funcion se encarga de filtrar el recurso que el jugador quiera haciendo uso de un scanner que recibe el numero de recurso que el jugador ingrese. Despues de
    recibir el numero, le pide al jugador que ingrese la cantidad de recursos que quiere y llama a extraerRecursos(), si el metodo llamado retorna 1, esta funcion retorna true,
    indicando que se puede continuar el juego con normalidad, si retorna 0, esta funcion retorna false, indicando que el jugador debe sucumbir a las adversidades del planeta */
    public boolean visitar(Jugador jugador){

        System.out.println("\nRecursos disponibles en el planeta: ");
        System.out.println("1. Cristales de hidrogeno: " + this.getHidrogeno());
        System.out.println("2. Flores de sodio: " + this.getSodio());
        System.out.println("3. Uranio: " + this.getUranio());
        System.out.println("4. Platino: " + this.getPlatino());

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el numero de recurso que quiere: ");

        int eleccion = scanner.nextInt();
        int cantidad = 0;

        if(eleccion == 1){
            System.out.println("Ingrese cuantos cristales de hidrogeno quiere extraer: ");
            cantidad = scanner.nextInt();

        }
        else if(eleccion == 2){
            System.out.println("Ingrese cuantas flores de sodio quiere extraer: ");
            cantidad = scanner.nextInt();
        }
        else if(eleccion == 3){
            System.out.println("Ingrese cuanto uranio quiere extraer: ");
            cantidad = scanner.nextInt();
        }
        else if(eleccion == 4){
            System.out.println("Ingrese cuanto platino quiere extraer: ");
            cantidad = scanner.nextInt();
        }

        if(extraerRecursos(jugador, eleccion, cantidad) == 1){
            return true;
        }
        else{
            return false;
        }
    }

    /*Esta funcion se encarga de hacer que cuando se retorne una instancia de las subclases de Planeta, se retorne con el nombre de la clase sin el hashcode de esta,
    esta funcion esta definida para cuando se quiere imprimir el planeta en consola*/
    public String toString(){
        return this.getClass().getSimpleName();
    }
}



