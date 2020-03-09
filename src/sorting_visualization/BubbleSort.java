package sorting_visualization;

public class BubbleSort extends Algorithm {

    public BubbleSort(ArrayDraw niz) {
        this.niz = niz;
    }

    @Override
    public void sort() {
        this.niz.shuffle();
        int tmp;
        this.currentlySorting(true);
        int len = this.niz.getArray().length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j< len - i -1; j++) {
                this.comparingIndex = j;
                this.comparedTo=j+1;

                if (this.niz.getArray()[j] > this.niz.getArray()[j + 1]) {

                    tmp = this.niz.getArray()[j];
                    this.niz.getArray()[j] = this.niz.getArray()[j + 1];
                    this.niz.getArray()[j + 1] = tmp;

                }

                this.runLater();
            }
        }
        this.currentlySorting(false);
        runLater();

    }



}


