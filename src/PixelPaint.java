// Pixel Paint
// John Irle
// 21 March 2019

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class PixelPaint extends Application {
  private Pixel[][] grid = new Pixel[36][36];
  static ColorPicker colorPicker = new ColorPicker(Color.BLACK);

  public void start(Stage primaryStage) {
    primaryStage.setResizable(false);
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(0, 15, 15, 15 ));

    // Initialize grid
    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < 32; j++) {
        pane.add(grid[i][j] = new Pixel(), j, i);
      }
    }

    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt"));

    Button btSave = new Button("Save");
    Button btLoad = new Button("Load");

    btSave.setOnMouseClicked(e -> {
      try {
        File file = fileChooser.showSaveDialog(primaryStage);
        PrintWriter f = new PrintWriter(file);
        for (int i = 0; i < 32; i++) {
          for (int j = 0; j < 32; j++) {
            Color current = grid[i][j].getColor();
            f.print((int) (current.getRed() * 255)
                    + " " + (int) (current.getGreen() * 255)
                    + " " + (int) (current.getBlue() * 255) + '\n');
          }
        }
        f.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    });
    btLoad.setOnMouseClicked(e -> {
      File file = fileChooser.showOpenDialog(primaryStage);
      try {
        Scanner input = new Scanner(file);
        for (int i = 0; i < 32; i++) {
          for (int j = 0; j < 32; j++) {
            int R = input.nextInt();
            int G = input.nextInt();
            int B = input.nextInt();

            Color color = Color.rgb(R, G, B);

            BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);

            grid[i][j].setBackground(new Background(backgroundFill));
            grid[i][j].setColor(color);
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });

    HBox controls = new HBox();
    controls.setPadding(new Insets(5, 0, 5, 15));
    controls.setSpacing(10);
    controls.getChildren().addAll(colorPicker, btSave, btLoad);

    BorderPane borderPane = new BorderPane();
    borderPane.setTop(controls);
    borderPane.setCenter(pane);


    Scene scene = new Scene(borderPane, 800, 800);
    primaryStage.setTitle("Pixel Paint");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
