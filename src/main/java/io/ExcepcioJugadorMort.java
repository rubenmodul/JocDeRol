package io;

/**
 * Excepcion de comprobar el jugador esta muerto
 */
public class ExcepcioJugadorMort extends Exception{
  //Crear una excepcio que hereda de la classe Exception
  public ExcepcioJugadorMort(String msg){super(msg); }
}
