package joc;

public class Human extends Player{


  /**
   * @param name
   * @param attackPoints
   * @param defensePoints
   * @param life
   */
  public Human(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);

    if (life > 100){ super.setLife(100); }

    System.out.println("He creat un humá!!");
  }
}
