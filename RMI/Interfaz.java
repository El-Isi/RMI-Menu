import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/*
	Declarar firma de métodos que serán sobrescritos
*/
public interface Interfaz extends Remote {
    ArrayList<String> AddPelicula(String nombre, String clasificacion, String duracion, String Sala, String genero) throws RemoteException;
    void mostrarAsientos() throws RemoteException;
    void ocuparAsiento(int Fila, int Columna) throws RemoteException;
}