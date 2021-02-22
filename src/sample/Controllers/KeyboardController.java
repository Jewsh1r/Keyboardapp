package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class KeyboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane KeyTabPane;

    @FXML
    private AnchorPane KeyAnchorDefault;

    @FXML
    private Tab TabL1;

    @FXML
    private AnchorPane KeyAnchorL1;

    @FXML
    private Tab TabL2;

    @FXML
    private AnchorPane KeyAnchorL2;

    @FXML
    private Button AltEscButton;

    @FXML
    private Button AltF4Button;

    @FXML
    private Button AltTabButton;

    @FXML
    private Button CtrlShiftEscButton;

    
        public void Adminhandle(ActionEvent event) throws IOException {

            Parent AdminMenu = FXMLLoader.load(getClass().getResource("../View/AdminPanel.fxml"));
            Scene AdminMenuScene = new Scene(AdminMenu);
            Stage AdminMenuStage;
            AdminMenuStage = (Stage)((Node)event.getSource()).getScene().getWindow();

            AdminMenuStage.setScene(AdminMenuScene);
            AdminMenuStage.show();



        }
}
