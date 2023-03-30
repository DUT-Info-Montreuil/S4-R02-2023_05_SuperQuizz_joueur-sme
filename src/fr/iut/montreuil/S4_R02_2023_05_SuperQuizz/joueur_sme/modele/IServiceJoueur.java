package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele;

import java.util.List;
import java.util.Set;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;

public interface IServiceJoueur {

	public Set<JoueurDTO> listerJoueur();
	public JoueurDTO ajouterJoueur(String prénom, String pseudo, int annéeNaissance, String centresDintérêt) throws pseudoExistantException, infoManquanteException, fausseAnneeNaissanceException;
		//creer succes : renvoie joueur cree
		//exeption pseudoExistant
		//exeption infoManquante(String manquant)
		//exeption fausseAnneeNaissance (si année de naissance < 1900)
	public void supprimerJoueur(String pseudo) throws absentDeListeException, infoManquanteException;
		// exception absent de liste
		// si suppression effectué : 0
		// autre : 1
		//exception infoManquantes

	public double calculMoyennePartie () throws pasDePartieException;
	
	public double calculDureeMoyenne () throws pasDePartieException;
	
	public double convertitSecondesEnMinutes (int seconde);
	
	public void ajouterPartieJoueurDTO (int score, int temps) throws IllegalArgumentException;
	
	public List<PartieJoueurDTO> partiesJouée();

/*  
 * créer un objet PartieJoueurDTO
 *  - int score
 *  - int seconde qu'on convertit si besoin
 *  
 *
 * iServiceJoueur
 * -calculMoyenne des partie () retourne double
 * pasDePartieException
 *
 *  -calcul durée moyenne () retourne double
 *   pasDePartieException
 *  
 *  
 *  -méthode statique qui retourne en minutes si int seconde retourne double
 * pasDePartieException
 *
 *  -ajouterPartieJoueurDTO(int score, int temp) void
 *   illegalArgumentException(String s)
 *  
 *  -getter partie jouée () retourne List<PartieDTO>
 *  
 * ServiceJoueurImpl
 *  -List<PartieDTO> parties
 *  
 *   -méthodes implemente
 *  
 *
 *
 *
 */
}