package pe.com.extranetorchestrator.domain.email.service.impl;

import static com.itextpdf.text.pdf.BaseFont.EMBEDDED;
import static com.itextpdf.text.pdf.BaseFont.IDENTITY_H;
import static org.thymeleaf.templatemode.TemplateMode.HTML;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import pe.com.extranetorchestrator.domain.email.model.MessageEmail;
import pe.com.extranetorchestrator.domain.email.service.EmailService;
import pe.com.extranetorchestrator.domain.mifarma.arco.model.DataCorreoTemplate;
import pe.com.extranetorchestrator.domain.mifarma.arco.model.FormularioArco;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
    private static final String OUTPUT_FILE = "test.pdf";
    private static final String UTF_8 = "UTF-8";
	
	@Override
	public void enviarCorreo(MessageEmail messageEmail, List<File> lstFile, FormularioArco formularioArco, Long idSolicitud, String adicionalText) {
		
	 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	 
	 MimeMessage message = javaMailSender.createMimeMessage();
     try {
    	 System.out.println("in enviarCorreo");
	     MimeMessageHelper helper = new MimeMessageHelper(message, true);
	
	     helper.setSubject(messageEmail.getAsunto());
	     helper.setText(messageEmail.getCuerpo());
	     helper.setTo(messageEmail.getDestinarios().toArray(new String[messageEmail.getDestinarios().size()]));
	     helper.setFrom(messageEmail.getEmisor());

		     for(File file: lstFile) {
		    	 FileSystemResource filesys = new FileSystemResource(file);
		         helper.addAttachment(filesys.getFilename(), filesys); 
		     }
		     
		     try {
		    	 System.out.println("int: 3");
		     FileSystemResource filesys = new FileSystemResource(generatePdf(formularioArco, idSolicitud, adicionalText));
	         helper.addAttachment(filesys.getFilename(), filesys); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Exception: 3"+ e);
					e.printStackTrace();
				}
	         
	         
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Exception: 2"+ e);
		}
      
     System.out.println("Enviando correo.");
	 javaMailSender.send(message);
	 System.out.println("Se envio");
	}
	
    public File generatePdf(FormularioArco formularioArco,Long idSolicitud, String adicionalText) throws Exception {

    	String nrSolicitud = "000"+idSolicitud;
        String OUTPUT_FILE = nrSolicitud+".pdf";
    	
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DataCorreoTemplate data = new DataCorreoTemplate();
        data.setFecha(sm.format(new Date()));
        data.setNroSolicitud(nrSolicitud);
        data.setTitu_nombres(formularioArco.getName());
        data.setTitu_apellidos(formularioArco.getLastname());
        data.setTitu_tipodoc(formularioArco.getType_doc());
        data.setTitu_numdoc(formularioArco.getNumber_doc());
        data.setTitu_email(formularioArco.getEmail());
        data.setTitu_domicilio(formularioArco.getAddress());
        
        data.setRepre_nombres(formularioArco.getName_rep());
        data.setRepre_apellidos(formularioArco.getLastname_rep());
        data.setRepre_tipodoc(formularioArco.getType_doc_rep());
        data.setRepre_numdoc(formularioArco.getNumber_doc_rep());
        
        data.setTextArea(adicionalText);
        
        if(formularioArco.getTipo_solicitud().equals("ACCESO")) data.setTipoacceso("X");
        if(formularioArco.getTipo_solicitud().equals("RECTIFICACION")) data.setTiporectificacion("X");
        if(formularioArco.getTipo_solicitud().equals("CANCELACION")) data.setTipocancelacion("X");
        if(formularioArco.getTipo_solicitud().equals("OPOSICION")) data.setTipoposicion("X");
        
        Context context = new Context();
        context.setVariable("data", data);
        
													        /*
													             private Date fecha;
														private String nroSolicitud;
														private String titu_nombres;
														private String titu_apellidos;
														private String titu_tipodoc;
														private String titu_numdoc;
														private String titu_email;
														private String titu_domicilio;
														
														private String repre_nombres;
													    private String repre_apellidos;
													    private String repre_tipodoc;
													    private String repre_numdoc;
													    
													    private String tipoacceso;
													    private String tiporectificacion;
													    private String tipocancelacion;
													    private String tipoposicion;
													         * */

        String renderedHtmlContent = templateEngine.process("templateFormulario", context);
        String xHtml = convertToXhtml(renderedHtmlContent);

        ITextRenderer renderer = new ITextRenderer();
        renderer.getFontResolver().addFont("Code39.ttf", IDENTITY_H, EMBEDDED);

        String baseUrl = FileSystems
                                .getDefault()
                                .getPath("src", "main", "resources")
                                .toUri()
                                .toURL()
                                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();

        OutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
        renderer.createPDF(outputStream);
        outputStream.close();
        return new File(OUTPUT_FILE);
    }

    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }

}
