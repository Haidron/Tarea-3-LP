public class CentroGalactico extends Planeta{

    public CentroGalactico(){
        super(0);
    }

    @Override
    protected void generarRecursos(){
        //en el centro galactico no pasa nada ademas de ganar el juego
    }

    @Override
    public boolean visitar(Jugador jugador){

        if(jugador.getNave().getEficienciaPropulsor() < 0.50f){
            System.out.println("\nTu nave no tiene suficiente eficiencia para acceder al Centro Galactico");
            return false;
        }
        else{
            System.out.println("\n¡Has llegado al Centro Galactico!");
            System.out.println("¡Felicidades! Has completado tu travesia espacial para alcanzar el Centro Galactico");
            System.exit(0);
            return true;
        }
    }

    


}