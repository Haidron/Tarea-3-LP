import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGalactico{

    private List<Planeta> planetas;
    private int posicion;
    private boolean centroGenerado = false;
    private Random random = new Random();

    //Constructor de la clase, crea una lista donde se van a guardar los planetas, inicializa una posicion en 0, y genera el primer planeta que se agregará a la lista llamando a generadorPlaneta()
    public MapaGalactico(){
        this.planetas = new ArrayList<>();
        this.posicion = 0;
        generadorPlaneta();
    }


    //Esta funcion genera un planeta y lo agrega a la lista de planetas, cada planeta tiene una probabilidad de ser generado y se generan con un radio aleatorio dentro de un rango
    public void generadorPlaneta(){
        int probabilidad = rand(1, 100);
        Planeta nuevoPlaneta;

        if (probabilidad < 30){
            nuevoPlaneta = new Helado(rand(1000, 1000000));
        }
        else if (probabilidad < 60){
            nuevoPlaneta = new Oceanico(rand(10000, 1000000));
        }
        else if (probabilidad < 80){
            nuevoPlaneta = new Radiactivo(rand(10000, 100000));
        }
        else if (probabilidad < 99){
            nuevoPlaneta = new Volcanico(rand(1000, 100000));
        }
        else{
            if(!centroGenerado){
                nuevoPlaneta = new CentroGalactico(); 
                centroGenerado = true;
            }
            else{
                generadorPlaneta();
                return;
                
            }
        }

        planetas.add(nuevoPlaneta);
    }

    //Funcion getter retorna una instancia del Planeta en la posicion actual de la lista
    public Planeta getPlaneta(){
        return planetas.get(posicion);
    }

    //Funcion getter retorna el tamaño de la lista de planetas
    public int getTamanoPlanetas(){
        return planetas.size();
    }

    //Funcion getter retorna la posicion actual
    public int getPosicion(){
        return this.posicion;
    }
    
    //Funcion setter modifica la posicion actual segun el valor que se ingresa a la funcion 
    public void setPosicion(int pos){
        this.posicion = pos;
    }

    //Funcion rand() retorna un numero aleatorio entre los parametros a y b
    private int rand(int a, int b) {
        return (int) (random.nextInt(b - a + 1)) + a;
    }

}