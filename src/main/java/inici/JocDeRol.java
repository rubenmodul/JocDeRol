package inici;

import joc.Alien;
import joc.Human;
import joc.Player;
import joc.Warrior;

import java.util.Objects;

public class JocDeRol {
  public static void main(String[] args) {

    provaFrase();


  }

  public static void provaFrase(){
    System.out.println("Human");
    Human human = new Human("Choumi", 6,4,50);
    System.out.println("Alien");
    Alien alien = new Alien("Predator", 7, 3, 75);
    System.out.println("Warrior");
    Warrior warrior = new Warrior("Cubanito", 8,2,50);
    System.out.println();
    System.out.println("BATALLA ENTRE ALIEN I HUMAN");
    System.out.println();
    alien.attack(human);
    System.out.println();
    System.out.println("BATALLA ENTRE WARRIOR I HUMA");
    System.out.println();
    warrior.attack(human);
  }
}
