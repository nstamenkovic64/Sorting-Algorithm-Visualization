package sorting_visualization;

public class HeapSort extends Algorithm {

    public HeapSort(ArrayDraw niz) {
        this.niz = niz;
    }

    void heap(int arr[], int n, int i) {
        int largest = i;
        this.comparingIndex = largest;
        int l = 2*i + 1;
        int r = 2*i + 2;
        this.comparedTo = l;
        runLater();
        this.comparedTo = r;
        runLater();

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            runLater();

            heap(arr, n, largest);
        }
    }

    @Override
    public void sort() {
        this.niz.shuffle();
        this.currentlySorting(true);
        int n = this.niz.getArray().length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heap(this.niz.getArray(), n, i);

        for (int i=n-1; i>=0; i--) {

            int temp = this.niz.getArray()[0];
            this.niz.getArray()[0] = this.niz.getArray()[i];
            this.niz.getArray()[i] = temp;

            heap(this.niz.getArray(), i, 0);
        }
        this.currentlySorting(false);
        runLater();
    }
}
