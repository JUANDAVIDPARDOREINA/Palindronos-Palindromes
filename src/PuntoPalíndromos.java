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
     * @variable <numero> representa los numero que contiene el archivo este valor es entero para poder hacer operaciones mate,aticas
     * @variable <cadena> representa los numeros que contiene el archivo en forma de String
     * @variable <tamano> es el tamaño (cantidad de caracteres) del numero
     * @variable <polindromo> controla si se econtro o no el numero (verdadero o falso)
     * @variables <mitadA, mitadB> son las mitades de la cadena a comparar
     * @variables <mitadAC> es e numero central si si la cantidad de caracteres es impar
     */
    public static void leerArchivo() throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("./entrada.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("./salida.out"));
        int numero = 0, tamano = 0;
        String cadena = "", mitadA, mitadC, mitadB;


        // Recorremos todas las lineas del archivo
        while ((cadena = bf.readLine()) != null) {

            tamano = cadena.length();

            mitadA = (tamano == 1)? cadena : cadena.substring(0,(tamano/2));
            numero = Integer.parseInt(mitadA);

            // Si el tamaño del numero es par los partimos a la mitad sino sumanos 1 a la mitad para no tomar
            // el numero situado en la mitad del mismo
            if(tamano % 2 == 0 ){
                mitadB  = (tamano == 1)? "0" : new StringBuilder(cadena.substring((tamano/2), tamano)).toString();

                // Si la cantidad de caracteres es par entonces jugaremos sin un pivote central mitadAC
                if(Integer.parseInt(mitadA)  >= Integer.parseInt(mitadB)){
                    cadena = mitadA+(new StringBuilder(mitadA).reverse());
                }else{
                // Si la mitad de la izquierda es menor sumaremos 1 y la segunda mitad sera esta primera reversada
                    numero = numero + 1;
                    cadena = numero+(new StringBuilder(""+numero).reverse().toString());
                }

            }else if (tamano == 1){
                cadena = cadena;
            }else{
                mitadC = cadena.substring((tamano/2), (tamano/2)+1);
                mitadB  = new StringBuilder(cadena.substring((tamano/2)+1, tamano)).toString();

                // Si la cantidad de caracteres es impar jugaremos un pivote que sera el caracter medio
                if(Integer.parseInt(mitadA)  >= Integer.parseInt(mitadB)){
                    cadena = mitadA+mitadC+(new StringBuilder(mitadA).reverse());
                }else{
                    mitadC = ""+(Integer.parseInt(mitadC)+1);
                    cadena = mitadA+mitadC+(new StringBuilder(mitadA).reverse().toString());
                }

            }

            // Escribimos los resultados en el archivo
            bw.write(cadena+"\n");
        }
        bw.close();

    }


    public static void main(String args[]) throws IOException {
        leerArchivo();
    }


}
