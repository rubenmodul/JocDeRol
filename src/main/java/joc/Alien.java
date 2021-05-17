package joc;

public class Alien extends Player{


  public Alien(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);

    System.out.println("He creado un alien!");
  }

  @Override
  public void attack(Player p){
    System.out.println("--------------- ABANS L'ATAC --------------");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+p);
    System.out.println("--------------- ATAC --------------");

    if(this.getLife() > 20){
      this.setAttackPoints(this.getAttackPoints()+3);
      this.setDefensePoints(this.getDefensePoints()-3);
    }

    p.hit(this.getAttackPoints());
    //CONTRAACTAC si encara esta viu
    if (p.getLife() > 0) {
      this.hit(p.getAttackPoints());
    }
    System.out.println("--------------- DESPRES L'ATAC --------------");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+p);
  }
}
