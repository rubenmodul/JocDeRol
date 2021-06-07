package io;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leer {
  private static final BufferedReader entradaConsola;

  public Leer() {
  }

  public static String leerTexto(String mensaje) {
    String respuesta = null;

    do {
      try {
        System.out.print(mensaje);
        respuesta = entradaConsola.readLine();
      } catch (IOException var3) {
        return "";
      }
    } while(respuesta == null);

    return respuesta;
  }

  public static int leerEntero(String mensaje) {
    int n = 0;
    boolean correcto = false;

    while(!correcto) {
      try {
        n = Integer.parseInt(leerTexto(mensaje));
        correcto = true;
      } catch (NumberFormatException var4) {
        System.out.println("Tienes que introducir un nÃºmero correcto");
      }
    }

    return n;
  }

  public static double leerDouble(String mensaje) {
    double n = 0.0D;
    boolean correcto = false;

    while(!correcto) {
      try {
        n = Double.parseDouble(leerTexto(mensaje));
        correcto = true;
      } catch (NumberFormatException var5) {
        System.out.println("Tienes que introducir un nÃºmero correcto");
      }
    }

    return n;
  }

  public static float leerFloat(String mensaje) {
    float n = 0.0F;
    boolean correcto = false;

    while(!correcto) {
      try {
        n = Float.parseFloat(leerTexto(mensaje));
        correcto = true;
      } catch (NumberFormatException var4) {
        System.out.println("Tienes que introducir un nÃºmero correcto");
      }
    }

    return n;
  }

  public static Date leerFecha(String mensaje) {
    Date fecha = new Date();
    DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
    boolean correcto = false;

    while(!correcto) {
      try {
        String entrada = leerTexto("Format DD/MM/YYYY: ");
        fecha = formatar.parse(entrada);
        correcto = true;
      } catch (ParseException | NumberFormatException var5) {
        System.out.println("Tienes que introducir una fecha correcta");
      }
    }

    return fecha;
  }

  public static boolean leerBoolean(String mensaje) {
    boolean n = false;
    n = Boolean.parseBoolean(leerTexto(mensaje));
    return n;
  }

  static {
    entradaConsola = new BufferedReader(new InputStreamReader(System.in));
  }
}
