import java.util.Arrays;

public class Ordenamiento {

    public static int[] quickSort(int[] arr){
        return quickSort(arr, 0, arr.length-1);
    }

    public static int[] quickSort(int[] arr, int lo, int hi){
        if (lo >= hi) //Cuando no hay algo más para comparar.
            return arr;

        int i = lo, d = hi; //Variables auxiliares para el pivote

        int pivote;
        int aux;
        pivote = lo;
        while (lo != hi) { //Mientras haya elementos a comparar
            while (arr[hi] >= arr[pivote] && lo < hi)
                hi--;
            while (arr[lo] < arr[pivote] && lo < hi)
                lo++;

            if (hi != lo) { //Swap para ordenar
                aux = arr[hi];
                arr[hi] = arr[lo];
                arr[lo] = aux;
            }
            if (lo == hi) { //Buscamos un nuevo pivote para terminar de ordenar.
                quickSort(arr, i, lo - 1);
                quickSort(arr, lo + 1, d);
            }
        }
        return arr;
    }


    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int [] arr, int low, int high) {
        if (high <= low) return; //Cuando ya se llega a la minima separación

        int mid = (low+high)/2;
        mergeSort(arr, low, mid);//Dividimos la primer mitad
        mergeSort(arr, mid+1, high); //Dividimos la segunda mitad
        merge(arr, low, mid, high); //Juntamos mitades
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] lArr = new int[mid - low + 1];
        int[] rArr = new int[high - mid];

        //Copiamos los datos de cada mitad en los arreglos
        for (int i = 0; i < lArr.length; i++)
            lArr[i] = arr[low + i];

        for (int i = 0; i < rArr.length; i++)
            rArr[i] = arr[mid + i + 1];

        //Iteradores para recorrer las mitades de arreglos y ordenarlos
        int lIndex = 0;
        int rIndex = 0;

        for (int i = low; i < high + 1; i++) {
            //Si aún hay elementos comparables
            if (lIndex < lArr.length && rIndex < rArr.length) {
                if (lArr[lIndex] < rArr[rIndex]) {
                    arr[i] = lArr[lIndex++];
                } else {
                    arr[i] = rArr[rIndex++];
                }
            } else if (lIndex < lArr.length) { //Si ya se terminaron los elementos en el arreglo derecho
                arr[i] = lArr[lIndex++];
            } else if (rIndex < rArr.length) { //Si ya se terminaron los elementos del arreglo izquierdo
                arr[i] = rArr[rIndex++];
            }
        }
    }

    /**
     * Método que busca la posición del elemento que quieras buscar.
     * @param arr - arreglo en el que buscaremos.
     * @param elem - elemento a buscar.
     * @return la posición del elemento a buscar.
     * -1 si no existe el elemento en el arreglo.
     */

    public static int find(int[] arr, int elem){
        return find(arr, elem, 0, arr.length - 1);
    }

    /**
     * Método para buscar un elemento en un arreglo.
     * @param arr - arreglo en el que se va a buscar.
     * @param elem - elemento que buscamos.
     * @param lo - índice de inicio.
     * @param hi - índice de fin.
     * @return la posición del elemento que buscamos.
     * -1 si el elemento no existe en el arreglo.
     */

    public static int find ( int[] arr, int elem, int lo, int hi){
        if (lo > hi) { //Si no existe el elemento
            return -1;
        }

        int mid = lo + ((hi - lo) / 2);

        if (arr[mid] == elem) {//Si el elemento es mid
            return mid;
        }
        if (arr[mid] < elem) { //Buscamos en la parte de la derecha
            return find(arr, elem, mid + 1, hi);
        } else { //Buscamos en la parte de la izquierda
            return find(arr, elem, lo, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,3,8,4,6,1,7,9};
        System.out.println(Arrays.toString(quickSort(arr)));
    }

}
