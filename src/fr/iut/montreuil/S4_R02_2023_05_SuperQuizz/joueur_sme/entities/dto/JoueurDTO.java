package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto;

public class JoueurDTO {
	
	private String prénom;
	private String pseudo;
	private int annéeNaissance;
	private String centresDintérêt;
	public JoueurDTO(String prénom, String pseudo, int annéeNaissance, String centresDintérêt) {
		super();
		this.prénom = prénom;
		this.pseudo = pseudo;
		this.annéeNaissance = annéeNaissance;
		this.centresDintérêt = centresDintérêt;
	}
	public String getPrénom() {
		return prénom;
	}
	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getAnnéeNaissance() {
		return annéeNaissance;
	}
	public void setAnnéeNaissance(int annéeNaissance) {
		this.annéeNaissance = annéeNaissance;
	}
	public String getCentresDintérêt() {
		return centresDintérêt;
	}
	public void setCentresDintérêt(String centresDintérêt) {
		this.centresDintérêt = centresDintérêt;
	}
	
	
}