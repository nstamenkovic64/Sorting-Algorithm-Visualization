package sorting_visualization;

public class SelectionSort extends Algorithm {

    public SelectionSort(ArrayDraw niz) {
        this.niz = niz;
    }

    @Override
    public void sort() {
        this.niz.shuffle();
        this.currentlySorting(true);
        int len = this.niz.getArray().length;
        int tmp;

        for (int i=0; i < len-1; i++) {
            int min = i;
            this.comparingIndex = i;
            for (int j=i+1; j<len; j++) {
                this.comparedTo = j;
                if (this.niz.getArray()[j] < this.niz.getArray()[min])
                    min = j;
                    this.comparingIndex = min;
                runLater();
            }

            tmp = this.niz.getArray()[min];
            this.niz.getArray()[min] = this.niz.getArray()[i];
            this.niz.getArray()[i] = tmp;
            runLater();


        }

        this.currentlySorting(false);
        runLater();

    }
}
