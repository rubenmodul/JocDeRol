package inici;

import io.Leer;
import joc.Item;
import joc.Player;
import joc.Team;

import java.util.ArrayList;

import static inici.Utilitats.*;

public class MenuI {
  /**
   * Creamos nuestro menu principal de items y le pasamos las tres arraylist
   * @param players
   * @param items
   * @param teams
   */
  public static void menuprincipalitems(ArrayList<Player> players, ArrayList<Item> items, ArrayList<Team> teams){
    boolean seguir = true;
    do{
      System.out.println();
      System.out.println("    OBJECTES    ");
      System.out.println("1.2.1.- Crear objecte ");
      System.out.println("1.2.2.- Mostrar objectes ");
      System.out.println("1.2.3.- Esborrar objecte ");
      System.out.println("1.2.4.- Assignar objecte a jugador ");
      System.out.println("1.2.5.- Eixir ");
      System.out.println();
      int opcio = Leer.leerEntero("Dis-me la opció que vols elegir: ");

      //SWITCH DE OBJECTES
      switch (opcio){
        case 1:
          Item objecte = new Item(Leer.leerTexto("Dis-e el nom del nou objecte: "), Leer.leerEntero("Dis-me els punts de atac: "), Leer.leerEntero("Dis-me els punts de defensa: "));
          if(addItem(objecte, items)){
            System.out.println("Añadido");
          } else{
            System.out.println("Ya esta creado");
          }
          break;
        case 2:
          System.out.println("\n LLISTA DE ITEMS");
          for(Item i: items){
            System.out.println(i);
          }
          break;
        case 3:
          String bo = Leer.leerTexto("Dis-me el nom del item que vols borrar: \n");
          Item elim = buscarI(bo, items); //Llamamos a la funcion buscar para encontrar el equipo
          teams.remove(elim); //Eliminamos el equipo de la lista de equipos que tenemos
          System.out.println("El item ha segut eliminat! \n");
          break;
        case 4:
          String bo2 = Leer.leerTexto("Dis-me el item del jugador que vols añadir: \n");
          Item afeI = buscarI(bo2, items); //Busquem el item que volem añadir
          String bj3 = Leer.leerTexto("Dis-me el jugador al qual vols añadir-li un item: ");
          Player afeP2 = buscarJ(bj3, players); //Busquem el jugador per a añadir el itme
          afeP2.addItem(afeI); //Añadim el item al jugador
          break;
        case 5:
          seguir = false;
          break;
        default:
          System.out.println("No has escollit cap opcio! ");
      }
    } while(seguir);
  }
}
