package sample;

import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

//scene1    -   tela login
//scene2    -   menu principal
//scene3    -   tela relatorio
//scene4    -   tela cadastro funcionario
//scene5    -   tela venda
//scene6    -   tela pesquisar produto no estoque
//scene7    -   cadastrar produto
//scene8    -   tela de usuario nao administrador
//scene5_1 e scnene6_1   - telas venda e pesquisar produto(são iguais) oq muda [e a função do botao voltar
public class Controller {

    @FXML
    private TextField input_user_login;
    @FXML
    private TextField input_user_password;

    @FXML
    private void handlerButtonAction_login(ActionEvent event) throws IOException{

        if(input_user_login.getText().equals("admin") && input_user_password.getText().equals("admin")) {

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else{

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene8.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
    }

    @FXML
    private void handlerButtonAction_pesquisar(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene6.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_pesquisar2(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene6_1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_relatorio(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_vender(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene5.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void handlerButtonAction_vender2(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene5_1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void handlerButtonAction_voltar(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    @FXML
    private void handlerButtonAction_voltar2(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene8.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_cadastrarFunc(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_cadastrarObj(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene7.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void handlerButtonAction_logout(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
