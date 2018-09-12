package pe.com.extranetorchestrator.domain.mifarma.arco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/mifarma/arco")
public class ArcoController {

  @PostMapping("/insertform")
  public ResponseEntity<String> insertform(@RequestParam("titu_archivo") MultipartFile titu_archivo,
		  								   @RequestParam("titu_nombre") String titu_nombre,
		  								   @RequestParam("titu_apellidos") String titu_apellidos,
			  							   @RequestParam("titu_domicilio") String titu_domicilio,
			  							   @RequestParam("titu_email") String titu_email,
			  							   @RequestParam("titu_numdoc") String titu_numdoc,
			  							   @RequestParam("titu_tipdoc") String titu_tipdoc,
			  							   @RequestParam("repre_nombres") String repre_nombres,
				  						   @RequestParam("repre_apellidos") String repre_apellidos,
			  							   @RequestParam("repre_tipdoc") String repre_tipdoc,
			  							   @RequestParam("repre_numdoc") String repre_numdoc,
			  							   @RequestParam("repre_archivoAdjunto") MultipartFile repre_archivoAdjunto,
			  							   @RequestParam("repre_archivoAcrediteAdjunto") MultipartFile repre_archivoAcrediteAdjunto) {
	  
	String message = "";
	try {
		message = "You successfully uploaded " + titu_archivo.getOriginalFilename() + "!";
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	} catch (Exception e) {
		message = "FAIL to upload " + titu_archivo.getOriginalFilename() + "!";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	}
  }
  
  @ResponseBody
  @GetMapping("/hi")
  public String hi() {

	return "hi";
	
  }
  
}
