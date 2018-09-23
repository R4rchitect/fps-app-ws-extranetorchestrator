package pe.com.extranetorchestrator.interfaces.arco.facade.dto;

import org.springframework.web.multipart.MultipartFile;

public class FormularioArcoDTO {
	
	private MultipartFile tituArchivo;
	private String tituNombre;
	private String tituApellidos;
	private String tituDomicilio;
	private String tituEmail;
	private String tituNumdoc;
	private String tituTipdoc;
	private String tituTipoSolicitud;
	private String checkedRepre;
	private String repreNombres;
    private String repreApellidos;
	private String repreTipdoc;
	private String repreNumdoc;
	private MultipartFile repreArchivoAdjunto;
    private MultipartFile repreArchivoAcrediteAdjunto;
	private String adicionalText;
	private MultipartFile adicionalArchivoAdjunto;
	
	public FormularioArcoDTO() {
		// TODO Auto-generated constructor stub
	}

	public MultipartFile getTituArchivo() {
		return tituArchivo;
	}

	public void setTituArchivo(MultipartFile tituArchivo) {
		this.tituArchivo = tituArchivo;
	}

	public String getTituNombre() {
		return tituNombre;
	}

	public void setTituNombre(String tituNombre) {
		this.tituNombre = tituNombre;
	}

	public String getTituApellidos() {
		return tituApellidos;
	}

	public void setTituApellidos(String tituApellidos) {
		this.tituApellidos = tituApellidos;
	}

	public String getTituDomicilio() {
		return tituDomicilio;
	}

	public void setTituDomicilio(String tituDomicilio) {
		this.tituDomicilio = tituDomicilio;
	}

	public String getTituEmail() {
		return tituEmail;
	}

	public void setTituEmail(String tituEmail) {
		this.tituEmail = tituEmail;
	}

	public String getTituNumdoc() {
		return tituNumdoc;
	}

	public void setTituNumdoc(String tituNumdoc) {
		this.tituNumdoc = tituNumdoc;
	}

	public String getTituTipdoc() {
		return tituTipdoc;
	}

	public void setTituTipdoc(String tituTipdoc) {
		this.tituTipdoc = tituTipdoc;
	}

	public String getTituTipoSolicitud() {
		return tituTipoSolicitud;
	}

	public void setTituTipoSolicitud(String tituTipoSolicitud) {
		this.tituTipoSolicitud = tituTipoSolicitud;
	}

	public String getCheckedRepre() {
		return checkedRepre;
	}

	public void setCheckedRepre(String checkedRepre) {
		this.checkedRepre = checkedRepre;
	}

	public String getRepreNombres() {
		return repreNombres;
	}

	public void setRepreNombres(String repreNombres) {
		this.repreNombres = repreNombres;
	}

	public String getRepreApellidos() {
		return repreApellidos;
	}

	public void setRepreApellidos(String repreApellidos) {
		this.repreApellidos = repreApellidos;
	}

	public String getRepreTipdoc() {
		return repreTipdoc;
	}

	public void setRepreTipdoc(String repreTipdoc) {
		this.repreTipdoc = repreTipdoc;
	}

	public String getRepreNumdoc() {
		return repreNumdoc;
	}

	public void setRepreNumdoc(String repreNumdoc) {
		this.repreNumdoc = repreNumdoc;
	}

	public MultipartFile getRepreArchivoAdjunto() {
		return repreArchivoAdjunto;
	}

	public void setRepreArchivoAdjunto(MultipartFile repreArchivoAdjunto) {
		this.repreArchivoAdjunto = repreArchivoAdjunto;
	}

	public MultipartFile getRepreArchivoAcrediteAdjunto() {
		return repreArchivoAcrediteAdjunto;
	}

	public void setRepreArchivoAcrediteAdjunto(MultipartFile repreArchivoAcrediteAdjunto) {
		this.repreArchivoAcrediteAdjunto = repreArchivoAcrediteAdjunto;
	}

	public String getAdicionalText() {
		return adicionalText;
	}

	public void setAdicionalText(String adicionalText) {
		this.adicionalText = adicionalText;
	}

	public MultipartFile getAdicionalArchivoAdjunto() {
		return adicionalArchivoAdjunto;
	}

	public void setAdicionalArchivoAdjunto(MultipartFile adicionalArchivoAdjunto) {
		this.adicionalArchivoAdjunto = adicionalArchivoAdjunto;
	}
	
	
}
