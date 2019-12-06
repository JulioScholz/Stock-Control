package sample;

import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import sun.java2d.opengl.WGLSurfaceData;
import java.lang.String;

//scene1    -   tela login
//scene2    -   menu principal
//scene3    -   tela relatorio
//scene4    -   tela cadastro funcionario
//scene5    -   tela venda
//scene6    -   tela pesquisar produto no estoque
//scene7    -   cadastrar produto
//scene8    -   tela de usuario nao administrador
//scene5_1 e scnene6_1   - telas venda e pesquisar produto(são iguais) oq muda [e a função do botao voltar
public class StockControll {

    private static final int NOUSERNAME = 0;
    private static final int NOPASSWORD = 1;
    private static final int WRONGUSER = 2;
    private static final int WRONGPASSWORD = 3;
    private static final int RIGHTUSER = 4;
    private static final int RIGHTADMNIN = 5;

    private Stock stock;
    private User_Manager user_Manager = new User_Manager();


    @FXML
    private TextField input_user_login;
    @FXML
    private TextField input_user_password;
    @FXML
    private TextArea textarea_relatorio;
    @FXML
    private Label noUserWarning;
    @FXML
    private Label noPasswordWarning;

    @FXML
    private void handlerButtonAction_login(ActionEvent event) throws IOException{

        int retorno = login(input_user_login, input_user_password);

        noUserWarning.setText("");
        noPasswordWarning.setText("");

        System.out.println(retorno);

        if(retorno == NOUSERNAME)
            noUserWarning.setText("Usuário não preenchido");
        else if (retorno == NOPASSWORD)
            noPasswordWarning.setText("Senha não preenchida");
        else if (retorno == WRONGUSER)
            noUserWarning.setText("Usuário não encontrado");
        else if(retorno == WRONGPASSWORD)
            noPasswordWarning.setText("Senha inválida");
        else if (retorno == RIGHTADMNIN){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene8.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        }
        else if(retorno == RIGHTUSER){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene2.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }

        /*if(input_user_login.getText().equals("admin") && input_user_password.getText().equals("admin")) {

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene2.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else{

            Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene8.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }*/
    }

    @FXML
    private void handlerButtonAction_pesquisar(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene6.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_pesquisar2(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene6_1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_relatorio(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene3.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_vender(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene5.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void handlerButtonAction_vender2(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene5_1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void handlerButtonAction_voltar(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene2.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    @FXML
    private void handlerButtonAction_voltar2(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene8.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_cadastrarFunc(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene4.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handlerButtonAction_cadastrarObj(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene7.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void handlerButtonAction_logout(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }


    public int login(TextField userName, TextField password) {
        if(userName.getText().trim().isEmpty())
            return NOUSERNAME;
        else if(password.getText().trim().isEmpty())
            return NOPASSWORD;
        else {
            return user_Manager.authenticate(userName.getText(), password.getText());
        }
    }

    public void updateStock() {

    }

    public void mainLoop() {

    }

    public void showLog() {
        textarea_relatorio.insertText(0,"teste\n");
        textarea_relatorio.insertText(0,"teste\n");
        textarea_relatorio.insertText(0,"teste\n");
    }

    public void manageUser() {

    }

    public void StockControl() {

    }

    public void showMenu() {

    }

    public void showLoginScreen() {

    }

    public void showUpdateStockScreen() {

    }

    public void showLogScreen() {

    }

    public void showUserManagerScreen() {

    }

}

