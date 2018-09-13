package pe.com.extranetorchestrator.domain.email.service;

import java.io.File;
import java.util.List;

import pe.com.extranetorchestrator.domain.email.model.MessageEmail;

public interface EmailService {

	public void enviarCorreo(MessageEmail messageEmail, List<File> lstFile);
	
}
