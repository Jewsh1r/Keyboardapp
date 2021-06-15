package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import org.w3c.dom.Text;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class KeyboardController {
    ButtonString button = ButtonString.getInstance();

    @FXML
    private TabPane KeyTabPane;


    @FXML
    private Tab TabL1;


    @FXML
    private Tab TabL2;


    @FXML
    private Button AltEscButton;

    @FXML
    private Button AltF4Button;

    @FXML
    private Button AltTabButton;

    @FXML
    private Button CtrlShiftEscButton;

    @FXML
    private Label lblErrors;

    @FXML
    void Accept(ActionEvent event) {

    }

    @FXML
    void E_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("03");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void Q_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("05");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();
    }

    @FXML
    void R_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("02");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();
    }

    @FXML
    void T_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("01");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();
    }

    @FXML
    void W_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("04");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void fourth_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("30");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void one_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("00");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void three_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("20");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void two_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("10");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }
    @FXML
    void A_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("11");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void D_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("24");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void F_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("23");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();
    }

    @FXML
    void G_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("22");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void H_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("21");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void I_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("13");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void J_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("35");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void K_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("34");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void L_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("33");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void P_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("12");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }


    @FXML
    void S_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("25");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }



    @FXML
    void U_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("14");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }


    @FXML
    void X_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("31");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void Y_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("15");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

    @FXML
    void Z_bttn(ActionEvent event) throws IOException {
        button.setButton("");
        button.setButton("32");
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/BindWindow.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignUpStage.setResizable(false);
        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }

}
