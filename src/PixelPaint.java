// Pixel Paint
// John Irle
// 21 March 2019

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PixelPaint extends Application {
  private Pixel[][] grid = new Pixel[36][36];
  static ColorPicker colorPicker = new ColorPicker(Color.BLACK);

  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();

    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < 32; j++) {
        pane.add(grid[i][j] = new Pixel(), j, i);
      }
    }

    Button btSave = new Button("Save");
    Button btLoad = new Button("Load");

    btSave.setOnMouseClicked(e -> handleSave());
    btSave.setOnMouseClicked(e -> handleLoad());

    HBox controls = new HBox();
    controls.setPadding(new Insets(5, 0, 5, 5));
    controls.setSpacing(10);
    controls.getChildren().addAll(colorPicker, btSave, btLoad);

    BorderPane borderPane = new BorderPane();
    borderPane.setTop(controls);
    borderPane.setCenter(pane);


    Scene scene = new Scene(borderPane, 600,600);
    primaryStage.setTitle("Pixel Paint");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void handleSave() {

  }

  private void handleLoad() {

  }

  public static void main(String[] args) {
    launch(args);
  }
}
