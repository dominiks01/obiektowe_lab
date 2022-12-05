package agh.ics.oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


import javafx.geometry.Pos;
import javafx.scene.control.Label;


public class GuiElementBox {
    private Image image;
    private ImageView imageView;
    private VBox vbox;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {

        String addres;
        Label label;

        if(element instanceof Grass){
            addres ="src/main/java/resources/grass.png";
            label = new Label("Trawa");
        } else {
            addres ="src/main/java/resources/" + switch (((Animal)element).getOrientation()){
                case NORTH -> "up.png";
                case EAST ->  "right.png";
                case SOUTH -> "down.png";
                case WEST ->  "left.png";
            };
            label = new Label("Z " + element.getPosition().toString());

        }
        image = new Image(new FileInputStream(addres));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        this.vbox = new VBox(imageView, label);
        this.vbox.setAlignment(Pos.CENTER);
    }

    public VBox getVbox() {
        return this.vbox;
    }
}
