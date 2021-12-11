package com.example.aventurasdemarcoyluis.gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The type Image node builder.
 */
public class ImageNodeBuilder {
    private final Scene scene;

    /**
     * Instantiates a new Image node builder.
     *
     * @param scene the scene
     */
    public ImageNodeBuilder(Scene scene){
        this.scene = scene;
    }

    /**
     * Builds image view.
     *
     * @param x         the x
     * @param y         the y
     * @param w         the w
     * @param h         the h
     * @param imagePath the image path
     * @param name      the name
     * @return the image view
     * @throws FileNotFoundException the file not found exception
     */
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
