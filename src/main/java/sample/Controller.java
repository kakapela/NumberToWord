package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private JFXTextField input;

    @FXML
    private JFXButton button;

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void klikej(MouseEvent event) {
            try {
                if(isNumeric(input.getText() )) {
                    System.out.println("tak jest to liczba");
                    long liczba = Long.parseLong(input.getText());
                    label.setText(NumberToWord.translacja(liczba));
                }
                else label.setText("zly format kolego, program obsluzy tylko l.calkowite...");
            } catch (InputMismatchException ime) {
                label.setText("Kurwa, zle dane gosciu...");
            }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

