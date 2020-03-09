package sorting_visualization;

public class MergeSort extends Algorithm {

    public MergeSort(ArrayDraw niz) {
        this.niz = niz;
    }

    public void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            this.comparingIndex = i + l;
            this.comparedTo = j + m;
            if (L[i] <= R[j]) {

                arr[k] = L[i];
                i++;
                runLater();
            }
            else {
                arr[k] = R[j];
                j++;
                runLater();
            }
            k++;
            runLater();
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            runLater();
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            runLater();
        }
    }

    void msort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = (l+r)/2;

            msort(arr, l, m);
            msort(arr , m+1, r);

            merge(arr, l, m, r);
        }
    }

    @Override
    public void sort() {
        this.niz.shuffle();
        this.currentlySorting(true);
        msort(this.niz.getArray(),0,this.niz.getArray().length-1);
        this.currentlySorting(false);
        runLater();
    }
}
