package pe.com.extranetorchestrator.application;

import pe.com.extranetorchestrator.domain.model.arco.FormularioArco;

public interface EmailService {

	public void enviarCorreo(FormularioArco formularioArco);
	
}
