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
import java.sql.SQLException;

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
    private static final int NOPRODUCT = -1;
    private static final int NOQTY = -2;
    private float soma = 0;
    private String stringVendas = "";

    private Stock stock = new Stock();
    private User_Manager user_Manager = new User_Manager();
    //private Product produto = new Product();


    @FXML
    private TextField input_user_login;
    @FXML
    private TextField input_user_password;
    @FXML
    private TextArea textarea_relatorio;
    @FXML
    private TextField qtyProduct1;
    @FXML
    private TextField IDproduct1;
    @FXML
    private TextField qtyProduct2;
    @FXML
    private TextField IDproduct2;
    @FXML
    private Label noUserWarning;
    @FXML
    private Label noPasswordWarning;
    @FXML
    private Label mensagemID1;
    @FXML
    private Label mensagemqty1;
    @FXML
    private TextArea soma1;
    @FXML
    private TextArea registroVendas;
    @FXML
    private Label mensagemID2;
    @FXML
    private Label mensagemqty2;
    @FXML
    private TextArea soma2;
    @FXML
    private TextArea registroVendas2;

    @FXML
    private void handlerButtonAction_login(ActionEvent event) throws IOException, SQLException {
        showLoginScreen(event);
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
        soma = 0;
        showUpdateStockScreen(event);
    }

    @FXML
    private void handlerButtonAction_vender2(ActionEvent event) throws IOException{
        soma = 0;
        showUpdateStockScreen2(event);

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
    @FXML
    private void handlerButtonAction_inserirProduto(ActionEvent event) throws IOException, SQLException {
        updateStock();
    }
    @FXML
    private void handlerButtonAction_inserirProduto2(ActionEvent event) throws IOException{
        updateStock2();
    }
    @FXML
    private void handlerButtonAction_finalizarVenda1(ActionEvent event)throws IOException{
        soma1.setText("");
        registroVendas.setText("");
    }
    @FXML
    private void handlerButtonAction_finalizarVenda2(ActionEvent event)throws IOException{
        soma2.setText("");
        registroVendas2.setText("");
    }

    public void updateStock() throws SQLException {
        mensagemID1.setText("");
        mensagemqty1.setText("");

        if(IDproduct1.getText().trim().isEmpty())
            mensagemID1.setText("ID do produto não preenchido");
        else if(qtyProduct1.getText().trim().isEmpty())
            mensagemqty1.setText("Quantidade não preenchida");
        else{/*
            int qty = Integer.parseInt(qtyProduct1.getText());
            Product produto = stock.update_qty(IDproduct1.getText(), qty);
            if(produto == null){
                mensagemID1.setText("Produto não encontrado");
            }
            else{
                if(produto.getQuantidadeAux() < 0){
                    mensagemqty1.setText("Quantidade insuficiente");
                }
                else{
                    soma += (float)(produto.getPreco() * qty);
                    String somaStr = String.format("%,.2f", soma);
                    if(somaStr.substring(somaStr.length() - 1).equals("0"))
                        somaStr = somaStr;
                    else
                        somaStr = somaStr + "0";
                    if(somaStr.substring(somaStr.length() - 2).equals(".0"))
                        somaStr = somaStr + "0";

                    soma1.setText("R$" + somaStr);
                    stringVendas = stringVendas + produto.getID() + "\t\t" + produto.getNome() + "\t\t" + qty + "\t\tR$" + produto.getPreco() + "\t\tR$" + produto.getPreco() * qty + "\n";
                    registroVendas.setText(stringVendas);

                }
            }
        */}
    }

    public void updateStock2(){
        mensagemID2.setText("");
        mensagemqty2.setText("");

        if(IDproduct2.getText().trim().isEmpty())
            mensagemID2.setText("ID do produto não preenchido");
        else if(qtyProduct2.getText().trim().isEmpty())
            mensagemqty2.setText("Quantidade não preenchida");
        else{/*
            int qty = Integer.parseInt(qtyProduct2.getText());
            Product produto = stock.update_qty(IDproduct2.getText(), qty);
            if(produto == null){
                mensagemID2.setText("Produto não encontrado");
            }
            else{
                if(produto.getQuantidadeAux() < 0){
                    mensagemqty2.setText("Quantidade insuficiente");
                }
                else{
                    soma += (float)(produto.getPreco() * qty);
                    String somaStr = String.format("%,.2f", soma);
                    if(somaStr.substring(somaStr.length() - 1).equals("0"))
                        somaStr = somaStr;
                    else
                        somaStr = somaStr + "0";
                    if(somaStr.substring(somaStr.length() - 2).equals(".0"))
                        somaStr = somaStr + "0";

                    soma2.setText("R$" + somaStr);
                    stringVendas = stringVendas + produto.getID() + "\t\t" + produto.getNome() + "\t\t" + qty + "\t\tR$" + produto.getPreco() + "\t\tR$" + produto.getPreco() * qty + "\n";
                    registroVendas2.setText(stringVendas);

                }
            }
       */ }
    }
    public int login(TextField userName, TextField password) throws SQLException {
        if(userName.getText().trim().isEmpty())
            return NOUSERNAME;
        else if(password.getText().trim().isEmpty())
            return NOPASSWORD;
        else if(user_Manager.authenticate(userName.getText(), password.getText()) == true)
            return 5;
        return 0;
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

    public void showLoginScreen(ActionEvent event) throws IOException, SQLException {
        int retorno = login(input_user_login, input_user_password);

        noUserWarning.setText("");
        noPasswordWarning.setText("");

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

    }
    @FXML
    public void showUpdateStockScreen(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene5.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void showUpdateStockScreen2(ActionEvent event)throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("sample/scene5_1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }


    public void showLogScreen() {

    }

    public void showUserManagerScreen() {

    }

}

