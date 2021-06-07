package joc;

import io.ExcepcioJugadorRepetit;
import io.ExcepcionLlevarJugador;

import java.util.ArrayList;
import java.util.Comparator;

public class Team {

  //Atributs
  String name;
  ArrayList<Player> players;

  //Constructor
  public Team(String name) {
    this.name = name;
    players = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    String cadena = "";
    for (Player p : players) {
      cadena += "   " + p + "\n";
    }
    return "Equip " + name + "\n" +
            cadena;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public void setPlayers(ArrayList<Player> players) {
    this.players = players;
  }

  public boolean equals(Team t) {
    if (this.name.compareTo(t.name) == 0 && this.players == t.players){
      return true;
    }
    return false;
  }

  //Metodos
  public void afegir(Player p) throws ExcepcioJugadorRepetit {
    if (this.players.contains(p)) {
      throw new ExcepcioJugadorRepetit("El jugador ya esta!");
    }

    this.players.add(p);
    if(!p.getTeams().contains(this)){
      p.afegir(this);
    }
  }
  public void eliminar(Player p) throws ExcepcionLlevarJugador {
    if(!p.getTeams().contains(this)){
      throw new ExcepcionLlevarJugador("Este jugador no pertany a este equip!");
    }
    this.players.remove(p);
    if(p.getTeams().contains(this)){
      p.eliminar(this);
    }
  }
}
