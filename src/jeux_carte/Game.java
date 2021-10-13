package jeux_carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author evanbaillieu
 */
public class Game {

    private List<Carte> paquets;
    private HashMap<String, Integer> force;
    private Joueur p1;
    private Joueur p2;
    private List<Carte> battaile;

    public Game() {
        this.p1 = new Joueur();
        this.p2 = new Joueur();
        this.paquets = new ArrayList<Carte>();
        this.force = new HashMap<String, Integer>();
        this.battaile = new ArrayList<Carte>();
        List<String> tab = new ArrayList<String>();
        Integer j = 1;
        String[] colors = new String[4];
        colors[0] = "noir";
        colors[1] = "rouge";
        colors[2] = "vert";
        colors[3] = "jaune";

        for (Integer i = 2; i <= 10; i++) {
            tab.add(i.toString());
        }
        tab.add("valer");
        tab.add("dame");
        tab.add("roi");
        tab.add("ass");
        for (Integer i = 0; i < 4; i++) {
            for (String str : tab) {
                Carte carte = new Carte(str, colors[i]);
                System.out.println(carte.getColor() + " " + carte.getCarte());
                paquets.add(carte);
                if (i < 1) {
                    this.force.put(str, j);
                    j++;
                }
            }
        }
    }

    private void melangeur() {
        Collections.shuffle(this.paquets);
        this.paquets.size();
    }

    private void distribution() {
        int i = 0;
        for (Carte carte : this.paquets) {
            if (i % 2 == 0) {
                this.p1.addCartes(carte);
            } else {
                this.p2.addCartes(carte);
            }
            i++;
        }
    }

    public String joue() {
        this.melangeur();
        this.distribution();
        System.out.println(this.p1.getCartes().isEmpty() + " " + this.p2.getCartes().isEmpty());
        while (this.p1.getCartes().size() > 0 && this.p2.getCartes().size() > 0){
            this.combat();           
        }
        if(this.p1.getCartes().size() > 0){
           System.out.println("le joueur 1 gagne : " + this.p1.getCartes().size() + " Points : " + this.p1.getPoints());
        }else{
            System.out.println("le joueur 2 gagne : " + this.p2.getCartes().size() + " Points : " + this.p2.getPoints());
        }
        return "FIN";
    }

    private void battaile() {
        System.out.println("battaile");
        Carte cp1 = this.p1.getCartes().get(0);
        Carte cp2 = this.p2.getCartes().get(0);
        this.battaile.add(cp1);
        this.battaile.add(cp2);
        this.p1.removeCarte(cp1);
        this.p2.removeCarte(cp2);
        cp1 = this.p1.getCartes().get(0);
        cp2 = this.p2.getCartes().get(0);
        this.battaile.add(cp1);
        this.battaile.add(cp2);
        this.p1.removeCarte(cp1);
        this.p2.removeCarte(cp2);
    }

    private void combat() {
        Carte carteP1 = this.p1.getCartes().get(0);
        Carte carteP2 = this.p2.getCartes().get(0);
        System.out.println(carteP1.toString() + " contre " + carteP2.toString());
        System.out.println(this.p1.getCartes().size());
        System.out.println(this.p2.getCartes().size());
        if(this.force.get(carteP1.getCarte()) > this.force.get(carteP2.getCarte())) {
            System.out.println("le joueur 1 gagne la manche");
            this.p1.removeCarte(carteP1);
            this.p1.addCartes(carteP1);
            this.p1.addCartes(carteP2);
            this.p2.removeCarte(carteP2);
            if (this.battaile.size() > 0) {
            	this.p1.addAllCarte(this.battaile);
                this.battaile.clear();
            }
            this.p1.addPoints();
        } else if (this.force.get(carteP1.getCarte()) < this.force.get(carteP2.getCarte())) {
            System.out.println("le joueur 2 gagne la manche");
            if (this.battaile.size() > 0) {
            	this.p2.addAllCarte(this.battaile);
                this.battaile.clear();
            }
            this.p2.removeCarte(carteP2);
            this.p2.addCartes(carteP2);
            this.p2.addCartes(carteP1);
            this.p1.removeCarte(carteP1);
            this.p2.addPoints();
        } else {
        	if(this.p1.getCartes().size() >= 3 && this.p2.getCartes().size() >= 3){
        		this.battaile();
                this.combat();
        	}else {
        		if(this.p1.getCartes().size() >= 3){
        			this.p1.addAllCarte(this.p2.getCartes());
        			this.p2.removeAll();
        		}else {
        			this.p2.addAllCarte(this.p1.getCartes());
        			this.p1.removeAll();
        		}
        	}
        }
    }
    
    public void reset() {
    	this.p1.removeAll();
    	this.p2.removeAll();
    	List<String> tab = new ArrayList<String>();
        Integer j = 1;
        String[] colors = new String[4];
        colors[0] = "noir";
        colors[1] = "rouge";
        colors[2] = "vert";
        colors[3] = "jaune";

        for (Integer i = 2; i <= 10; i++) {
            tab.add(i.toString());
        }
        tab.add("valer");
        tab.add("dame");
        tab.add("roi");
        tab.add("ass");
        for (Integer i = 0; i < 4; i++) {
            for (String str : tab) {
                Carte carte = new Carte(str, colors[i]);
                System.out.println(carte.getColor() + " " + carte.getCarte());
                paquets.add(carte);
            }
        }
    }
}
