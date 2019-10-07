 import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor {
    private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {
            /*
                Sobrescribir opcionalmente los métodos que escribimos en la interfaz
            */
            @Override
            public ArrayList<String> AddPelicula(String nombre, String clasificacion, String duracion, String Sala, String genero) throws RemoteException {
                ArrayList<String> pelicula = new ArrayList<String>();
                pelicula.add(nombre);
                pelicula.add(clasificacion);
                pelicula.add(duracion);
                pelicula.add(Sala);
                pelicula.add(genero);
                return pelicula;
            }

            ;

        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
        System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Calculadora", remote); // Registrar calculadora
    }
}