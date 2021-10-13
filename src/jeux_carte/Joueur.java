package jeux_carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author evanbaillieu
 */
public class Joueur {
    private List<Carte> cartes;
    private Integer points;

    public Joueur() {
        this.cartes = new ArrayList<Carte>();
        this.points = 0;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public Integer getPoints() {
        return points;
    }
    
    public void addPoints(){
    	this.points++;
    }
    
    public boolean addCartes(Carte c){
        if(this.cartes.add(c)){
            return true;
        }
        return false;
    }
    
    public boolean removeCarte(Carte c){
        if(this.cartes.remove(c)){
            return true;
        }
        return false;
    }
    
    public void addAllCarte(List<Carte> c) {
    	this.cartes.addAll(c);
    }
    public void removeAll() {
    	this.cartes.clear();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        if (!Objects.equals(this.cartes, other.cartes)) {
            return false;
        }
        if (!Objects.equals(this.points, other.points)) {
            return false;
        }
        return true;
    }
    
    
}
