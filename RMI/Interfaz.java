import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/*
	Declarar firma de métodos que serán sobrescritos
*/
public interface Interfaz extends Remote {
    ArrayList<String> AddPelicula(String id, String nombre, String clasificacion, String duracion, String Sala, String genero) throws RemoteException;
    Boolean[][] mostrarAsientos(int id) throws RemoteException;
    void ocuparAsiento(int Fila, int Columna, int id, Boolean[][] asientosTmp) throws RemoteException;
}