import java.awt.*;
import java.io.*;

/**
 * Clase que muetra el proximo numero palindromo
 * @author
 */
public class PuntoPalíndromos {

    /**
     * Metodo que busca el proximo palindromo y lo escribe en un archivo
     * @variable <bf> bufer nos va permitir acceder a un archivo
     * @variable <bw> bufer nos va permitir crear  un archivo
     * @variable <numero> representa los numero que contiene el archivo
     * @variable <cadena> representa los numeros que contiene el archivo en forma de String
     * @variable <tamano> es el tamaño (cantidad de caracteres) del numero
     * @variable <polindromo> controla si se econtro o no el numero (verdadero o falso)
     * @variables <mitadA, mitadB> son las mitades de la cadena a comparar
     */
    public static void leerArchivo() throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("./entrada.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("./salida.out"));
        int numero = 0, tamano = 0;
        String cadena = "", mitadA, mitadB;
        boolean polindorno = false;

        // Recorremos todas las lineas del archivo
        while ((cadena = bf.readLine()) != null) {

            polindorno = false;// en cada linea permitimos la busqueda por lo menos una vez

            while(!polindorno){

                tamano = cadena.length();

                // Si el tamaño del numero es par los partimos a la mitad sino sumanos 1 a la mitad para no tomar
                // el numero situado en la mitad del mismo
                mitadA = cadena.substring(0,(tamano/2));
                mitadB = (tamano % 2 == 0 )?
                           new StringBuilder(cadena.substring((tamano/2), tamano)).reverse().toString()
                         : new StringBuilder(cadena.substring((tamano/2)+1, tamano)).reverse().toString();

                //Dividimos la cadena en dos Strings y la conparamos pero la segun parte la reversamos ej : abc ->n cba
                // si son iguales encontramos el numero
                if(mitadA.equals(mitadB)){
                    polindorno = true;
                    bw.write(cadena+"\n");
                }else{

                   // convertimos la cadena a numero para poderle aumentar de a 1
                   numero = Integer.parseInt(cadena);
                   numero++;
                   cadena = Integer.toString(numero);
                }
            }

        }
        bw.close();

    }


    public static void main(String args[]) throws IOException {
        leerArchivo();
    }


}
