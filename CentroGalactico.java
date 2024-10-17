public class CentroGalactico extends Planeta{

    //Constructor de la clase, dado que el centro galactico tecnicamente se considera un planeta, se inicializa con radio 0 (ya que es irrelevante)
    public CentroGalactico(){
        super(0);
    }

    //Dado que el centro galactico no tiene recursos, sobreescribe el metodo original dejandolo vacío
    @Override
    protected void generarRecursos(){
        //en el centro galactico no pasa nada ademas de ganar el juego
    }

    /* Sobreescribe la funcion visitar, esta funcion se llama en la instancia de Juego unicamente si el usuario decide entrar al centro galactico. La funcion verifica 
    que el jugador tenga una eficiencia del 50% o mas antes de ganar el juego, de lo contrario, despliega un mensaje en consola informando que no tiene la eficiencia
    suficiente */ 
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


    // Sobreescribe la funcion visitarAsentamientos, el juego nunca va a acceder a visitarAsentamientos() desde el Centro Galactico, por lo que se define que no haga nada
    @Override
    public void visitarAsentamientos(Jugador jugador){
        return;
    }

    


}