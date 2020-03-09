package sorting_visualization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class ArrayDraw {

    private int[] array;
    private SortingVisualizer gui;


    public ArrayDraw(SortingVisualizer gui) {
        this.array = null;
        this.gui = gui;
    }

    public int[] getArray() {
        return array;
    }

    public SortingVisualizer getGui() {
        return gui;
    }

    public int [] initialize(int x) {
        int[] niz = new int[x];
        for (int i = 0; i<x; i++)
            niz[i]=i+1;
        this.array = niz;
        this.shuffle();
        this.draw(0,0);
        return niz;
    }

    public void draw(int x, int y) {

        double width = this.gui.getCanvas().getWidth() / this.array.length;
        double height = this.gui.getCanvas().getHeight() / this.array.length;

        GraphicsContext gc = this.gui.getCanvas().getGraphicsContext2D();
        gc.clearRect(0,0,this.gui.getCanvas().getWidth(),this.gui.getCanvas().getHeight());

        for (int i=0; i<this.array.length; i++) {
            gc.setFill(Color.WHITE);
            if ((i==x || i==y) && this.getGui().getIsSorting())
                gc.setFill(Color.RED);
            gc.fillRect(i*width,500-array[i]*height, width, this.array[i]*height);
        }
    }

    public int[] shuffle() {

        Random rand = new Random();
        for (int i = 0; i < this.array.length; i++) {
            int randomIndex = rand.nextInt(this.array.length);
            int temp = this.array[randomIndex];
            this.array[randomIndex] = this.array[i];
            this.array[i] = temp;

        }
        return this.array;
    }

}



