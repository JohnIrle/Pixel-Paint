// Pixel Class
// John Irle
// 21 March 2019

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

class Pixel extends Pane {

  private Color cellColor;

  public Pixel() {
    this.setPrefSize(2000, 2000);
    this.setStyle("-fx-border-color: black");
    this.setOnMouseClicked(e -> handleMouseClick());
  }

  public Color getColor() {
    return this.cellColor;
  }

  private void handleMouseClick() {
    Color color = PixelPaint.colorPicker.getValue();
    BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
    this.setBackground(new Background(backgroundFill));
    this.cellColor = color;
  }
}
