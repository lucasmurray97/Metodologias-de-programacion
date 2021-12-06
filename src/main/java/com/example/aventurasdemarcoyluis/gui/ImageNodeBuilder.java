package com.example.aventurasdemarcoyluis.gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageNodeBuilder {
    private final Scene scene;

    public ImageNodeBuilder(Scene scene){
        this.scene = scene;
    }

    public ImageView build(int x, int y, int w, int h, String imagePath, String name) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(imagePath + name);
        ImageView imageView = new ImageView(new Image(fileInputStream));
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(w);
        imageView.setFitHeight(h);
        return imageView;
    }
}
