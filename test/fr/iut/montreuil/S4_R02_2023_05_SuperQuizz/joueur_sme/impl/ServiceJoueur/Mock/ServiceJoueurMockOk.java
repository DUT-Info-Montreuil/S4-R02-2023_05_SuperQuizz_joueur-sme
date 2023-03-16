package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock;


import java.util.List;
import java.util.Set;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.IServiceJoueur;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.pasDePartieException;

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

	@Override
	public double calculMoyennePartie() throws pasDePartieException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculDureeMoyenne() throws pasDePartieException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double convertitSecondesEnMinutes() throws pasDePartieException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ajouterPartieJoueurDTO(int score, int temps) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PartieJoueurDTO> partiesJouée() {
		// TODO Auto-generated method stub
		return null;
	}

}
