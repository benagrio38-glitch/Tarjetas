import java.util.Arrays;

public class OrdenarTarjetas {

    // Contadores globales de la última ejecución
    static int comparaciones;
    static int intercambios;
    static int pasadas;

    // Ordena de menor a mayor e imprime el arreglo al terminar cada pasada
    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        comparaciones = 0;
        intercambios = 0;
        pasadas = 0;

        boolean huboIntercambio = true;

        while (pasadas < n - 1 && huboIntercambio) {
            huboIntercambio = false;

            // Las últimas 'pasadas' tarjetas ya están en su lugar definitivo
            for (int posicion = 0; posicion < n - 1 - pasadas; posicion++) {
                comparaciones++;
                if (arreglo[posicion] > arreglo[posicion + 1]) {
                    int auxiliar = arreglo[posicion];
                    arreglo[posicion] = arreglo[posicion + 1];
                    arreglo[posicion + 1] = auxiliar;
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            pasadas++;
            System.out.println("Pasada " + pasadas + ": " + Arrays.toString(arreglo));
        }
    }

    // Variación opcional: orden alfabético con compareTo
    public static void bubbleSort(String[] arreglo) {
        int n = arreglo.length;
        comparaciones = 0;
        intercambios = 0;
        pasadas = 0;

        boolean huboIntercambio = true;

        while (pasadas < n - 1 && huboIntercambio) {
            huboIntercambio = false;

            for (int posicion = 0; posicion < n - 1 - pasadas; posicion++) {
                comparaciones++;
                if (arreglo[posicion].compareTo(arreglo[posicion + 1]) > 0) {
                    String auxiliar = arreglo[posicion];
                    arreglo[posicion] = arreglo[posicion + 1];
                    arreglo[posicion + 1] = auxiliar;
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            pasadas++;
            System.out.println("Pasada " + pasadas + ": " + Arrays.toString(arreglo));
        }
    }

    private static void imprimirResumen() {
        System.out.println("Total de pasadas: " + pasadas);
        System.out.println("Total de comparaciones: " + comparaciones);
        System.out.println("Total de intercambios: " + intercambios);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ejemplo = {34, 12, 25, 8, 19};
        int[] ordenado = {8, 12, 19, 25, 34};
        int[] inverso = {34, 25, 19, 12, 8};
        String[] nombres = {"Marta", "Luis", "Ana", "Sofía", "Beto"};

        System.out.println("--- Arreglo de ejemplo ---");
        bubbleSort(ejemplo);
        imprimirResumen();

        System.out.println("--- Arreglo ya ordenado ---");
        bubbleSort(ordenado);
        imprimirResumen();

        System.out.println("--- Arreglo en orden inverso ---");
        bubbleSort(inverso);
        imprimirResumen();

        System.out.println("--- Arreglo de String ---");
        bubbleSort(nombres);
        imprimirResumen();
    }
}