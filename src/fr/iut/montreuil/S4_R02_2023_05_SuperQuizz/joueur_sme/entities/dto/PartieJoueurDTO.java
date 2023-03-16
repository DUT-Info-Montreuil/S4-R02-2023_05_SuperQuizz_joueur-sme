package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto;

import java.util.Objects;

public class PartieJoueurDTO {
	
	private int score;
	private int seconde;
	
	public PartieJoueurDTO(int score, int seconde) {
		super();
		this.score = score;
		this.seconde = seconde;
	}
	public int getScore() {
		return score;
	}

	public int getSeconde() {
		return seconde;
	}
	
	@Override
	public String toString() {
		return "Partie [score=" + score + ", seconde=" + seconde + "]";
	}
		

}
