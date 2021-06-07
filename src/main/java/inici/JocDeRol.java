package inici;

import io.ExcepcioAutoAtacarse;
import io.ExcepcioJugadorMort;
import io.ExcepcioJugadorRepetit;
import io.Leer;
import jdk.swing.interop.SwingInterOpUtils;
import joc.*;

import java.util.ArrayList;
import java.util.Objects;

import static inici.MenuP.*;
import static inici.MenuT.*;
import static inici.MenuI.*;
import static inici.Utilitats.*;

public class JocDeRol {

  //Creem les 3 arraylist
  public static ArrayList<Player> players = new ArrayList<>();
  public static ArrayList<Team> teams = new ArrayList<>();
  private static ArrayList<Item> items = new ArrayList<>();


  public static void main(String[] args) throws ExcepcioJugadorRepetit {

    //Creem un boolean per a seguir juant o no
    boolean menu = true;

    do {
      boolean conf = true;
      boolean jugar = true;
      System.out.println();
      System.out.println("        BENVINGUTS AL JOC DE ROL     \n");
      System.out.println("1.- Configuració ");
      System.out.println("2.- Jugar ");
      System.out.println("3.- Eixir ");
      System.out.println();
      int opcio = Leer.leerEntero("Dis-me la opció que vols elegir: ");

      //SWITCH INICIAL
      switch (opcio) {
        case 1:
          do {
            System.out.println();
            System.out.println("    CONFIGURACIO    ");
            System.out.println("1.1.- Gestió jugadors ");
            System.out.println("1.2.- Gestió equips ");
            System.out.println("1.3.- Gestió objectes ");
            System.out.println("1.4.- Eixir ");
            System.out.println();
            int opcio2 = Leer.leerEntero("Dis-me la opció que vols elegir: ");

            //SWITCH DE CONFIGURACIO
            switch (opcio2) {
              case 1:
                menuprincipalplayers(players, items, teams);
                break;
              case 2:
                menuprincipalteams(players, items, teams);
                break;
              case 3:
                menuprincipalitems(players, items, teams);
                break;
              case 4:
                conf = false;
                break;
              default:
                System.out.println("ERROR. No has elegit cap opció !");
            }

          } while (conf);
          break;
        case 2:

          //Creamos 3 bots
          Human bot1 = new Human("bot1", 10, 2, 100);
          players.add(bot1);
          Alien bot2 = new Alien("bot2", 25, 10, 100);
          players.add(bot2);
          Warrior bot3 = new Warrior("bot3", 35, 7, 100);
          players.add(bot3);


          while (jugar) {
            int jugadoresv = 0;
            for (Player atacante : players) {
              Player defensor;
              do {
                defensor = players.get((int) (Math.random() * players.size()));
              } while (defensor.equals(atacante));
              try {
                atacante.attack(defensor);
                if (!atacante.vivo()) {
                  System.out.println("El jugador " + atacante.getName() + " ha muerto!");
                }
                if (!defensor.vivo()) {
                  System.out.println("El jugador " + defensor.getName() + " ha muerto!");
                }
              } catch (ExcepcioJugadorMort excepcioJugadorMort) {
                excepcioJugadorMort.printStackTrace();
              } catch (ExcepcioAutoAtacarse excepcioAutoAtacarse) {
                excepcioAutoAtacarse.printStackTrace();
              }
              Leer.leerTexto("Pulsa una tecla para continuar");
              for (Player player : players) {
                if (player.vivo()) {
                  jugadoresv++;
                }
              }
              if (jugadoresv == 1) {
                for (Player p : players) {
                  if (p.getLife()>0) {
                    System.out.println("El ganador es " + p.getName());
                  }
                }
                return;
              }
            }
          }
        case 3:
          menu = false;
          System.out.println("Gracias por jugar, espero que lo hayas disfrutado !");
          break;
        default:
          System.out.println("ERROR. No has elegit ninguna opció!");
      }
    } while (menu);

    //provaFrase();
  }

  /**
   * ProvaFase la utilizamos durante la construccion de nuestro juego para provar funciones
   *
   * @throws ExcepcioJugadorRepetit
   */
  public static void provaFrase() throws ExcepcioJugadorRepetit {
    System.out.println("Human");
    Human human = new Human("Choumi", 6, 4, 50);
    System.out.println("Alien");
    Alien alien = new Alien("Predator", 7, 3, 75);
    System.out.println("Warrior");
    Warrior warrior = new Warrior("Cubanito", 8, 2, 50);

    //Creem els equips
    System.out.println("CREEM ELS EQUIPS");
    Team los_ardillos = new Team("Los_Ardillos");
    Team barce = new Team("Barce");

    //Creem els items
    Item espada = new Item("espada", 10, 4);
    Item escudo = new Item("escudo", 1, 10);
    Item pistola = new Item("pistola", 25, 1);

    //Afegim personatges als equips
    barce.afegir(human);
    barce.afegir(alien);
    los_ardillos.afegir(warrior);

    //Mostrem els equips que hi han
    System.out.println("Mostrem jugadors añadits");
    System.out.println(los_ardillos);
    System.out.println(barce);

    //Eliminem algun equip
    //barce.eliminar(alien);
    //barce.eliminar(human);

    //Mostrem els equips que hi han per veure si el remove ha funcionat
    System.out.println("Mostrem jugadors un vegada eliminats del equip");
    System.out.println(los_ardillos);
    System.out.println(barce);

    //Añadim itmes als personatges
    human.addItem(espada);
    alien.addItem(escudo);
    warrior.addItem(pistola);

    System.out.println();
    System.out.println("BATALLA ENTRE ALIEN I HUMAN");
    System.out.println();
    //alien.attack(human);
    System.out.println();
    System.out.println("BATALLA ENTRE WARRIOR I HUMA");
    System.out.println();
    //warrior.attack(human);
  }
}
