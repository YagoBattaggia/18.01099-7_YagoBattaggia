package sample;

import com.sun.org.omg.CORBA.Initializer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.dao.CartaDAO;
import sample.models.Carta;
import sample.models.ListCartas;
import sun.font.TextLabel;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Yago Garcia Battaggia - 18.01099-7
 * @since 21/09/2020
 */
public class Controller implements Initializable {
    private ListCartas lista = new ListCartas();
    private CartaDAO cartaDAO = new CartaDAO();
    private int indexCard = 0;

    @FXML
    public TextField inputId, inputColecao, inputSerie, inputRaridade, inputNome, inputURL;
    @FXML
    private ImageView imgCarta;
    @FXML
    private Button btnInserir;

    /**
     * Método que é chamado quando a aplicação é inicializada. Imprime os dados iniciais no programa.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista.setListCartas(cartaDAO.getAll());
        System.out.println(lista.getListCartas().get(0));
        try{
            inputId.setText(lista.getListCartas().get(0).getId());
            inputId.setDisable(true);
            inputColecao.setText(lista.getListCartas().get(0).getColecao());
            inputSerie.setText(lista.getListCartas().get(0).getSerie());
            inputRaridade.setText(lista.getListCartas().get(0).getRaridade());
            inputNome.setText(lista.getListCartas().get(0).getNome());
            inputURL.setText(lista.getListCartas().get(0).getUrl());

            btnInserir.setDisable(true);

            //Imagem não carrega, tentei com FileStream e também não funcionou.
            Image img = new Image(lista.getListCartas().get(0).getUrl());
            imgCarta.setImage(img);

        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Método que é chamado quando o usuário clica no botão para alterar para a próxima carta da Lista.
     * <br> Checa se há uma próxima carta e, caso exista, imprime a próxima carta na tela.
     */
    public void proximaCarta() {
        if((lista.getListCartas().size() > indexCard + 1)) {
            try {
                indexCard += 1;
                inputId.setText(lista.getListCartas().get(indexCard).getId());
                inputColecao.setText(lista.getListCartas().get(indexCard).getColecao());
                inputSerie.setText(lista.getListCartas().get(indexCard).getSerie());
                inputRaridade.setText(lista.getListCartas().get(indexCard).getRaridade());
                inputNome.setText(lista.getListCartas().get(indexCard ).getNome());
                inputURL.setText(lista.getListCartas().get(indexCard).getUrl());

                //Imagem não carrega, tentei com FileStream e também não funcionou.
                Image img = new Image(lista.getListCartas().get(indexCard + 1).getUrl());
                imgCarta.setImage(img);
                inputId.setDisable(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Método que é chamado quando o usuário clica no botão para alterar para a carta anterior da Lista.
     * <br> Checa se há uma carta anterior e, caso exista, imprime a carta na tela.
     */
    public void cartaAnterior() {
        if( !((indexCard - 1) < 0) ){
            System.out.println(indexCard);
            System.out.println(indexCard - 1);
            try{
            indexCard -= 1;
            inputId.setText(lista.getListCartas().get(indexCard).getId());
            inputColecao.setText(lista.getListCartas().get(indexCard ).getColecao());
            inputSerie.setText(lista.getListCartas().get(indexCard ).getSerie());
            inputRaridade.setText(lista.getListCartas().get(indexCard).getRaridade());
            inputNome.setText(lista.getListCartas().get(indexCard).getNome());
            inputURL.setText(lista.getListCartas().get(indexCard ).getUrl());

            //Imagem não carrega, tentei com FileStream e também não funcionou.
            Image img = new Image(lista.getListCartas().get(indexCard - 1).getUrl());
            imgCarta.setImage(img);
            inputId.setDisable(true);

            } catch (Exception e){
                System.out.println(e);
            }

        }
    }

    /**
     * Método que é chamado quando o usuário clica no botão para limpar os elementos da tela. Limpa todos os TextFields, habilita a edição do TextField do ID e habilita o botão para inserir dados no banco de dados
     */
    public void clearFields(){
        inputId.clear();
        inputURL.clear();
        inputSerie.clear();
        inputColecao.clear();
        inputRaridade.clear();
        inputNome.clear();

        inputId.setDisable(false);
        btnInserir.setDisable(false);

    }
    /**
     * Método que é chamado quando o usuário clica no botão de inserir nova carta no bando de dados. Pega os dados dos TextFields e solicita a alteração para o banco de dados.
     * <br> Gera um Alert caso algum campo esteja vazio.
     */
    public void adicionaCarta(){
        String id = inputId.getText();
        String url = inputURL.getText();
        String nome = inputNome.getText();
        String raridade = inputRaridade.getText();
        String serie = inputSerie.getText();
        String colecao = inputColecao.getText();

        if (id.equals("") || url.equals("") || nome.equals("") || raridade.equals("") || serie.equals("") || colecao.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Preencha todos os campos.");
            alert.setTitle("Erro");
            alert.showAndWait();
        } else {
            Carta newCarta = new Carta(url, id, nome, raridade, serie, colecao);
            System.out.println(lista.idEstaNaLista(id));
            if(lista.idEstaNaLista(id)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Id já está cadastrado.");
                alert.setTitle("Erro");
                alert.showAndWait();
            } else {
                lista.addCarta(newCarta);
                cartaDAO.create(newCarta);
                System.out.println(newCarta);
                inputId.setDisable(true);
                btnInserir.setDisable(true);
            }
        }
    }
    /**
     * Método que é chamado quando o usuário clica no botão de editar cartas. Pega os dados dos TextFields e solicita a alteração para o banco de dados.
     * <br> Gera um Alert caso algum campo esteja vazio.
     */
    public void editarCarta(){
        String id = inputId.getText();
        String url = inputURL.getText();
        String nome = inputNome.getText();
        String raridade = inputRaridade.getText();
        String serie = inputSerie.getText();
        String colecao = inputColecao.getText();

        if (id.equals("") || url.equals("") || nome.equals("") || raridade.equals("") || serie.equals("") || colecao.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Preencha todos os campos.");
            alert.setTitle("Erro");
            alert.showAndWait();
        } else {
            Carta newCarta = new Carta(url, id, nome, raridade, serie, colecao);

                lista.editCarta(newCarta);
                cartaDAO.update(newCarta);
                System.out.println(newCarta);

                btnInserir.setDisable(true);
                inputId.setDisable(true);
        }
    }

    /**
     * Método que é chamado quando o usuário clica no botão de deletar carta. Pega o id no TextField e solicita a remoção para o banco de dados.
     * <br> Gera um Alert caso o campo do Id esteja vazio
     */
    public void deletarCarta(){
        String id = inputId.getText();
        if (id.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Preencha Id inexistente. Favor preencher o Id");
            alert.setTitle("Erro");
            alert.showAndWait();
        } else {
            lista.removeCarta(id);
            cartaDAO.delete(id);
            clearFields();
        }
    }
}
