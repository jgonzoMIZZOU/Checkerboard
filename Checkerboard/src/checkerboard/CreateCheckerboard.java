/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jeremygonzalez
 */
public class CreateCheckerboard {
    
    private int numRows;
    private int numCols;
    private double gridWidth;
    private double gridHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectWidth;
    private double rectHeight;
    private AnchorPane anchorPane;
    
        
    // main constructor
    public CreateCheckerboard( int numRows, int numCols, double gridWidth, double gridHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    // method to create a new checkerboard
    public AnchorPane build() {
        anchorPane = new AnchorPane();
        
        anchorPane.setMinWidth(gridWidth);
        anchorPane.setMinHeight(gridHeight);
        
        rectWidth = Math.ceil(gridWidth / numCols);
        rectHeight = Math.ceil(gridHeight / numRows);
        
        for(int row = 0; row < numCols; row++) {
            for(int col = 0; col < numRows; col++) {
                Rectangle rec = new Rectangle(rectWidth, rectHeight);
                
                if(row%2 == 0) {
                    if(col%2 == 0) {
                        rec.setFill(lightColor);
                    } else {
                        rec.setFill(darkColor);
                    }
                } else {
                    if(col%2 == 0) {
                        rec.setFill(darkColor);
                    } else {
                        rec.setFill(lightColor);
                    }
                }
                anchorPane.getChildren().addAll(rec);
                AnchorPane.setTopAnchor(rec, row * rectHeight);
                AnchorPane.setLeftAnchor(rec, col * rectWidth);
            }
        }
        return anchorPane;
    }
    
    public double getGridWidth() {
        return this.gridWidth;
    }
    
    public double getGridHeight() {
        return this.gridHeight;
    }
    
}
