package pe.com.extranetorchestrator.infrastructure.persistence.jpa;

import org.springframework.stereotype.Repository;

import pe.com.extranetorchestrator.domain.model.arco.FormularioArcoRepository;
import pe.com.extranetorchestrator.infrastructure.persistence.jpa.arco.entity.FormularioArcoEntity;

@Repository
public class FormularioArcoRepositoryJpa {
	
	private final FormularioArcoRepository formularioArcoRepository;
	
	public FormularioArcoRepositoryJpa(final FormularioArcoRepository formularioArcoRepository) {
		this.formularioArcoRepository = formularioArcoRepository;
	}
	
	public Long getMaximoId() {
		
		return formularioArcoRepository.getMaxId();
		
	}
	
	public void guardarFormulario(FormularioArcoEntity formularioArcoEntity) {
		
		formularioArcoRepository.save(formularioArcoEntity);
		
	}
	

}
