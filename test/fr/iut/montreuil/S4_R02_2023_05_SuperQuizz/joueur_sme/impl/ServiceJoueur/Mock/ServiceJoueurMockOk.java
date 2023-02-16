package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock;


import java.util.Set;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.IServiceJoueur;

public class ServiceJoueurMockOk implements IServiceJoueur {
	
	public ServiceJoueurMockOk() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<JoueurDTO> listerJoueur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JoueurDTO ajouterJoueur(String prénom, String pseudo, int annéeNaissance, String centresDintérêt) {
		JoueurDTO joueur = new JoueurDTO(prénom, pseudo, annéeNaissance, centresDintérêt);
		return joueur;
	}

	@Override
	public void supprimerJoueur(String pseudo) {
		
	}

}
