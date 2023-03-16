package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock.ServiceJoueurMockInfoEronnee;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock.ServiceJoueurMockInfoManquante;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock.ServiceJoueurMockOk;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock.ServiceJoueurMockPseudoExistant;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.absentDeListeException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.fausseAnneeNaissanceException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.infoManquanteException;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.modele.pseudoExistantException;

class ServiceJoueurTest {

	ServiceJoueurMockOk serviceJoueurMockOk;
	ServiceJoueurMockInfoManquante infoManquante;
	ServiceJoueurMockPseudoExistant pseudoExistant;
	ServiceJoueurMockInfoEronnee infoEronnee;
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		serviceJoueurMockOk = new ServiceJoueurMockOk();
		infoManquante = new ServiceJoueurMockInfoManquante();
		pseudoExistant = new ServiceJoueurMockPseudoExistant();
		infoEronnee = new ServiceJoueurMockInfoEronnee();
		System.out.println("Appel du test " + testInfo.getDisplayName());
		
	}

	@Test
	void testAjouterJoueur() {
		//tout va bien
		JoueurDTO joueurAttendu = serviceJoueurMockOk.ajouterJoueur("toto", "Kevin95", 2006, "hacking");
		assertEquals(joueurAttendu, serviceJoueurMockOk.ajouterJoueur("toto", "Kevin95", 2006, "hacking"));
		//Info manquante
		assertThrows(infoManquanteException.class, (()-> infoManquante.ajouterJoueur(null, null, 0, null)));
		//lorqu'un pseudo est déja présent
		assertThrows(pseudoExistantException.class, ( () -> pseudoExistant.ajouterJoueur(null, null, 0, null)));
		//info eronnée
		assertThrows(fausseAnneeNaissanceException.class, ( () -> infoEronnee.ajouterJoueur(null, null, 0, null)));
	}
	@Test
	void testSupprimerJoueur() {
		//lorsque tout va bien rien n'est renvoye
		
		//lorque le pseudo est null vide ou blanc
		assertThrows(infoManquanteException.class, (()-> infoManquante.supprimerJoueur(null)));
		
		//quand le pseudo existe déja rien est renvoyé
		
		//quand le pseudo entre n'est pas présent
		assertThrows(absentDeListeException.class, ( () -> infoEronnee.supprimerJoueur(null)));
	}
	

}
