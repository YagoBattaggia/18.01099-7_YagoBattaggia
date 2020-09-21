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
            return carta.getId().equals(id);
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
}
