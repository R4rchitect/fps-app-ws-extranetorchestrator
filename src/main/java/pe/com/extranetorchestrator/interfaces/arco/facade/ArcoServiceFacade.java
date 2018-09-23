package pe.com.extranetorchestrator.interfaces.arco.facade;

import org.springframework.web.multipart.MultipartFile;

public interface ArcoServiceFacade {

	public void insertarFormulario(MultipartFile titu_archivo,
									 String titu_nombre,
									 String titu_apellidos,
									 String titu_domicilio,
									 String titu_email,
									 String titu_numdoc,
									 String titu_tipdoc,
									 String titu_tipoSolicitud,
									 String checkedRepre,
									 String repre_nombres,
								     String repre_apellidos,
									 String repre_tipdoc,
									 String repre_numdoc,
									 MultipartFile repre_archivoAdjunto,
								     MultipartFile repre_archivoAcrediteAdjunto,
									 String adicional_text,
									 MultipartFile adicional_archivoAdjunto); 
	
}
