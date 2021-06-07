package inici;

import io.ExcepcioJugadorRepetit;
import io.Leer;
import joc.*;

import java.util.ArrayList;

import static inici.MenuP.*;
import static inici.Utilitats.*;

public class MenuP {

  public static int pd = 100;
  public static int pv = 100;

  /**
   * Creamos nuestro menu principal de players y le pasamos las tres arraylist
   *
   * @param players
   * @param items
   * @param teams
   * @throws ExcepcioJugadorRepetit
   */
  public static void menuprincipalplayers(ArrayList<Player> players, ArrayList<Item> items, ArrayList<Team> teams) throws ExcepcioJugadorRepetit {

    boolean conf = true;
    do {
      System.out.println();
      System.out.println("    JUGADORS    ");
      System.out.println("1.1.1.- Crear jugador ");
      System.out.println("1.1.2.- Mostrar jugadors ");
      System.out.println("1.1.3.- Esborrar jugador ");
      System.out.println("1.1.4.- Assignar jugador a equip ");
      System.out.println("1.1.5.- Assignar objecte a jugador ");
      System.out.println("1.1.6.- Eixir ");
      System.out.println();
      int opcio = Leer.leerEntero("Dis-me la opció que vols elegir: ");

      //SWITCH DE JUGADORS
      switch (opcio) {
        case 1:
          boolean cp = true;
          do {
            System.out.println();
            System.out.println("w- warrior");
            System.out.println("h- huma");
            System.out.println("a- alien");
            System.out.println();
            String jug = Leer.leerTexto("Quin tipo de personatge vols crear? ");

            int atac = 0;
            //Creem warrior
            if (jug.equalsIgnoreCase("w")) {
              do{
                atac = Leer.leerEntero("Disme els punts de atac: ");
              } while(atac < 1 || atac > 100);
              Warrior warrior = new Warrior(Leer.leerTexto("Dis-me el nom del personatge: "), atac,pd - atac , pv);
              addJugador(warrior);
              cp = false;
            }
            //Creem huma
            if (jug.equalsIgnoreCase("h")) {
              do{
                atac = Leer.leerEntero("Disme els punts de atac: ");
              } while(atac < 1 || atac > 100);
              Human human = new Human(Leer.leerTexto("Dis-me el nom del personatge: "), atac,pd - atac , pv);
              addJugador(human);
              cp = false;
            }
            //Creem alien
            if (jug.equalsIgnoreCase("a")) {
              do{
                atac = Leer.leerEntero("Disme els punts de atac: ");
              } while(atac < 1 || atac > 100);
              Alien alien = new Alien(Leer.leerTexto("Dis-me el nom del personatge: "), atac,pd - atac , pv);
              addJugador(alien);
              cp = false;
            }
          } while (cp);
          break;
        case 2:
          System.out.println("\n LLISTA DE JUGADOR ");
          for (Player p : players) {
            System.out.println(p);
          }
          break;
        case 3:
          String bj = Leer.leerTexto("Disme el nom del jugador que vols borrar: \n");
          Player elim = buscarJ(bj, players); //Llamamos a la funcion buscar para encontrar el jugador
          players.remove(elim); //Eliminamos el jugador de la lista de jugadores que tenemos
          System.out.println("El jugador ha segut eliminat! \n");
          break;
        case 4:
          String bj2 = Leer.leerTexto("Dis-me el nom del jugador que vols añadir a un equip: \n");
          Player afeP = buscarJ(bj2, players); //Busquem el jugador que anem a añadir
          String be = Leer.leerTexto("Dis-me el equip al qual el vols añadir: ");
          Team afeT = buscarE(be, teams); //Busquem el equip al que li anem a añadir un jugador
          try {
            afeT.afegir(afeP);
          } catch (ExcepcioJugadorRepetit e) {
            e.printStackTrace();
          }
          break;
        case 5:
          String bo = Leer.leerTexto("Dis-me el item del jugador que vols añadir: \n");
          Item afeI = buscarI(bo, items); //Busquem el item que volem añadir
          String bj3 = Leer.leerTexto("Dis-me el jugador al qual vols añadir-li un item: ");
          Player afeP2 = buscarJ(bj3, players); //Busquem el jugador per a añadir el itme
          afeP2.addItem(afeI); //Añadim el item al jugador
          break;
        case 6:
          conf = false;
          break;
        default:
          System.out.println("No has escollit cap opcio!");
          break;
      }
    } while (conf);
  }
}
