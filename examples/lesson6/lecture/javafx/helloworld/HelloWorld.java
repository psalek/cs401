package lesson6.lecture.javafx.helloworld;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		List<String> cmdlineParams = getParameters().getRaw();
		if(cmdlineParams.size() > 0) {
			username = cmdlineParams.get(0);	
			//System.out.println(username);
		}
	}
	
	String username;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello!");
		Button btn = new Button();
		btn.setText("Say 'Hello'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello " + 
			        (username != null ? username : "World") + "!");
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 300, 250);
		/* using a stylesheet*/ 
		scene.getStylesheets()
		       .add(getClass()
		       .getResource("hello.css")
		       .toExternalForm());
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@Override
	public void stop() {
		//clean up resources
	}
}
