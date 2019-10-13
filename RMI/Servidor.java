import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class Servidor {
    private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        ArrayList<Boolean[][]> asientos = new ArrayList<Boolean[][]>();
        Boolean[][] asientosOcupados = new Boolean[6][12];
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {
            /*
                Sobrescribir opcionalmente los métodos que escribimos en la interfaz
            */
            @Override
            public ArrayList<String> AddPelicula(String id, String nombre, String clasificacion, String duracion, String Sala, String genero) throws RemoteException {
                ArrayList<String> pelicula = new ArrayList<String>();
                pelicula.add(id);
                pelicula.add(nombre);
                pelicula.add(clasificacion);
                pelicula.add(duracion);
                pelicula.add(Sala);
                pelicula.add(genero);
                asientos.add(asientosOcupados);

                return pelicula;
            }

            ;

            @Override
            public Boolean[][] mostrarAsientos(int id) throws RemoteException{
                return asientos.get(id);
            }

            ;
            @Override
            public void ocuparAsiento(int Fila, int Columna, int id, Boolean[][] asientosTmp)throws RemoteException{
                asientosTmp[Fila][Columna] = true;
                asientos.set(id, asientosTmp);
            }

            ;


        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
        System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));

        registry.bind("Cinepolis", remote); // Registrar cine

    }
}