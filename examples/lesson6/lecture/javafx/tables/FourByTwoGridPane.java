package lesson6.lecture.javafx.tables;

import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class FourByTwoGridPane extends GridPane {
	List<String> rowHeaders;
	List<String> values;
	String borderColor;
	public FourByTwoGridPane(List<String> rowHeaders, List<String> values, 
			String borderColor, int minWidth) {
		this.rowHeaders = rowHeaders;
		this.values = values;
		this.borderColor = borderColor;
		makeRows();
		fillUpCells();
		setConstraints();
		setMinWidth(minWidth);
	}
	private void makeRows(){
		addRow(0, new Label(rowHeaders.get(0)), new Label(values.get(0)));
	    addRow(1, new Label(rowHeaders.get(1)), new Label(values.get(1)));
	    addRow(2, new Label(rowHeaders.get(2)), new Label(values.get(2)));
	    addRow(3, new Label(rowHeaders.get(3)), new Label(values.get(3)));
	    
	}
	private void fillUpCells() {
		for (Node n: getChildren()) {
		      if (n instanceof Control) {
		        Control control = (Control) n;
		        control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		        control.setStyle("-fx-background-color: white; -fx-alignment: center;");
		      }
		      if (n instanceof Pane) {
		        Pane pane = (Pane) n;
		        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		        pane.setStyle("-fx-background-color: white; -fx-alignment: center;");
		      }
		}
		
	}
	private void setConstraints() {
		// style the grid so that it has a background and gaps around the grid and between the 
	    // grid cells so that the background will show through as grid lines.
	    setStyle("-fx-background-color: " + borderColor + "; -fx-padding: 2; -fx-hgap: 2; -fx-vgap: 2;");
	    // turn layout pixel snapping off on the grid so that grid lines will be an even width.
	    setSnapToPixel(false);

	    // set some constraints so that the grid will fill the available area.
	    ColumnConstraints oneHalf = new ColumnConstraints();
	    oneHalf.setPercentWidth(100/2.0);
	    oneHalf.setHalignment(HPos.CENTER);
	    getColumnConstraints().addAll(oneHalf, oneHalf);
	    RowConstraints oneFourth = new RowConstraints();
	    oneFourth.setPercentHeight(100/4.0);
	    oneFourth.setValignment(VPos.CENTER);
	    getRowConstraints().addAll(oneFourth, oneFourth,oneFourth,oneFourth);
		
	}
}
