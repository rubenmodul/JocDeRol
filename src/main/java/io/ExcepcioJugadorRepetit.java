package io;

/**
 * Excepcion para que el jugador no este repetido
 */
public class ExcepcioJugadorRepetit extends Exception{
  //Crear una excepcio que hereda de la classe Exception
  public ExcepcioJugadorRepetit(String msg){
    super(msg);
  }
}
