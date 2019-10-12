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
        Boolean[][] asientos = new Boolean[6][12];
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
            @Override
            public Boolean[][] mostrarAsientos() throws RemoteException{
                System.out.println("Asientos disponibles: - \n");
                    System.out.println("Asientos Ocupados: O \n");
                    for(int i=0; i<=11; i++){
                        if (i == 11) {
                            System.out.println(" "+i);
                        }else if(i==0){
                            System.out.print("    "+i);
                        }else if(i==10){
                            System.out.print(" "+i);
                        }else{
                            System.out.print("  "+i);
                        }

                    }
                    for (int j = 0; j <= 5; j++) {
                        System.out.print(j+"  ");
                        for (int i = 0; i <= 11; i++){
                            if(asientos[j][i] == null || asientos[j][i] == false) {
                                System.out.print("[-]");
                            }
                            else if (asientos[j][i] == true) {
                                System.out.print("[O]");
                            } else{
                                System.out.print("[-]");
                                System.out.print("[-]");
                            }
                        }
                        System.out.println("\n");
                    }
                    return asientos;
            }
            @Override
            public void ocuparAsiento(int Fila, int Columna)throws RemoteException{
                    asientos[Fila][Columna] = true;
            }

            ;

            

        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
        System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Calculadora", remote); // Registrar calculadora
    }
}