package sample.models;

import java.util.ArrayList;
import java.util.List;

public class ListCartas {
    private List<Carta> listCartas;

    public ListCartas() {
        this.listCartas = new ArrayList<Carta>();
    }

    public boolean idEstaNaLista(String id){
        for (Carta carta: this.listCartas){
            if(carta.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public List<Carta> getListCartas() {
        return listCartas;
    }

    public void setListCartas(List<Carta> listCartas) {
        this.listCartas = listCartas;
    }

    public void addCarta(Carta newCarta){
        listCartas.add(newCarta);
    }

    public void removeCarta(String id){
        this.listCartas.removeIf(carta -> carta.getId().equals(id));
    }

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
