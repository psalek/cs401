package lesson6.lecture.javafx.secondwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SecondWindow extends Stage {
	Stage primaryStage;
	GridPane grid = new GridPane();
	
	public SecondWindow(Stage ps) {
		primaryStage = ps;
		setTitle("Second Window");
		
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);

		Button secondBtn = new Button("Hide first window");
        //Hide other window, show current window
		secondBtn.setOnAction(evt -> {
			primaryStage.hide();
			show();
		});
        
        Button thirdBtn = new Button("Show first window");
        //Hide this window, show other window
        thirdBtn.setOnAction(evt -> {
        	primaryStage.show();
			hide();
		});
        setUpCombo();
            
        //Arrange buttons in a 2x1 grid
  		grid.setAlignment(Pos.CENTER);
  		grid.setVgap(10); //sets vertical gap between buttons
  		grid.add(changeColorCombo, 0, 0);
  		GridPane.setHalignment(changeColorCombo, HPos.LEFT);
  		grid.add(secondBtn,0,2);
  		grid.add(thirdBtn,0,3);
        Scene scene = new Scene(grid,300, 250);
        positionSceneInStage(this, scene);
        setBackground(DEFAULT_COLOR);
        scene.setFill(Color.BEIGE);
		setScene(scene);
	}
	void setBackground(Color color) {
		grid.backgroundProperty().set(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	void positionSceneInStage(Stage stage, Scene scene) { 
		stage.setX(600); 
		stage.setY(200); 
	}
	
	@SuppressWarnings("serial")
	///begin setup code for the Color combo box ///////
	HashMap<String, Color> colorMap = new HashMap<String, Color>() {
		{
			put("White", Color.WHITE);
			put("Blue", Color.CORNFLOWERBLUE);
		}
	};
	List<String> colors = new ArrayList<>();
	{
		//populates list of colors
		colors.addAll(colorMap.keySet());
	}
	private static final Color DEFAULT_COLOR = Color.WHITE;
	ComboBox<String> changeColorCombo = 
			new ComboBox<>(FXCollections.observableList(colors));
		
	private void setUpCombo() {
		class ComboChangeListener implements ChangeListener<String> {
			 @Override 
		        public void changed(ObservableValue<? extends String> wrappedNewVal, 
		        		String oldval, String newval) {
				  System.out.println(wrappedNewVal.getValue() + " " + oldval + " " + newval);
				  setBackground(colorMap.get(newval));
		        }
		}
		changeColorCombo.valueProperty().addListener(new ComboChangeListener());
	       
		//set default val
		changeColorCombo.setValue(colors.get(0));
	}
    ///////// end combo box setup code
}
