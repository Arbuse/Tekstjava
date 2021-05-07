package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {

    @FXML
    private MenuBar menuBar;

    @FXML
    private ToolBar toolBar;

    @FXML
    private Button button1;

    @FXML
    private TextArea textArea;
    @FXML
    private MenuItem closeItem;
    @FXML
    private MenuItem openItem;
    @FXML
    Pane mainPane;

    public void initialize() {
        closeItem.setOnAction(event -> {
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.close();

        });
        openItem.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file1 = fileChooser.showOpenDialog(new Stage());
            showFile(file1);
        });


    }
    private void showFile(File file) {
        try {
            String content = new String ( Files.readAllBytes( Paths.get(file.getPath()) ) );
            textArea.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
