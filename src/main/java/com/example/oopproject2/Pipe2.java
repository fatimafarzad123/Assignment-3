package com.example.oopproject2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pipe2 {
    private ImageView topPipe;
    private ImageView bottomPipe;
    private double x;
    private double speed;
    private boolean passed;

    public Pipe2(Image topImage, Image bottomImage, double x, double gapY, double gapHeight, double pipeWidth) {
        this.x = x;
        this.speed = 2; // Adjust speed if needed
        this.passed = false;

        // Top Pipe
        topPipe = new ImageView(topImage);
        topPipe.setFitWidth(pipeWidth);
        topPipe.setPreserveRatio(false);
        topPipe.setTranslateX(x);
        topPipe.setTranslateY(gapY - topPipe.getImage().getHeight());

        // Bottom Pipe
        bottomPipe = new ImageView(bottomImage);
        bottomPipe.setFitWidth(pipeWidth);
        bottomPipe.setPreserveRatio(false);
        bottomPipe.setTranslateX(x);
        bottomPipe.setTranslateY(gapY + gapHeight);
    }

    public void update() {
        x -= speed;
        topPipe.setTranslateX(x);
        bottomPipe.setTranslateX(x);
    }

    public boolean isOffScreen(double screenWidth) {
        return x + topPipe.getFitWidth() < 0;
    }

    public boolean isCollision(double birdX, double birdY, double birdWidth, double birdHeight) {
        return (birdX + birdWidth > x && birdX < x + topPipe.getFitWidth()) &&
                (birdY < topPipe.getTranslateY() + topPipe.getFitHeight() ||
                        birdY + birdHeight > bottomPipe.getTranslateY());
    }

    public ImageView getTopPipe() {
        return topPipe;
    }

    public ImageView getBottomPipe() {
        return bottomPipe;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

