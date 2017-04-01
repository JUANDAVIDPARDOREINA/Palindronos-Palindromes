import java.awt.*;
import java.io.*;

/**
 * Created by JUANDAVID on 30/03/17.
 */
public class PuntoPalíndromos {

    public static void leerArchivo() throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("./entrada.in"));
        int numero = 0;
        String cadena = "";
        int tamano = 0;
        boolean polindorno = false;

        while ((cadena = bf.readLine()) != null) {
            polindorno = false;
            while(!polindorno){
                tamano = cadena.length();
                if (tamano % 2 == 0 ) {

                    if(cadena.substring(0,(tamano/2)).equals(new StringBuilder(cadena.substring((tamano/2), tamano)).reverse().toString())){
                        polindorno = true;
                        System.out.println(cadena);
                    }else{
                       numero = Integer.parseInt(cadena);
                       numero++;
                       cadena = Integer.toString(numero);
                        System.out.println(cadena.substring(0,(tamano/2)));
                        System.out.println(new StringBuilder(cadena.substring((tamano/2), tamano)).reverse());

                    }
                }else{
                    if(cadena.substring(0,(tamano/2)).equals(new StringBuilder(cadena.substring((tamano/2)+1, tamano)).reverse().toString())){
                        polindorno = true;
                        System.out.println(cadena);
                    }else{
                        numero = Integer.parseInt(cadena);
                        numero++;
                        cadena = Integer.toString(numero);
                        System.out.println(cadena.substring(0,(tamano/2)));
                        System.out.println(new StringBuilder(cadena.substring((tamano/2)+1, tamano)).reverse());
                    }
                }

            }
            
        }

    }


    public static void main(String args[]) throws IOException {
        leerArchivo();
    }


}
