package inici;

import io.ExcepcioJugadorRepetit;
import io.Leer;
import joc.Item;
import joc.Player;
import joc.Team;

import java.util.ArrayList;

import static inici.Utilitats.*;

public class MenuT {
  public static void menuprincipalteams(ArrayList<Player> players, ArrayList<Item> items, ArrayList<Team> teams) throws ExcepcioJugadorRepetit {
    boolean seguir  =true;
    do{
      System.out.println();
      System.out.println("    EQUIPS    ");
      System.out.println("1.2.1.- Crear equip ");
      System.out.println("1.2.2.- Mostrar equips ");
      System.out.println("1.2.3.- Esborrar equip ");
      System.out.println("1.2.4.- Assignar equip a jugador ");
      System.out.println("1.2.5.- Eixir ");
      System.out.println();
      int opcio = Leer.leerEntero("Dis-me la opció que vols elegir: ");

      //SWITCH DE EQUIPS
      switch (opcio){
        case 1:
          Team equip = new Team(Leer.leerTexto("Dis-me el nom del equip: "));
          if(addTeam(equip)){
            System.out.println("Añadido");
          } else{
            System.out.println("Ya esta creado");
          }
          break;
        case 2:
          System.out.println("\n LLISTA DE EQUIPS");
          for(Team t: teams){
            System.out.println(t);
          }
          break;
        case 3:
          String be = Leer.leerTexto("Dis-me el nom del equip que vols borrar: \n");
          Team elim = buscarE(be, teams); //Llamamos a la funcion buscar para encontrar el equipo
          teams.remove(elim); //Eliminamos el equipo de la lista de equipos que tenemos
          System.out.println("El equip ha segut eliminat! \n");
          break;
        case 4:
          String be2 = Leer.leerTexto("Dis-me el nom del equip: \n");
          Team afeT = buscarE(be2, teams);
          String bj = Leer.leerTexto("Dis-me el nom del jugador: \n");
          Player afeP = buscarJ(bj, players);
          try{
            afeP.afegir(afeT);
          } catch(ExcepcioJugadorRepetit e){
            e.printStackTrace();
          }
          break;
        case 5:
          seguir = false;
          break;
        default:
          System.out.println("No has escollit cap opcio!");
      }
    } while(seguir);
  }
}
