import java.util.Scanner;

public abstract class Planeta implements tieneAsentamientos {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int uranio;
    private int platino;
    private double consumo;

    public Planeta(int radio) {
        this.radio = radio;
        generarRecursos();
    }

    protected abstract void generarRecursos();

    /////////getters y setters///////////
    protected void setHidrogeno(int cristalesHidrogeno){
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    protected void setSodio(int floresDeSodio){
        this.floresDeSodio = floresDeSodio;
    }

    protected void setConsumo(double consumo){
        this.consumo = consumo;
    }

    protected void setUranio(int uranio){
        this.uranio = uranio;
    }

    protected void setPlatino(int platino){
        this.platino = platino;
    }

    public int getRadio() {
        return this.radio;
    }

    public int getHidrogeno() {
        return this.cristalesHidrogeno;
    }

    public int getSodio() {
        return this.floresDeSodio;
    }

    public int getUranio(){
        return this.uranio;
    }

    public int getPlatino(){
        return this.platino;
    }

    public double getConsumoEnergia() {
        return this.consumo;
    }


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
                jugador.getInventario().setUranio(jugador.getInventario().getHidrogeno() + cantidad);

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
                jugador.getInventario().setPlatino(jugador.getInventario().getHidrogeno() + cantidad);

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

    public boolean visitar(Jugador jugador){

        System.out.println("Recursos disponibles en el planeta: ");
        System.out.println("1. Cristales de hidrogeno: " + this.getHidrogeno());
        System.out.println("2. Flores de sodio: " + this.getSodio());
        System.out.println("3. Uranio: " + this.getUranio());
        System.out.println("4. Platino: " + this.getPlatino());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de recurso que quiere: ");

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

    public String toString(){
        return this.getClass().getSimpleName();
    }
}



