package inici;

import joc.*;

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

    //Creem els equips
    System.out.println("CREEM ELS EQUIPS");
    Team los_ardillos = new Team("Los_Ardillos");
    Team barce = new Team("Barce");

    //Afegim personatges als equips
    barce.afegir(human);
    barce.afegir(alien);
    los_ardillos.afegir(warrior);

    //Mostrem els equips que hi han
    System.out.println("Mostrem jugadors añadits");
    System.out.println(los_ardillos);
    System.out.println(barce);

    //Eliminem algun equip
    barce.eliminar(alien);
    barce.eliminar(human);

    //Mostrem els equips que hi han per veure si el remove ha funcionat
    System.out.println("Mostrem jugadors un vegada eliminat");
    System.out.println(los_ardillos);
    System.out.println(barce);


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
