package com.mainclass;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import libs.ConfigClass;
import loginTest.LoginBackendTest;

import java.io.IOException;

public class MainSceneController {
    protected String loginName;
    protected String loginPass;
    protected String brandName;
    protected String bonusTitle;
    protected String gameTitle;
    protected String playerID;
    protected String betDenomination;
    protected String betAmount;

    public String[] prop = new String[16];
    protected LoginBackendTest loginBackendTest;

    public MainSceneController() {
        controllerInit();
    }

    public void controllerInit() {

        try {
            loginName = ConfigClass.getConfigValue("login_name");
            loginPass = ConfigClass.getConfigValue("login_password");
            brandName = ConfigClass.getConfigValue("brand_name");
            bonusTitle = ConfigClass.getConfigValue("bonus_title");
            gameTitle = ConfigClass.getConfigValue("game_title");
            playerID = ConfigClass.getConfigValue("player_id");
            betDenomination = ConfigClass.getConfigValue("bet_denomination");
            betAmount = ConfigClass.getConfigValue("bet_amount");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void loadButtonClicked() {
        System.out.println("Load button clicked");
        log_name.setText(loginName);
        log_pass.setText(loginPass);
        brand_name.setText(brandName);
        bonus_title.setText(bonusTitle);
        game_name.setText(gameTitle);
        player_id.setText(playerID);
        bet_denom.setText(betDenomination);
        bet_amount.setText(betAmount);
    }

    @FXML
    public void configButtonClicked() {
        System.out.println("Configure button clicked");

        prop[0] = "login_name"; prop[1] = log_name.getText();
        prop[2] = "login_password"; prop[3] = log_pass.getText();
        prop[4] = "brand_name"; prop[5] = brand_name.getText();
        prop[6] = "bonus_title"; prop[7] = bonus_title.getText();
        prop[8] = "game_title"; prop[9] = game_name.getText();
        prop[10] = "player_id"; prop[11] = player_id.getText();
        prop[12] = "bet_denomination"; prop[13] = bet_denom.getText();
        prop[14] = "bet_amount"; prop[15] = bet_amount.getText();

        try {
            ConfigClass.setConfigValue(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        loginBackendTest = new LoginBackendTest();
        loginBackendTest.backendLogin();
    }

    @FXML
    public TextField log_name;
    @FXML
    public TextField log_pass;
    @FXML
    public TextField brand_name;
    @FXML
    public TextField bonus_title;
    @FXML
    public TextField game_name;
    @FXML
    public TextField player_id;
    @FXML
    public TextField bet_denom;
    @FXML
    public TextField bet_amount;

}
