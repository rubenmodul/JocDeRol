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
    Human human = new Human("Choumi", 60,40,350);
    System.out.println("Alien");
    Alien alien = new Alien("Predator", 75, 30, 275);
    System.out.println("Warrior");
    Warrior warrior = new Warrior("Cubanito", 100,20,250);
    System.out.println();
    System.out.println("BATALLA ENTRE HUMA I ALIEN");
    System.out.println();
    human.attack(alien);
    System.out.println();
    System.out.println("BATALLA ENTRE WARRIOR I HUMA");
    System.out.println();
    warrior.attack(human);
  }
}
