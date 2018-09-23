package pe.com.extranetorchestrator.application;

import java.io.File;
import java.util.List;

import pe.com.extranetorchestrator.domain.model.arco.FormularioArco;
import pe.com.extranetorchestrator.domain.model.email.MessageEmail;

public interface EmailService {

	public void enviarCorreo(MessageEmail messageEmail, List<File> lstFile, FormularioArco formularioArco, Long idSolicitud, String adicionalText);
	
}
