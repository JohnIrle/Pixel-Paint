// Pixel Paint
// John Irle
// 21 March 2019

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PixelPaint extends Application {
  private Pixel[][] grid = new Pixel[36][36];

  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();

    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < 32; j++) {
        pane.add(grid[i][j] = new Pixel(), j, i);
      }
    }

    ColorPicker colorPicker = new ColorPicker();

    BorderPane borderPane = new BorderPane();
    borderPane.setTop(colorPicker);
    borderPane.setCenter(pane);


    Scene scene = new Scene(borderPane, 600,600);
    primaryStage.setTitle("Pixel Paint");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
