package lesson6.lecture.javafx.tables;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Welcome Page");
				
		VBox topContainer = new VBox();
		MenuBar mainMenu = new MenuBar();
		Text label = new Text("E-Bazaar");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 60));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		
		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(labelBox);

		Menu custMenu = new Menu("Customer");
		MenuItem onlinePurchase = new MenuItem("Online Purchase");
		onlinePurchase.setOnAction(evt -> {	
			CatalogListWindow catalogs = CatalogListWindow.INSTANCE;
			catalogs.setStage(primaryStage);
	        catalogs.setData(DefaultData.CATALOG_LIST_DATA);
	        catalogs.show();  
	        primaryStage.hide();
					
		});
		MenuItem exitApp = new MenuItem("Exit");
		exitApp.setOnAction(evt -> Platform.exit());
			
		custMenu.getItems().addAll(onlinePurchase, exitApp);

		//did not add menu item for menu edit
		Menu adminMenu = new Menu("Administrator");
		mainMenu.getMenus().addAll(custMenu, adminMenu);

		primaryStage.setScene(new Scene(topContainer, 500, 200));
		primaryStage.show();
	}
	
}
