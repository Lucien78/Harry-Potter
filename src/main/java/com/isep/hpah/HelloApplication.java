package com.isep.hpah;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jeu de Sorcier");

        // Création des éléments de l'interface graphique
        Label label = new Label("Entrez le nom de votre sorcier : ");
        TextField textField = new TextField();
        Button button = new Button("Commencer le jeu");
        TextArea textArea = new TextArea();

        // Configuration du bouton pour commencer le jeu
        button.setOnAction(e -> {
            String name = textField.getText();
            // Vous pouvez exécuter ici la logique du jeu en utilisant wizardName
            // et afficher les résultats dans textArea
        });

        // Ajout des éléments dans la scène
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, textField, button, textArea);
        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}