import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGalactico{

    private List<Planeta> planetas;
    private int posicion;
    private boolean centroGenerado = false;
    private Random random = new Random();


    public MapaGalactico(){
        this.planetas = new ArrayList<>();
        this.posicion = 0;
        generadorPlaneta();
    }



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

    public Planeta getPlaneta(){
        return planetas.get(posicion);
    }

    public int getTamanoPlanetas(){
        return planetas.size();
    }

    public void setPosicion(int pos){
        this.posicion = pos;
    }

    public int getPosicion(){
        return this.posicion;
    }

    private int rand(int a, int b) {
        return (int) (random.nextInt(b - a + 1)) + a;
    }

}