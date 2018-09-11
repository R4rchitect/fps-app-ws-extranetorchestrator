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
  public ResponseEntity<String> insertform(@RequestParam("file") MultipartFile file,
		  								   @RequestParam("titu_nombre") String titu_nombre) {

	String message = "";
	try {
		message = "You successfully uploaded " + file.getOriginalFilename() + "!";
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	} catch (Exception e) {
		message = "FAIL to upload " + file.getOriginalFilename() + "!";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	}
  }
  
  @ResponseBody
  @GetMapping("/hi")
  public String hi() {

	return "hi";
	
  }
  
}
