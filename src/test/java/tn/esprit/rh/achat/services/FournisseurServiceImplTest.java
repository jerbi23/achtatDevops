	package tn.esprit.rh.achat.services;
	
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;
	
	import lombok.extern.slf4j.Slf4j;
	//import org.junit.Test;
	import org.junit.jupiter.api.Test;
	import tn.esprit.rh.achat.entities.Fournisseur;
	import tn.esprit.rh.achat.repositories.FournisseurRepository;
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotNull;
	
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;
	
	
	
	import java.util.Optional;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;
	
	@Slf4j
	@ExtendWith(MockitoExtension.class)
	public class FournisseurServiceImplTest {
	
		
		@Mock
		FournisseurRepository fournisseurRepository;
	
		@InjectMocks
		FournisseurServiceImpl fournisseurService;
		
		
	    private Fournisseur fournisseur1 = new Fournisseur(1L,"fournisseur Mock1", "aaaaa", null,null,null,null);
	    private Fournisseur fournisseur2 = new Fournisseur(1L,"fournisseur Mock2", "bbbbb", null,null,null,null);
	
	   
	    @Test
	    public void MockAddFournisseur() {
	        when(fournisseurRepository.save(fournisseur1)).thenReturn(fournisseur1);
	        assertNotNull(fournisseur1);
	        assertEquals(fournisseur1, fournisseurService.addFournisseur(fournisseur1));
	        log.info("add works !!");
	    }
	    @Test
	    public void TestRetrieveAllFournisseurs() {
	        when(fournisseurRepository.findAll()).thenReturn(Stream
	                .of(fournisseur1,fournisseur2)
	                .collect(Collectors.toList()));
	        assertEquals(2,fournisseurService.retrieveAllFournisseurs().size());
	        log.info("Retrieve fournisseurs works !");
	    }
	    @Test
	    public void TestDeleteFournisseur() {
	        fournisseurRepository.save(fournisseur1);
	        fournisseurService.deleteFournisseur(fournisseur1.getIdFournisseur());
	        verify(fournisseurRepository, times(1)).deleteById(fournisseur1.getIdFournisseur());
	        log.info("Delete works !");
	    }
	  /*  @Test
	    public void TestUpdateFournisseur() {
	        when(fournisseurRepository.save(fournisseur1)).thenReturn(fournisseur1);
	        assertNotNull(fournisseur1);
	        assertEquals(fournisseur1, fournisseurService.updateFournisseur(fournisseur1));
	        log.info("Update works !!");
	    }*/
	    @Test
	    public void TestRetrieveFournisseur() {
	        when(fournisseurRepository.findById(fournisseur1.getIdFournisseur())).thenReturn(Optional.of(fournisseur1));
	        assertEquals(fournisseur1, fournisseurService.retrieveFournisseur(fournisseur1.getIdFournisseur()));
	        log.info("Retrieve works !!");
	    }
		
	}