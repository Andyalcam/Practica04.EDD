public class Ordenamiento {

    public static int[] quickSort(int[] arr){
        return quickSort(arr, 0, arr.length-1);
    }

    public static int[] quickSort(int[] arr, int lo, int hi){
        if (lo >= hi)
            return arr;
        int i = lo, d = hi;
        if (lo != hi) {
            int pivote;
            int aux;
            pivote = lo;
            while (lo != hi) {
                while (arr[hi] >= arr[pivote] && lo < hi)
                    hi--;
                while (arr[lo] < arr[pivote] && lo < hi)
                    lo++;

                if (hi != lo) {
                    aux = arr[hi];
                    arr[hi] = arr[lo];
                    arr[lo] = aux;
                }
                if (lo == hi) {
                    quickSort(arr, i, lo - 1);
                    quickSort(arr, lo + 1, d);
                }
            }
        }
        return arr;
    }


    public static void mergeSort () {

    }

    /**
     * Método que busca la posición del elemento que quieras buscar.
     * @param arr - arreglo en el que buscaremos.
     * @param elem - elemento a buscar.
     * @return la posición del elemento a buscar.
     * -1 si no existe el elemento en el arreglo.
     */

    public static int find ( int[] arr, int elem){
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
        if (lo > hi) {
            return -1;
        }
        int mid = lo + ((hi - lo) / 2);
        if (arr[mid] == elem) {
            return mid;
        }
        if (arr[mid] < elem) {
            return find(arr, elem, mid + 1, hi);
        } else {
            return find(arr, elem, lo, mid - 1);
        }
    }

}
