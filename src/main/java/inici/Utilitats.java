package inici;

import joc.Item;
import joc.Player;
import joc.Team;

import java.util.ArrayList;

import static inici.JocDeRol.players;
import static inici.JocDeRol.teams;

public class Utilitats {

  /**
   * Buscar jugadores en la arraylist
   * @param nom
   * @param players
   * @return
   */
  public static Player buscarJ(String nom, ArrayList<Player> players){
    for(Player p: players){
      if(nom.equalsIgnoreCase(p.getName())){
        return p;
      }
    }
    return null;
  }

  /**
   * Buscar equipos en la arraylist
   * @param equip
   * @param teams
   * @return
   */
  public static Team buscarE(String equip, ArrayList<Team> teams){
    for(Team t: teams){
      if(equip.equalsIgnoreCase(t.getName())){
        return t;
      }
    }
    return null;
  }

  /**
   * Buscra items en la arraylist
   * @param item
   * @param items
   * @return
   */
  public static Item buscarI(String item, ArrayList<Item> items){
    for(Item i: items){
      if(item.equalsIgnoreCase(i.getName())){
        return i;
      }
    }
    return null;
  }

  /**
   * Comprobar si el jugador ya esta creado
   * @param p1
   * @return
   */
  public static boolean addJugador(Player p1) {
    for (Player p : players) {
      if (p1.equals(p)) {
        return false;
      }
    }
    players.add(p1);
    return true;
  }

  /**
   * Comprobar si el item ya esta creado
   * @param i1
   * @param items
   * @return
   */
  public static boolean addItem(Item i1, ArrayList<Item> items) {
    for (Item i : items) {
      if (i1.getName().equalsIgnoreCase(i.getName())) {
        return false;
      }
    }
    items.add(i1);
    return true;
  }

  /**
   * Comprobar si el equipo ya esta creado
   * @param t1
   * @return
   */
  public static boolean addTeam(Team t1) {
    for (Team t : teams) {
      if (t1.getName().equalsIgnoreCase(t.getName())) {
        return false;
      }
    }
    teams.add(t1);
    return true;
  }
}
