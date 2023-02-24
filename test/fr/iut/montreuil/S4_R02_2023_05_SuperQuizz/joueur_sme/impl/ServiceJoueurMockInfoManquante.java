package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl;

import java.util.Set;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.IServiceJoueur;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.absentDeListeException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.fausseAnneeNaissanceException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.infoManquanteException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.pseudoExistantException;

public class ServiceJoueurMockInfoManquante implements IServiceJoueur {

	
	public ServiceJoueurMockInfoManquante() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<JoueurDTO> listerJoueur() {
		return null;
	}

	@Override
	public JoueurDTO ajouterJoueur(String prénom, String pseudo, int annéeNaissance, String centresDintérêt)
			throws pseudoExistantException, infoManquanteException, fausseAnneeNaissanceException {
		throw new infoManquanteException(pseudo);
	}

	@Override
	public void supprimerJoueur(String pseudo) throws absentDeListeException, infoManquanteException {
		throw new infoManquanteException(pseudo);

	}

}
