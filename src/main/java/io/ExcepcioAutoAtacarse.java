package io;

/**
 * Excepcion de no auto atacarse el mismo jugador
 */
public class ExcepcioAutoAtacarse extends Exception{
  //Crear una excepcio que hereda de la classe Exception
  public ExcepcioAutoAtacarse(String msg){
    super(msg);
  }
}
