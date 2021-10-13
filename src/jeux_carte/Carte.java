package jeux_carte;

import java.util.Objects;

/**
 *
 * @author evanbaillieu
 */
public class Carte {
    
    private  String color;
    private  String valeur;

    public Carte() {
        this.color = "";
        this.valeur = "";
    }
    
    

    public Carte( String valeur, String color){
        this.color = color;
        this.valeur = valeur;
    }
    
    public String getCarte(){
        return this.valeur;
    }
    
    public String getColor(){
        return this.color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.color);
        hash = 53 * hash + Objects.hashCode(this.valeur);
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
        final Carte other = (Carte) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.valeur, other.valeur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  color + " " + valeur;
    }
    
    
}
