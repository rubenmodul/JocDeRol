package joc;

import java.util.ArrayList;

public class Item {

  //Atributs
  private String name;
  private int attackBonus;
  private int defenseBonus;

  //Constructor
  public Item(String name, int attackBonus, int defenseBonus) {
    this.name = name;
    this.attackBonus = attackBonus;
    this.defenseBonus = defenseBonus;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAttackBonus() {
    return attackBonus;
  }

  public void setAttackBonus(int attackBonus) {
    this.attackBonus = attackBonus;
  }

  public int getDefenseBonus() {
    return defenseBonus;
  }

  public void setDefenseBonus(int defenseBonus) {
    this.defenseBonus = defenseBonus;
  }

  @Override
  public String toString() {
    return "- " + name + " BA: " + attackBonus + " / BD: " + defenseBonus;
  }
}
