package sample.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yago Garcia Battaggia - 18.01099-7
 * @since 21/09/2020
 */

public class ListCartas {
    private List<Carta> listCartas;


    public ListCartas() {
        this.listCartas = new ArrayList<Carta>();
    }

    /**
     * Procura o id recebido na List para ver se ele já está cadastrado
     * @return Boolean se o id está na List
     */
    public boolean idEstaNaLista(String id){
        for (Carta carta: this.listCartas){
            if(carta.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    /**
     * Getter da lista de cartas
     * @return Lista com objetos das cartas
     */
    public List<Carta> getListCartas() {
        return listCartas;
    }

    /**
     * Setter da Lista de cartas
     * @param listCartas List contendo objetos de cartas
     */
    public void setListCartas(List<Carta> listCartas) {
        this.listCartas = listCartas;
    }

    /**
     * Adiciona a carta na Lista de cartas
     * @param newCarta objeto da carta a ser adicionada
     */
    public void addCarta(Carta newCarta){
        listCartas.add(newCarta);
    }

    /**
     * Remove a carta da Lista de cartas
     * @param id id da carta a ser removida
     */
    public void removeCarta(String id){
        this.listCartas.removeIf(carta -> carta.getId().equals(id));
    }

    /**
     * Edita a carta na Lista de Cartas
     * @param newCarta Objeto da carta atualizado
     */
    public void editCarta(Carta newCarta){
        for (Carta carta: this.listCartas){
            if(carta.getId().equals(newCarta.getId())){
                carta.setNome(newCarta.getNome());
                carta.setUrl(newCarta.getUrl());
                carta.setSerie(newCarta.getSerie());
                carta.setColecao(newCarta.getColecao());
                carta.setRaridade(newCarta.getRaridade());
            }
        }
    }
}
