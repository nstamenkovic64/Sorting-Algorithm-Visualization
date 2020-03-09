package sorting_visualization;

public class QuickSort extends Algorithm {

    public QuickSort(ArrayDraw niz) {
        this.niz = niz;
    }

    public int partition(int[] arr,int low, int high) {

        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            this.comparingIndex = j;
            this.comparedTo = pivot;
            if (arr[j] <= pivot){
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            runLater();
        }
        int tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;
        runLater();
        return i+1;

    }

    public void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            qsort(arr, low, pi-1);
            qsort(arr,pi+1, high);
        }
    }

    @Override
    public void sort() {
        this.niz.shuffle();
        this.currentlySorting(true);
        qsort(this.niz.getArray(),0,this.niz.getArray().length -1);
        this.currentlySorting(false);
        runLater();
    }
}
