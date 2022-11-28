package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {

    AbstractWorldMap map;

    @Override
    public void init(){
        try{
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(5);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        int xAxis = map.getBottomLeft().x;
        int yAxis = map.getBottomLeft().y;
        int xAxisDiff = map.getTopRight().x - xAxis + 2;
        int yAsixDiff = map.getTopRight().y - yAxis + 2;


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

//        grid.getColumnConstraints().add(new ColumnConstraints(50));
//        grid.getRowConstraints().add(new RowConstraints(50));

        for(int y = 0; y < yAsixDiff; y++) {
            for(int x = 0; x < xAxisDiff; x++) {
                Label newLabel = new Label("");
                GridPane.setHalignment(newLabel, HPos.CENTER);

                Object object = map.objectAt(new Vector2d(x+xAxis, y+yAxis));
                if (object != null) {
                    newLabel.setText(object.toString());
                }

                grid.add(newLabel, 1+x, (yAsixDiff-y-1), 1, 1);
                GridPane.setHalignment(newLabel, HPos.CENTER);

            };
        }

        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 50*xAxisDiff, 50*yAsixDiff);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}