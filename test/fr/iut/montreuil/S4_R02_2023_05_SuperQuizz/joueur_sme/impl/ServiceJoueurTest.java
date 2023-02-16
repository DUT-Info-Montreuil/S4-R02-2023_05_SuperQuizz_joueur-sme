package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueur.Mock.ServiceJoueurMockOk;

class ServiceJoueurTest {

	ServiceJoueurMockOk serviceJoueurMockOk;
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		serviceJoueurMockOk = new ServiceJoueurMockOk();
		
		System.out.println("Appel du test " + testInfo.getDisplayName());
	}

	@Test
	void testAjouterJoueur() {
		JoueurDTO joueurAttendu = serviceJoueurMockOk.ajouterJoueur("toto", "Kevin95", 2006, "hacking");
		assertEquals(joueurAttendu, serviceJoueurMockOk.ajouterJoueur("toto", "Kevin95", 2006, "hacking"));
	}
	@Test
	void testSupprimerJoueur() {
		
	}
	

}
