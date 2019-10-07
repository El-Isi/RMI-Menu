import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.ArrayList;

public class Cliente {
    private static final String IP = "127.0.0.1"; // Puedes cambiar a localhost
    private static final int PUERTO = 1100; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Calculadora"); //Buscar en el registro...
        Scanner sc = new Scanner(System.in);
        int eleccion;
        String[] AtributosPelicula = new String[5];
        ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
        String menu = "\n\n------------------\n\n[-1] => Salir\n[0] => Agregar\nElige: ";
        do {
            System.out.println(menu);

            try {
                eleccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                eleccion = -1;
            }
            switch (eleccion) {
                case 0:
                    System.out.println("Ingresa Nombre: ");
                    try{
                        AtributosPelicula[0] = sc.nextLine();
                    }catch(NumberFormatException e){
                        AtributosPelicula[0] = "";
                    }

                    System.out.println("Ingresa Clasificacion: ");
                    try{
                        AtributosPelicula[1] = sc.nextLine();
                    }catch(NumberFormatException e){
                        AtributosPelicula[1] = "";
                    }

                    System.out.println("Ingresa Horario: ");
                    try{
                        AtributosPelicula[2] = sc.nextLine();
                    }catch(NumberFormatException e){
                        AtributosPelicula[2] = "";
                    }

                    System.out.println("Ingresa Sala: ");
                    try{
                        AtributosPelicula[3] = sc.nextLine();
                    }catch(NumberFormatException e){
                        AtributosPelicula[3] = "";
                    }

                    System.out.println("Ingresa Genero: ");
                    try{
                        AtributosPelicula[4] = sc.nextLine();
                    }catch(NumberFormatException e){
                        AtributosPelicula[4] = "";
                    }
                    resultado.add(interfaz.AddPelicula(AtributosPelicula[0], AtributosPelicula[1], AtributosPelicula[2], AtributosPelicula[3] ,AtributosPelicula[4]));
                    System.out.println("\n PELICULA AGREGADA \n");

                    System.out.println("Peliculas: \n");
                    for (int i = 0; i < resultado.size(); i++){
                        System.out.println(resultado.get(i) + "\n");
                    }

                    break;

                case 2: //AQUI VA TU PARTE JJ

                case 3: //AQUI VA TU PARTE LEWISAURIO
            }

            System.out.println("Presiona ENTER para continuar");
            sc.nextLine();

        } while (eleccion != -1);
    }
}