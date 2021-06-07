package joc;

import io.ExcepcioAutoAtacarse;
import io.ExcepcioJugadorMort;
import io.ExcepcioJugadorRepetit;
import io.ExcepcionLlevarJugador;

import java.util.ArrayList;

/**
 * Creamos el player
 */
public abstract class Player {

  //Atributs
  private String name;
  private int attackPoints;
  private int defensePoints;
  private int life;
  private ArrayList<Team> teams;
  private ArrayList<Item> items;


  /**
   * @param name
   * @param attackPoints
   * @param defensePoints
   * @param life
   */
  public Player(String name, int attackPoints, int defensePoints, int life) {
    this.name = name;
    this.setAttackPoints(attackPoints);
    this.setDefensePoints(defensePoints);
    this.setLife(life);
    setTeams(new ArrayList<>());
    setItems(new ArrayList<>());

  }

  /**
   * @param p
   * @throws ExcepcioJugadorMort
   * @throws ExcepcioAutoAtacarse
   */
  public void attack(Player p) throws ExcepcioJugadorMort, ExcepcioAutoAtacarse {
    if(this.getLife()==0 || p.getLife() == 0){
      throw new ExcepcioJugadorMort("Esta muerto jeje");
    }
    if(this.equals(p)){
      throw new ExcepcioAutoAtacarse("No se puede atacar a si mismo");
    }
    System.out.println("--------------- ABANS L'ATAC --------------");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+p);
    System.out.println("--------------- DURANT L'ATAC --------------");
    int ataque = getAttackPoints();
    for(Item i : this.items){
      ataque += i.getAttackBonus();
    }
    p.hit(ataque);
    //CONTRAACTAC si encara esta viu
    if (p.life > 0) {
      int ataquep = p.attackPoints;
      for(Item i : p.items){
        ataquep += i.getAttackBonus();
      }
      this.hit(ataquep);
    }
    System.out.println("--------------- DESPRES L'ATAC --------------");
    System.out.println("Atacant: "+this);
    System.out.println("Atacat: "+p);
  }

  /**
   * La defensa
   * @param attackPoints
   */
  protected void hit(int attackPoints){

    int defensa = this.getDefensePoints();
    //Sumamos la defensa con la ayuda de los items
    for(Item i: this.items){
      defensa+=i.getDefenseBonus();
    }
    int vida = this.getLife();
    int ataqueF = attackPoints - defensa;
    int vidaF = vida-ataqueF;

    if (vidaF <= 0){
      System.out.println("Muertisimo!!");
      vidaF = 0;
    } else {
      System.out.println(this.getName() + " és colpejat amb " + attackPoints + " punts i es defén amb " + defensa + ". Vides: " + this.getLife() + " - " + (ataqueF) + " = " + vidaF);
    }
    this.setLife(vidaF);
  }

  //Metodos
  //Añadir equipos
  public void afegir(Team t) throws ExcepcioJugadorRepetit {
    if(this.teams.contains(t)){
      throw new ExcepcioJugadorRepetit("El jugador ya existix");
    }
    this.getTeams().add(t);
    if(!t.players.contains(this)){
      t.afegir(this);
    }
  }

  //Eliminar equipo
  public void eliminar(Team t) throws ExcepcionLlevarJugador {
    if(!t.players.contains(this)){
      throw new ExcepcionLlevarJugador("Este jugador no esta en este equip");
    }
    this.getTeams().remove(t);
    if(t.players.contains(this)){
      t.eliminar(this);
    }
  }

  //Comparar jugadores
  public boolean equals(Player p) {
    if (this.name.compareTo(p.name) == 0 && this.attackPoints - p.getAttackPoints() == 0 && this.defensePoints - p.getDefensePoints() == 0 && this.life - p.getLife() == 0){
      return true;
    }
    return false;
  }

  //Añadir items
  public void addItem(Item i){
    this.items.add(i);
  }

  //Eliminar items
  public void removeItem(Item i){
    this.items.remove(i);
  }


  public boolean vivo() {
    if (this.getLife() > 0) {
      return true;
    }
    return false;
  }
  @Override
  public String toString() {
    String cadena = "";
    for(Item i: items){
      cadena += "   " + i + "\n";
    }
    return this.name+" PA:"+this.attackPoints+" / PD:"+defensePoints+" / PV:"+life+" (pertany a " + this.getTeams().size() + " equips) té els itéms:\n" + cadena;
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

  public ArrayList<Item> getItems() {
    return items;
  }

  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }
}
