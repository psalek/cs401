package lesson6.lecture.javafx.tables;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CatalogListWindow extends Stage {
	public static final CatalogListWindow INSTANCE = new CatalogListWindow();
	private TableView<Catalog> table = new TableView<Catalog>();
	Stage primaryStage;
	Catalog selected;
	Text pleaseSelect = new Text();
	
	public void setData(ObservableList<Catalog> cats) {
		table.setItems(cats);
	}
	
	private CatalogListWindow(){}
	
	public void setStage(Stage ps) {
		primaryStage = ps;
		pleaseSelect.setFill(Color.FIREBRICK);
		
		setTitle("Catalog List");
		
		final Label label = new Label("Browse Catalogs");
        label.setFont(new Font("Arial", 16));
        HBox labelHbox = new HBox(10);
        labelHbox.setAlignment(Pos.CENTER);
        labelHbox.getChildren().add(label);
		
		TableColumn<Catalog, String> catalogNameCol = new TableColumn<>("Catalog");
		catalogNameCol.setMinWidth(250);
		catalogNameCol.setCellValueFactory(
            new PropertyValueFactory<Catalog, String>("name"));
		catalogNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.getColumns().addAll(catalogNameCol);
		
		Button viewButton = new Button("View Catalog");
		Button backButton = new Button("Back to Start");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); 
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(table, 0, 1);
		grid.add(pleaseSelect, 0, 2);
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(viewButton);
		btnBox.getChildren().add(backButton);
		grid.add(btnBox,0,4);
		grid.add(new HBox(10), 0, 5);
		
        
		backButton.setOnAction(evt -> {
			primaryStage.show();
			hide();
		});
	       
		viewButton.setOnAction(evt -> {
			selected = table.getSelectionModel().getSelectedItem();
			if(selected == null) {
				pleaseSelect.setText("Please select a row.");
				
			} else {
				pleaseSelect.setText("");
				ProductListWindow prodList = new ProductListWindow(this, selected);
				List<Product> prods = DefaultData.PRODUCT_LIST_DATA.get(selected);
				prodList.setData(FXCollections.observableList(prods));
				hide();
				prodList.show();	
			}
		});
        Scene scene = new Scene(grid, GuiConstants.SCENE_WIDTH, GuiConstants.SCENE_HEIGHT);  
		setScene(scene);
	}
         		
}
