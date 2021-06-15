package sample.Controllers;

import sample.Controllers.KeyboardController;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fazecast.jSerialComm.SerialPort;

public class BindController {


    private List<String> shortKeys = new ArrayList<>();

    @FXML
    private TextField key_one;

    @FXML
    private TextField key_two;

    @FXML
    private TextField key_three;

    @FXML
    private Button ctrl;

    @FXML
    private Button alt;

    @FXML
    private Button del;

    @FXML
    private Button shift;

    @FXML
    private Button window;

    @FXML
    private Button save_button;


    public void save_keybind(ActionEvent event) throws IOException {

        ButtonString buttonString = ButtonString.getInstance();
        String resultShort = " ";
        String key1 = key_one.getText();

        resultShort += buttonString.getButton() + "/";
        for (String key : shortKeys) {
            if (!key.isEmpty()) {
                resultShort += key + ";";
            }
        }
        if (key1 != null) {
            resultShort += key1;
        }
        sendMessage(resultShort + "\\");
        shortKeys.clear();
        Parent SigInParrent = FXMLLoader.load(getClass().getResource("../View/Keyboard.fxml"));
        Scene SignInScene = new Scene(SigInParrent);
        Stage SigInStage;
        SigInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SigInStage.setResizable(false);
        SigInStage.setScene(SignInScene);
        SigInStage.show();
    }
    @FXML
    void pressedbtn(KeyEvent event) {


    }
    @FXML
    void alt_button(ActionEvent event) {
        shortKeys.add("alt");

    }

    @FXML
    void ctrl_button(ActionEvent event) {
        shortKeys.add("ctrl");
    }

    @FXML
    void del_btn(ActionEvent event) {
        shortKeys.add("del");
    }

    @FXML
    void shift_button(ActionEvent event) {
        shortKeys.add("shift");
    }

    @FXML
    void window_button(ActionEvent event) {
        shortKeys.add("win");
    }


    private String sendMessage(String msg) throws IOException {
        String result = "send";
        SerialPort sp = SerialPort.getCommPort("COM11");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (sp.openPort()) {
            System.out.println("open");
        } else {
            System.out.println("close");
            result = "not send";
            return result;
        }

        System.out.println(msg);
        System.out.println(msg.getBytes());
        sp.getOutputStream().write(msg.getBytes(StandardCharsets.UTF_8));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (sp.closePort()) {
            System.out.println("zakrito");
        } else {
            System.out.println("otkrito");
        }
        return result;
    }

}
