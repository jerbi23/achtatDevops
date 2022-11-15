package tn.esprit.rh.achat.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Fournisseur;


//@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class FournisseurServiceImplTest2 {

	@Autowired
	IFournisseurService iFournisseurService;
	

	
	@Test
	public void testAddFournisseur() {

		List<Fournisseur> fournisseurs = iFournisseurService.retrieveAllFournisseurs();
		int expected=fournisseurs.size();
		Fournisseur s = new Fournisseur();

		s.setLibelle("aaaa");
		s.setCode("bbb");
		Fournisseur savedFournisseur= iFournisseurService.addFournisseur(s);
		assertEquals(expected+1, iFournisseurService.retrieveAllFournisseurs().size());
		assertNotNull(savedFournisseur.getLibelle());


	} 
	
	
	@Test
	public void testDeleteFournisseur()
	{
		iFournisseurService.deleteFournisseur(7L);
		assertNull(iFournisseurService.retrieveFournisseur(7L));
	}
	

	@Test
	public void testRetrieveAllFournisseurs()
	{
		List<Fournisseur> fournisseurs = iFournisseurService.retrieveAllFournisseurs();
		assertEquals(4,fournisseurs.size());
	}
	

	@Test
	public void testRetrieveFournisseur()
	{
		Fournisseur fournisseur = iFournisseurService.retrieveFournisseur(6L);
		assertEquals(6L,fournisseur.getIdFournisseur().longValue());
		
	}
	
	
	@Test
	public void testUpdateFournisseur()
	{
		Fournisseur s = new Fournisseur();
		s.setIdFournisseur(1L);
		s.setLibelle("aaaa");
		s.setCode("bbb");
		Fournisseur updatedFournisseur=iFournisseurService.updateFournisseur(s);
		assertEquals(s.getLibelle(),updatedFournisseur.getLibelle());
	}
	
	
	
	
	



	
	

	
	

}