import java.util.Random;
/**
 *    
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        System.out.println("Nºmaximo de aleatorios a generar " + n + " o hasta que salga el 0");
        System.out.println();
        int contador = 0;
        int aleatorio = generador.nextInt(6001)-1000;
        double media = 0;
        int sImpar = 0;
        int mPar = Integer.MIN_VALUE;
        while(contador <= n || aleatorio == 0) {
            System.out.printf("%15d"+"%s"+"%10d",aleatorio, ":" , obtenerNumeroSinCeros(aleatorio)); 
            media += aleatorio;
            if(esImpar(aleatorio)) {
                sImpar += aleatorio;
            }
            
            if (aleatorio > mPar && !esImpar(aleatorio)) {
                mPar= aleatorio;
            }
            contador++;
            aleatorio = generador.nextInt(6001)-1000;
            if (contador % 10 == 5 || contador % 10 == 0) {
                System.out.println();
            }

        }

        media = media / n;
        System.out.println();
        System.out.println();
        System.out.printf("%25s" + "%10.2f", "Media: ",media);
        System.out.println();
        System.out.printf("%25s" + "%10d", "Suma impares: ",sImpar);
        System.out.println();
        if (mPar == Integer.MIN_VALUE){
            System.out.println("No hay ningun par");
        }
        else{
            System.out.printf("%25s" + "%10d", "Máximo pares: ",mPar);
        }

    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        while(numero % 2 != 0) {
            return true;
        }
        return  false;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int cifra = 0;
        int exponente = 0;
        int numeroFinal = 0;
        while(numero != 0) {
            cifra = numero % 10;
            numero= numero/ 10;
            if(cifra != 0) {

                numeroFinal+= cifra * Math.pow(10,exponente);
                exponente++;
            }

        }
        return numeroFinal;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {
        // int numero = 0;
        // int contador = 0;
        // for(int i = 1; i <= altura; i++) {
        // escribirCaracter(CARACTER , 1);
        // escribirCaracter(ESPACIO,numero);
        // escribirCaracter(CARACTER , 1);
        // numero +=1;
        // // int numero2 = numero-;
        // escribirCaracter(ESPACIO,numero);
        // escribirCaracter(CARACTER , 1);
        // System.out.println();

        int numero1 = 0;
        int numero2 = altura - 1;
        for(int i = 1; i<= altura; i++){
            escribirCaracter(CARACTER,1);
            escribirCaracter(ESPACIO,numero1);
            escribirCaracter(CARACTER,1);
            escribirCaracter(ESPACIO,numero2);
            escribirCaracter(CARACTER,1);
            System.out.println();
            numero1++;
            numero2--;
        }
    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {
        for(int i = 1; i <= n; i++) {
            System.out.printf("%s",caracter);
        }
    }
}
