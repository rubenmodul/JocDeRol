package io;

/**
 * Excepcion de no poder eliminar un jugador de un equipo en el que no esta
 */
public class ExcepcionLlevarJugador extends Exception{
  //Crear una excepcio que hereda de la classe Exception
  public ExcepcionLlevarJugador(String msg){
    super(msg);
  }
}

