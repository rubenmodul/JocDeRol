package joc;

import java.util.ArrayList;

public abstract class Player {

  //Atributs
  private String name;
  private int attackPoints;
  private int defensePoints;
  private int life;
  private ArrayList<Team> teams;


  public Player(String name, int attackPoints, int defensePoints, int life) {
    this.name = name;
    this.setAttackPoints(attackPoints);
    this.setDefensePoints(defensePoints);
    this.setLife(life);
    setTeams(new ArrayList<>());
  }

  public void attack(Player p){
    System.out.println("--------------- ABANS L'ATAC --------------");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+p);
    System.out.println("--------------- ATAC --------------");
    p.hit(this.getAttackPoints());
    //CONTRAACTAC si encara esta viu
    if (p.life > 0) {
      this.hit(p.getAttackPoints());
    }
    System.out.println("--------------- DESPRES L'ATAC --------------");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+p);
  }

  protected void hit(int attackPoints){

    int defensa = this.getDefensePoints();
    int vida = this.getLife();
    int ataqueF = attackPoints - defensa;
    int vidaF = vida-ataqueF;

    if (vidaF <= 0){
      System.out.println("Muertisimo!!");
      vidaF = 0;
    } else {
      System.out.println(this.getName() + " és colpejat amb " + attackPoints + " punts i es defén amb " + this.getDefensePoints() + ". Vides: " + this.getLife() + " - " + (ataqueF) + " = " + vidaF);
    }
    this.setLife(vidaF);
  }

  //Metodos
  public void afegir(Team t){
    this.getTeams().add(t);
    if(!t.players.contains(this)){
      t.afegir(this);
    }
  }

  public void eliminar(Team t){
    this.getTeams().remove(t);
    if(t.players.contains(this)){
      t.eliminar(this);
    }
  }

  public boolean equals(Player p) {
    if (this.name.compareTo(p.name) == 0 && this.attackPoints - p.getAttackPoints() == 0 && this.defensePoints - p.getDefensePoints() == 0 && this.life - p.getLife() == 0){
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return this.name+" PA:"+this.attackPoints+" / PD:"+defensePoints+" / PV:"+life+" (pertany a " + this.getTeams().size() + " equips)";
  }

  public String getName() {
    return name;
  }

  public int getAttackPoints() {
    return attackPoints;
  }

  public int getDefensePoints() {
    return defensePoints;
  }

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public void setAttackPoints(int attackPoints) {
    this.attackPoints = attackPoints;
  }

  public void setDefensePoints(int defensePoints) {
    this.defensePoints = defensePoints;
  }

  public ArrayList<Team> getTeams() {
    return teams;
  }

  public void setTeams(ArrayList<Team> teams) {
    this.teams = teams;
  }
}
