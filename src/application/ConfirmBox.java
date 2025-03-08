package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

	static boolean answer;

	public static boolean display(String title, String message) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		Label label = new Label();
		label.setText(message);

		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});

		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});

		VBox layout = new VBox(10);
		HBox bottom = new HBox(10);
		bottom.getChildren().addAll(yesButton, noButton);
		VBox.setMargin(label, new Insets(10, 0, 0, 0));
		HBox.setMargin(yesButton, new Insets(0, 0, 10, 0));
		HBox.setMargin(noButton, new Insets(0, 0, 10, 0));
		bottom.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, bottom);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

		return answer;
	}

}
