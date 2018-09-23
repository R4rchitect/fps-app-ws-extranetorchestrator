package pe.com.extranetorchestrator.application.impl;

import pe.com.extranetorchestrator.application.ArcoService;
import pe.com.extranetorchestrator.application.EmailService;
import pe.com.extranetorchestrator.domain.model.arco.FormularioArco;

public class ArcoServiceImpl implements ArcoService {

	private final EmailService emailService;
	
	public ArcoServiceImpl(final EmailService emailService) {
		this.emailService = emailService;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void guardarFormularioArco(FormularioArco formularioArco) {
		
		
	}

}
