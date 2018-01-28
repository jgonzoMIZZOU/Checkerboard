/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jeremygonzalez
 */
public class CheckerboardFXMLController implements Initializable, Startable {

    /**
     * Initializes the controller class.
     */
    
    // FXML VARIABLES
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox vBox;
    
    private Stage stage;
    private double gridWidth;
    private double gridHeight;
    private int numRows = 8;
    private int numCols = 8;
    private final Color colors[] = {Color.RED, Color.BLACK, Color.SKYBLUE, Color.DARKBLUE};
    private Color lightColor = colors[0];
    private Color darkColor = colors[1];
    
    // class that will create a checkerboard
    CreateCheckerboard checkerBoard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void start(Stage stage){
        this.stage = stage;
        
        // getting the initial starting size of the anchorpane
        gridWidth = anchorPane.getWidth();
        gridHeight = anchorPane.getHeight();
        
        // this is a listener that will listen to when the stage changes size 
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            if(lightColor == Color.RED && darkColor == Color.BLACK) {
                vBox.getChildren().remove(anchorPane);
                checkerBoard = new CreateCheckerboard(numRows, numCols, vBox.getWidth(), vBox.getHeight() - 22);
                anchorPane = checkerBoard.build();
                vBox.getChildren().add(anchorPane);
            } else {
                vBox.getChildren().remove(anchorPane);
            checkerBoard = new CreateCheckerboard(numRows, numCols, vBox.getWidth(), vBox.getHeight() - 22, lightColor, darkColor);
            anchorPane = checkerBoard.build();
            vBox.getChildren().add(anchorPane);
            } 
        };
        
        this.vBox.widthProperty().addListener(listener);
        this.vBox.heightProperty().addListener(listener);
        
        checkerBoard = new CreateCheckerboard(numRows, numCols, gridWidth, gridHeight, lightColor, darkColor);
        anchorPane = checkerBoard.build();
        vBox.getChildren().add(anchorPane);
    }
    
    /*
    * Methods that will handle the menu bar items
    */
    
    @FXML
    private void handle8(ActionEvent event) {
        newBoardRowAndCol(8, 8);
    }
    
    @FXML
    private void handle3(ActionEvent event) {
        newBoardRowAndCol(3, 3);
    }
    
    @FXML
    private void handle16(ActionEvent event) {
        newBoardRowAndCol(16, 16);
    }
    
    @FXML
    private void handle10(ActionEvent event) {
        newBoardRowAndCol(10, 10);
    }
    
    @FXML
    private void handleColor(ActionEvent event) {
        vBox.getChildren().remove(anchorPane);
        if(lightColor == colors[0] && darkColor == colors[1]) {
            lightColor = colors[2];
             darkColor = colors[3];
        } else {
            lightColor = colors[0];
             darkColor = colors[1];
        }
        newBoardColor(lightColor, darkColor);
        
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        System.out.println("About");
    }
    
    private void newBoardRowAndCol(int row, int col) {
        numRows = row;
        numCols = col;
        vBox.getChildren().remove(anchorPane);
        CreateCheckerboard newBoard = new CreateCheckerboard(row, col, anchorPane.getWidth(), anchorPane.getHeight(), lightColor, darkColor);
        anchorPane = newBoard.build();
        vBox.getChildren().add(anchorPane);
    }
    
    private void newBoardColor(Color lightColor, Color darkColor) {
        CreateCheckerboard newBoard = new CreateCheckerboard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight(), lightColor, darkColor);
        anchorPane = newBoard.build();
        vBox.getChildren().add(anchorPane); 
    }
    
}
