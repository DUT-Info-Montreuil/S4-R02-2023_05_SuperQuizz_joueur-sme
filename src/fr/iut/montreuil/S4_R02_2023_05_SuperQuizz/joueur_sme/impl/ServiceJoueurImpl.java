package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.IServiceJoueur;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.absentDeListeException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.fausseAnneeNaissanceException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.infoManquanteException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.pasDePartieException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.pseudoExistantException;

public class ServiceJoueurImpl implements IServiceJoueur{

	private Set<JoueurDTO> listeJoueurDTO;
	private static final ServiceJoueurImpl instance = new ServiceJoueurImpl();
	
	private ServiceJoueurImpl() {
		this.listeJoueurDTO = new TreeSet();
	}
	
	public static ServiceJoueurImpl getInstance() {
		return instance;
	}
	
	@Override
	public Set<JoueurDTO> listerJoueur() {
		return this.listeJoueurDTO;
	}

	@Override
	public JoueurDTO ajouterJoueur(String prénom, String pseudo, int annéeNaissance, String centresDintérêt) 
			throws pseudoExistantException, infoManquanteException, fausseAnneeNaissanceException {

		if (pseudo == null) {
			throw new infoManquanteException(pseudo);
		} else if (prénom == null) {
			throw new infoManquanteException(prénom);
		} else if (centresDintérêt == null) {
			throw new infoManquanteException(centresDintérêt);	
		} else if (annéeNaissance < 1900) {
			throw new fausseAnneeNaissanceException();
		}
		
		for (JoueurDTO j : this.listeJoueurDTO) {
			if (j.getPseudo().equals(pseudo)) {
				throw new pseudoExistantException();
			}
		}
		JoueurDTO joueurdto = new JoueurDTO(prénom, pseudo, annéeNaissance, centresDintérêt);
		this.listeJoueurDTO.add(joueurdto);
		
		return joueurdto;
	}

	@Override
	public void supprimerJoueur(String pseudo) throws absentDeListeException, infoManquanteException {
		boolean estPresent = false;
		if (pseudo == null) {
			throw new infoManquanteException(pseudo);
		} 
		for (JoueurDTO j : this.listeJoueurDTO) {
			if (j.getPseudo().equals(pseudo)){
				this.listeJoueurDTO.remove(j);
				estPresent = true;
			}
		}
		if (!estPresent) {
			throw new absentDeListeException();
		}
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












