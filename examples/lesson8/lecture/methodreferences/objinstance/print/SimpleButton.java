package lesson8.lecture.methodreferences.objinstance.print;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleButton extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello!");
		Button btn = new Button() {
			@Override
			public String toString() {
				return "My user-defined button.";
			}
		};
		btn.setText("Click Me");
		Printer p = new Printer();
		btn.setOnAction(event -> p.print(event));
		btn.setOnAction(p::print); //method reference
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		//primaryStage.setScene(new Scene(root));
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
	@Override
	public void stop() {
		//clean up resources
	}
}
