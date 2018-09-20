package pe.com.extranetorchestrator.interfaces.arco.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pe.com.extranetorchestrator.domain.email.model.MessageEmail;
import pe.com.extranetorchestrator.domain.email.service.EmailService;
import pe.com.extranetorchestrator.domain.mifarma.arco.model.ArchivoAdjunto;
import pe.com.extranetorchestrator.domain.mifarma.arco.model.FormularioArco;
import pe.com.extranetorchestrator.domain.mifarma.arco.repository.ArchivoAdjuntoRepository;
import pe.com.extranetorchestrator.domain.mifarma.arco.repository.FormularioArcoRepository;
import pe.com.extranetorchestrator.domain.mifarma.arco.service.UploadFileService;

@Controller
@RequestMapping(value = "/mifarma/arco")
public class ArcoController {

  @Autowired
  private UploadFileService uploadFileService;
  
  @Autowired
  private EmailService emailService;
	
  @Autowired
  private FormularioArcoRepository formularioArcoRepository;
  
  @Autowired
  private ArchivoAdjuntoRepository archivoAdjuntoRepository;
  
  @PostMapping("/insertform")
  public ResponseEntity<String> insertform(@RequestParam("titu_archivo") MultipartFile titu_archivo,
		  								   @RequestParam("titu_nombre") String titu_nombre,
		  								   @RequestParam("titu_apellidos") String titu_apellidos,
			  							   @RequestParam("titu_domicilio") String titu_domicilio,
			  							   @RequestParam("titu_email") String titu_email,
			  							   @RequestParam("titu_numdoc") String titu_numdoc,
			  							   @RequestParam("titu_tipdoc") String titu_tipdoc,
			  							   @RequestParam("titu_tipoSolicitud") String titu_tipoSolicitud,
			  							   @RequestParam("checkedRepre") String checkedRepre,
			  							   @RequestParam("repre_nombres") String repre_nombres,
				  						   @RequestParam("repre_apellidos") String repre_apellidos,
			  							   @RequestParam("repre_tipdoc") String repre_tipdoc,
			  							   @RequestParam("repre_numdoc") String repre_numdoc,
			  							   @RequestParam(value="repre_archivoAdjunto", required=false) MultipartFile repre_archivoAdjunto,
			  							   @RequestParam(value="repre_archivoAcrediteAdjunto", required=false) MultipartFile repre_archivoAcrediteAdjunto,
			  							   @RequestParam(value="adicional_text", required=false) String adicional_text,
			  							   @RequestParam(value="adicional_archivoAdjunto", required=false) MultipartFile adicional_archivoAdjunto) {
	  
	String message = "";
	try {
		
        Long max = formularioArcoRepository.getMaxId()+1;
        
		List<File> lstFiles = new ArrayList<File>();
		lstFiles.add(convert(titu_archivo));
        
        FormularioArco formulario = new FormularioArco();
        formulario.setId(max);
        formulario.setName(titu_nombre);
        formulario.setLastname(titu_apellidos);
        formulario.setEmail(titu_email);
        formulario.setDatetime(new Date());
        formulario.setNumber_doc(titu_numdoc);
        formulario.setType_doc(titu_tipdoc);
        formulario.setAddress(titu_domicilio);
        formulario.setTipo_solicitud(titu_tipoSolicitud);
        
        ArchivoAdjunto archivo1 = new ArchivoAdjunto();
        archivo1.setFilename(titu_archivo.getOriginalFilename());
        archivo1.setFiletype(titu_archivo.getOriginalFilename().substring(titu_archivo.getOriginalFilename().lastIndexOf(".")+1));
        archivo1.setIdformulario(max);
        
        if(checkedRepre.equals("true")){
        formulario.setName_rep(repre_nombres);
        formulario.setLastname_rep(repre_apellidos);
        formulario.setNumber_doc_rep(repre_numdoc);
        formulario.setType_doc_rep(repre_tipdoc);
        
        ArchivoAdjunto archivo2 = new ArchivoAdjunto();
        archivo2.setFilename(repre_archivoAdjunto.getOriginalFilename());
        archivo2.setFiletype(repre_archivoAdjunto.getOriginalFilename().substring(repre_archivoAdjunto.getOriginalFilename().lastIndexOf(".")+1));
        archivo2.setIdformulario(max);
        
        ArchivoAdjunto archivo3 = new ArchivoAdjunto();
        archivo3.setFilename(repre_archivoAcrediteAdjunto.getOriginalFilename());
        archivo3.setFiletype(repre_archivoAcrediteAdjunto.getOriginalFilename().substring(repre_archivoAcrediteAdjunto.getOriginalFilename().lastIndexOf(".")+1));
        archivo3.setIdformulario(max);
        lstFiles.add(convert(repre_archivoAdjunto));
        lstFiles.add(convert(repre_archivoAcrediteAdjunto));
        archivoAdjuntoRepository.save(archivo2);
        archivoAdjuntoRepository.save(archivo3);
        }
        
        archivoAdjuntoRepository.save(archivo1);
        formularioArcoRepository.save(formulario);
        if(adicional_archivoAdjunto!=null) {
        lstFiles.add(convert(adicional_archivoAdjunto));	
        }
        
		//uploadFileService.saveFile(titu_archivo);
		System.out.println(" MessageEmail");
		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        MessageEmail messageEmail = new MessageEmail("MiFarma <datospersonales@mifama.com.pe>", Arrays.asList(formulario.getEmail(),"datospersonales@mifama.com.pe"), "Solicitud de derechos ARCO N° 000"+max, "Gracias por su comunicación. Se le informa que su solicitud de derechos ARCO N° 000"+max+" ha sido recibida con Fecha y hora: "+ sm.format(new Date())+" MIFARMA procederá a notificar la respuesta a su solicitud a la dirección de correo electrónico indicado en el presente formulario. El titular de datos personales autoriza y acepta la remisión de las notificaciones referidas a este procedimiento a dicha dirección. Las solicitudes se responderán dentro de los plazos establecidos en el Capítulo I del Título IV del Reglamento de la Ley de Protección de Datos Personales, aprobado por Decreto Supremo No. 003-2013-JUS. Si transcurren los plazos antes indicados sin haber recibido respuesta, usted podrá considerar denegada su solicitud, quedando a salvo su derecho de iniciar un procedimiento de tutela  ante la Dirección General de Protección de Datos Personales (Ministerio de Justicia).  Atentamente. Protección de datos personales. sta información es privada y confidencial y está dirigida únicamente a su destinatario. Si usted no es el destinatario original de este mensaje y por este medio pudo acceder a dicha información por favor elimine el mensaje. La distribución o copia de este mensaje está estrictamente prohibida. Esta comunicación es sólo para propósitos de información y no debe ser considerada como propuesta, aceptación ni como una declaración de voluntad oficial de las empresas que conforman Farmacias Peruanas. Observe por favor que éste correo ha sido creado con conocimiento que el e-mail de Internet no es un medio de comunicación 100% seguro. Aconsejamos entender y observar esta falta de seguridad cuando nos envíe correo. Las empresas que conforman Farmacias Peruanas no están obligadas  a una apropiada y completa transmisión de la información contenida en ésta comunicación ni por cualquier demora en su recibo. Las empresas que conforman Farmacias Peruanas respetan y promueven la libre competencia, por lo que adoptan sus decisiones comerciales de manera independiente. De igual forma, respetan las decisiones de cada cliente, proveedor o competidor en su desarrollo comercial, por lo que rechazan la remisión de información confidencial de titularidad de terceros, la cual será eliminada de forma inmediata por nuestros trabajadores sin posibilidad de revisar o emitir comentario alguno sobre la misma. ");
        emailService.enviarCorreo(messageEmail, lstFiles, formulario, max, adicional_text);
		
		message = "You successfully uploaded " + titu_archivo.getOriginalFilename() + "!";
		
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	} catch (Exception e) {
		System.out.println("Exception: Controller1 "+ e);
		message = "FAIL to upload " + titu_archivo.getOriginalFilename() + "!";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	}
  }
  
  public File convert(MultipartFile file) throws IOException
  {    
      File convFile = new File(file.getOriginalFilename());
      convFile.createNewFile(); 
      FileOutputStream fos = new FileOutputStream(convFile); 
      fos.write(file.getBytes());
      fos.close(); 
      return convFile;
  }
  
  
  @ResponseBody
  @GetMapping("/hi")
  public String hi() {

	return "Hi Human";
	
  }
  
}
