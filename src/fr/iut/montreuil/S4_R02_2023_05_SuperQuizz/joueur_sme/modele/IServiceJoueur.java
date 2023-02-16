package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele;

import java.util.Set;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;

public interface IServiceJoueur {
	
	public Set<JoueurDTO> listerJoueur();
	public JoueurDTO ajouterJoueur(String prénom, String pseudo, int annéeNaissance, String centresDintérêt);
	//creer succes : renvoie joueur cree
	//exeption pseudoExistant
	//exeption infoManquante(String manquant)
	//exeption fausseAnneeNaissance (si année de naissance < 1900)
	public int supprimerJoueur(String pseudo);
	// si absent de liste:-1
	// si suppression effectué : 0
	// autre : 1
	//exeption infoManquantes
	

}
