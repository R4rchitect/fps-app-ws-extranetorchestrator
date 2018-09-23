package pe.com.extranetorchestrator.interfaces.arco.facade.internal;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.com.extranetorchestrator.application.ArcoService;
import pe.com.extranetorchestrator.interfaces.arco.facade.ArcoServiceFacade;
import pe.com.extranetorchestrator.interfaces.arco.facade.internal.assembler.InsertarFormularioAssembler;

@Service
public class ArcoServiceFacadeImpl implements ArcoServiceFacade {

	private final ArcoService arcoService;
	
    public ArcoServiceFacadeImpl(final ArcoService arcoService) {
		this.arcoService = arcoService;
	}
	
	@Override
	public void insertarFormulario(MultipartFile titu_archivo, String titu_nombre,
								   String titu_apellidos, String titu_domicilio,
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
									MultipartFile adicional_archivoAdjunto) {
		
		final InsertarFormularioAssembler insertarFormularioAssembler = new InsertarFormularioAssembler();
		arcoService.guardarFormularioArco(insertarFormularioAssembler.fromDTO(titu_archivo,
																			titu_nombre,
																			titu_apellidos,
																			titu_domicilio,
																			titu_email,
																			titu_numdoc,
																			titu_tipdoc,
																			titu_tipoSolicitud,
																			checkedRepre,
																			repre_nombres,
																			repre_apellidos,
																			repre_tipdoc,
																			repre_numdoc,
																			repre_archivoAdjunto,
																			repre_archivoAcrediteAdjunto,
																			adicional_text,
																			adicional_archivoAdjunto));
		
		
	}

}
