package sorting_visualization;

public class InsertionSort extends Algorithm{

    public InsertionSort(ArrayDraw niz) {
        this.niz = niz;
    }

    @Override
    public void sort() {
        this.niz.shuffle();
        this.currentlySorting(true);
        int len = this.niz.getArray().length;

        for (int i=1; i<len; i++) {
            int key = this.niz.getArray()[i];
            int j = i - 1;

            while(j >= 0 && this.niz.getArray()[j] > key) {

                this.niz.getArray()[j+1] = this.niz.getArray()[j];
                this.comparingIndex = j;
                this.comparedTo = j+1;
                j=j-1;
                runLater();
            }
            this.niz.getArray()[j+1] = key;
            runLater();
        }
        this.currentlySorting(false);
        runLater();

    }
}
