package joc;

public class Warrior extends Human{

  public Warrior(String name, int attackPoints, int defensePoints, int life) {
    super(name, attackPoints, defensePoints, life);
    System.out.println("He creat un warrior!!");
  }

  @Override
  protected void hit(int attackPoints){

    int defensa = this.getDefensePoints();
    int vida = this.getLife();
    int ataqueF = attackPoints - defensa;

    if( ataqueF < 5){
      ataqueF = 0;
    }

    int vidaF = vida-ataqueF;

    if (vidaF <= 0){
      System.out.println("Muertisimo!!");
      vidaF = 0;
    } else {
      System.out.println(this.getName() + " és colpejat amb " + attackPoints + " punts i es defén amb " + this.getDefensePoints() + ". Vides: " + this.getLife() + " - " + (ataqueF) + " = " + vidaF);
    }
    this.setLife(vidaF);
  }
}
