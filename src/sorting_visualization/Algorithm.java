package sorting_visualization;

import javafx.application.Platform;

public abstract class Algorithm implements Runnable {

    protected ArrayDraw niz;
    protected int comparingIndex, comparedTo;

    @Override
    public void run() {
        this.niz.draw(comparingIndex, comparedTo);
    }

    public abstract void sort();

    public void currentlySorting(boolean value) {
        this.niz.getGui().setIsSorting(value);
        this.niz.getGui().getSort().setDisable(value);
        this.niz.getGui().getSlider().setDisable(value);
        this.niz.getGui().getSetSize().setDisable(value);
        this.niz.getGui().getComboBox().setDisable(value);
    }

    public void startTask() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sort();
            }
        };
        Thread backgroundThread = new Thread(task);
        backgroundThread.start();
    }

    public void runLater() {
        Platform.runLater(this);

        try {
            Thread.sleep((long) this.niz.getGui().getSpeedValue()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
