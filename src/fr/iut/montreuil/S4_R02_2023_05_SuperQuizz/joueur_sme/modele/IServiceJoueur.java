package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele;

import java.util.Set;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;

public interface IServiceJoueur {
	
	public Set<JoueurDTO> listerJoueur();
	public JoueurDTO ajouterJoueur(String prénom, String pseudo, int annéeNaissance, String centresDintérêt);
	public int supprimerJoueur(String pseudo);

}
