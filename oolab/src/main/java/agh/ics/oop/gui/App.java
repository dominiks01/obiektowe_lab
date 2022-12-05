package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.io.FileNotFoundException;

public class App extends Application implements IMapChangeObserver{

    AbstractWorldMap map;
    GridPane grid = new GridPane();

    VBox vbox;

    private agh.ics.oop.gui.SimulationEngine engine;

    int xAxis;
    int yAxis;
    int xAxisDiff ;
    int yAsixDiff ;


    public void drawElements() throws FileNotFoundException {

        xAxis = map.getBottomLeft().x;
        yAxis = map.getBottomLeft().y;
        xAxisDiff = map.getTopRight().x - xAxis + 2;
        yAsixDiff = map.getTopRight().y - yAxis + 2;

        for(int i = 0; i < xAxisDiff; i++) {
            Label newLabel = new Label(Integer.toString(i+xAxis));
            GridPane.setHalignment(newLabel, HPos.CENTER);
            grid.add(newLabel, i+1, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            grid.getRowConstraints().add(new RowConstraints(50));

        }

        for(int i = 0; i < yAsixDiff; i++) {
            Label newLabel = new Label(Integer.toString(i+yAxis-1));
            GridPane.setHalignment(newLabel, HPos.CENTER);
            grid.add(newLabel, 0, yAsixDiff-i, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            grid.getRowConstraints().add(new RowConstraints(50));

        }

        for(int y = 0; y < yAsixDiff; y++) {
            for(int x = 0; x < xAxisDiff; x++) {
                Label newLabel = new Label("");
                GridPane.setHalignment(newLabel, HPos.CENTER);

                Object object = map.objectAt(new Vector2d(x+xAxis, y+yAxis));
                if (object != null) {
                    GuiElementBox newGui = new GuiElementBox((IMapElement) object);
                    newLabel.setGraphic(newGui.getVbox());
                }

                grid.add(newLabel, 1+x, (yAsixDiff-y-1), 1, 1);
                GridPane.setHalignment(newLabel, HPos.CENTER);

            };
        }

        grid.setGridLinesVisible(true);
    }

    @Override
    public void notifyObservers() {
        Platform.runLater( ()-> {
            this.grid.getChildren().clear();
            this.grid.getRowConstraints().clear();
            this.grid.getColumnConstraints().clear();
            try {
                drawElements();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        map = new GrassField(5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3)};
        engine = new agh.ics.oop.gui.SimulationEngine(this.map, positions);
        engine.addObserver(this);

        TextField inputField = new TextField();
        Button button = new Button("Podaj kierunek");
        HBox hbox = new HBox(button, inputField);
        vbox = new VBox(hbox, this.grid);
        hbox.setAlignment(Pos.CENTER);

        xAxis = map.getBottomLeft().x;
        yAxis = map.getBottomLeft().y;
        xAxisDiff = map.getTopRight().x - xAxis + 2;
        yAsixDiff = map.getTopRight().y - yAxis + 2;

        button.setOnAction(click -> {
            MoveDirection[] directions = new OptionsParser().parse(inputField.getText().split(" "));
            this.engine.setMoves(directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        Scene scene = new Scene(vbox, 50*xAxisDiff, 50*yAsixDiff+30);
        drawElements();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}