package joc;

import io.ExcepcioAutoAtacarse;
import io.ExcepcioJugadorMort;

public class Alien extends Player{


  /**
   * @param name
   * @param attackPoints
   * @param defensePoints
   * @param life
   */
  public Alien(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);

    System.out.println("He creado un alien!");
  }

  /**
   * @param p
   * @throws ExcepcioJugadorMort
   * @throws ExcepcioAutoAtacarse
   */
  @Override
  public void attack(Player p) throws ExcepcioJugadorMort, ExcepcioAutoAtacarse {
    if(this.getLife()==0 || p.getLife() == 0) {
      throw new ExcepcioJugadorMort("Esta muerto jeje");
    }
    if(this.equals(p)){
      throw new ExcepcioAutoAtacarse("No se puede atacar a si mismo");
    }
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
