package sorting_visualization;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class SortingVisualizer extends Application {

    private HBox root, sliders;
    private VBox buttons, rest, sorting;
    private Button sort, setSize;
    private Canvas canvas;
    private ArrayDraw niz;
    private Scene scene;
    private Algorithm alg;
    private Slider speed, size;
    private boolean isSorting;
    private Text sizeText, speedText;
    private static final String bubbleSort = "Bubble sort";
    private static final String insertionSort = "Insertion sort";
    private static final String selectionSort = "Selection sort";
    private static final String quickSort = "Quick sort";
    private static final String mergeSort = "Merge sort";
    private static final String heapSort = "Heap sort";

    private ObservableList<String> options =
            FXCollections.observableArrayList(
                    bubbleSort,
                    insertionSort,
                    selectionSort,
                    quickSort,
                    mergeSort,
                    heapSort
            );
    private ComboBox comboBox = new ComboBox(options);

    public Canvas getCanvas() {
        return canvas;
    }

    public double getSpeedValue() {
        return this.speed.getValue();
    }

    public boolean getIsSorting() {
        return this.isSorting;
    }

    public void setIsSorting(boolean value) {
        this.isSorting = value;
    }

    @Override
    public void start(Stage primaryStage) {

        root = new HBox(10);
        root.setPadding(new Insets(10,10,10,10));

        buttons = new VBox(10);
        buttons.setPadding(new Insets(10,10,10,10));

        rest = new VBox(10);
        rest.setPadding(new Insets(10,10,10,10));

        sorting = new VBox(10);
        sorting.setPadding(new Insets(10,10,10,10));
        sorting.setStyle("-fx-background-color: black");

        sliders = new HBox(10);
        sliders.setPadding(new Insets(10,10,10,10));

        sliders.setAlignment(Pos.BASELINE_CENTER);

        buttons.setMinWidth(200);

        comboBox.getSelectionModel().selectFirst();

        sort = new Button("Sort");

        setSize = new Button("Set size");
        canvas = new Canvas(750,500);

        speedText = new Text("Select sorting speed: ");


        speed = new Slider(0,100,50);
        speed.setShowTickMarks(true);
        speed.setShowTickLabels(true);
        speed.setMajorTickUnit(10);
        speed.setBlockIncrement(10);
        speed.setMinWidth(250);

        sizeText = new Text("Select array size: ");

        size = new Slider(10,500,500);
        size.setShowTickMarks(true);
        size.setShowTickLabels(true);
        size.setMajorTickUnit(50);
        size.setBlockIncrement(10);

        buttons.getChildren().addAll(comboBox, sizeText, size, setSize, sort);
        sorting.getChildren().addAll(canvas);
        sorting.setAlignment(Pos.BASELINE_CENTER);
        sliders.getChildren().addAll(speedText, speed);
        sliders.setAlignment(Pos.BASELINE_CENTER);
        rest.getChildren().addAll(sorting, sliders);
        root.getChildren().addAll(buttons, rest);

        niz = new ArrayDraw(this);
        niz.initialize((int)size.getValue());

        setSize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                niz.initialize((int)size.getValue());
            }
        });

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                System.exit(0);
            }
        });

        sort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switch(comboBox.getValue().toString()) {
                    case (bubbleSort):
                        alg = new BubbleSort(niz);
                        break;
                    case (insertionSort):
                        alg = new InsertionSort(niz);
                        break;
                    case (selectionSort):
                        alg = new SelectionSort(niz);
                        break;
                    case (quickSort):
                        alg = new QuickSort(niz);
                        break;
                    case (mergeSort):
                        alg = new MergeSort(niz);
                        break;
                    case (heapSort):
                        alg = new HeapSort(niz);
                        break;
                    default:
                        break;
                }
                alg.startTask();
            }
        });

        scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Sorting visualization");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public Button getSort() {
        return sort;
    }

    public Button getSetSize() {
        return setSize;
    }

    public Slider getSlider() {
        return size;
    }

    public ComboBox getComboBox() { return comboBox; }

}
