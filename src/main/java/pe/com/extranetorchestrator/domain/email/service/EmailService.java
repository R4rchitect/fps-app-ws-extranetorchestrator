package pe.com.extranetorchestrator.domain.email.service;

import java.io.File;
import java.util.List;

import pe.com.extranetorchestrator.domain.email.model.MessageEmail;
import pe.com.extranetorchestrator.domain.mifarma.arco.model.FormularioArco;

public interface EmailService {

	public void enviarCorreo(MessageEmail messageEmail, List<File> lstFile, FormularioArco formularioArco, Long idSolicitud, String adicionalText);
	
}
