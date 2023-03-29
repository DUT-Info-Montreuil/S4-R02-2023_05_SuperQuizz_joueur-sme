package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl;

import java.util.ArrayList;
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
	private List<PartieJoueurDTO> parties;
	private static ServiceJoueurImpl instance = new ServiceJoueurImpl();
	
	private ServiceJoueurImpl() {
		this.listeJoueurDTO = new TreeSet();
		parties = new ArrayList<PartieJoueurDTO>();
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
		if(parties.isEmpty())
			throw new pasDePartieException();
		int somme = parties.stream()
				.map(j -> j.getScore())
				.reduce((x, y) -> x+y).get();
		double res = somme/parties.size() + somme%parties.size();
		return res;
	}

	@Override
	public double calculDureeMoyenne() throws pasDePartieException {
		if(parties.isEmpty())
			throw new pasDePartieException();
				
		return convertitSecondesEnMinutes( parties.stream()
				.map(j -> j.getSeconde())
				.reduce((x, y) -> x+y).
				get() )
				/parties.size();
	}

	@Override
	public double convertitSecondesEnMinutes(int seconde) {
		double res = seconde/60;
		return res;
	}

	@Override
	public void ajouterPartieJoueurDTO(int score, int temps) throws IllegalArgumentException {
		if(0<score || score > 10 || 0<temps)
			throw new IllegalArgumentException("Le score " + score + " ou le temps " + temps + " n'est pas valide");
		parties.add(new PartieJoueurDTO(score, temps));
		
	}

	@Override
	public List<PartieJoueurDTO> partiesJouée() {
		return parties;
	}
	
}
