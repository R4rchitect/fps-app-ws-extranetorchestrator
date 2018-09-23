package pe.com.extranetorchestrator.interfaces.arco.web.command;

import org.springframework.web.multipart.MultipartFile;

public class FormularioArcoCommand {
	
	private MultipartFile titu_archivo;
	private String titu_nombre;
	private String titu_apellidos;
	private String titu_domicilio;
	private String titu_email;
	private String titu_numdoc;
	private String titu_tipdoc;
	private String titu_tipoSolicitud;
	private String checkedRepre;
	private String repre_nombres;
    private String repre_apellidos;
	private String repre_tipdoc;
	private String repre_numdoc;
	private MultipartFile repre_archivoAdjunto;
    private MultipartFile repre_archivoAcrediteAdjunto;
	private String adicional_text;
	private MultipartFile adicional_archivoAdjunto;
	
	public FormularioArcoCommand() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MultipartFile getTitu_archivo() {
		return titu_archivo;
	}
	public void setTitu_archivo(MultipartFile titu_archivo) {
		this.titu_archivo = titu_archivo;
	}
	public String getTitu_nombre() {
		return titu_nombre;
	}
	public void setTitu_nombre(String titu_nombre) {
		this.titu_nombre = titu_nombre;
	}
	public String getTitu_apellidos() {
		return titu_apellidos;
	}
	public void setTitu_apellidos(String titu_apellidos) {
		this.titu_apellidos = titu_apellidos;
	}
	public String getTitu_domicilio() {
		return titu_domicilio;
	}
	public void setTitu_domicilio(String titu_domicilio) {
		this.titu_domicilio = titu_domicilio;
	}
	public String getTitu_email() {
		return titu_email;
	}
	public void setTitu_email(String titu_email) {
		this.titu_email = titu_email;
	}
	public String getTitu_numdoc() {
		return titu_numdoc;
	}
	public void setTitu_numdoc(String titu_numdoc) {
		this.titu_numdoc = titu_numdoc;
	}
	public String getTitu_tipdoc() {
		return titu_tipdoc;
	}
	public void setTitu_tipdoc(String titu_tipdoc) {
		this.titu_tipdoc = titu_tipdoc;
	}
	public String getTitu_tipoSolicitud() {
		return titu_tipoSolicitud;
	}
	public void setTitu_tipoSolicitud(String titu_tipoSolicitud) {
		this.titu_tipoSolicitud = titu_tipoSolicitud;
	}
	public String getCheckedRepre() {
		return checkedRepre;
	}
	public void setCheckedRepre(String checkedRepre) {
		this.checkedRepre = checkedRepre;
	}
	public String getRepre_nombres() {
		return repre_nombres;
	}
	public void setRepre_nombres(String repre_nombres) {
		this.repre_nombres = repre_nombres;
	}
	public String getRepre_apellidos() {
		return repre_apellidos;
	}
	public void setRepre_apellidos(String repre_apellidos) {
		this.repre_apellidos = repre_apellidos;
	}
	public String getRepre_tipdoc() {
		return repre_tipdoc;
	}
	public void setRepre_tipdoc(String repre_tipdoc) {
		this.repre_tipdoc = repre_tipdoc;
	}
	public String getRepre_numdoc() {
		return repre_numdoc;
	}
	public void setRepre_numdoc(String repre_numdoc) {
		this.repre_numdoc = repre_numdoc;
	}
	public MultipartFile getRepre_archivoAdjunto() {
		return repre_archivoAdjunto;
	}
	public void setRepre_archivoAdjunto(MultipartFile repre_archivoAdjunto) {
		this.repre_archivoAdjunto = repre_archivoAdjunto;
	}
	public MultipartFile getRepre_archivoAcrediteAdjunto() {
		return repre_archivoAcrediteAdjunto;
	}
	public void setRepre_archivoAcrediteAdjunto(MultipartFile repre_archivoAcrediteAdjunto) {
		this.repre_archivoAcrediteAdjunto = repre_archivoAcrediteAdjunto;
	}
	public String getAdicional_text() {
		return adicional_text;
	}
	public void setAdicional_text(String adicional_text) {
		this.adicional_text = adicional_text;
	}
	public MultipartFile getAdicional_archivoAdjunto() {
		return adicional_archivoAdjunto;
	}
	public void setAdicional_archivoAdjunto(MultipartFile adicional_archivoAdjunto) {
		this.adicional_archivoAdjunto = adicional_archivoAdjunto;
	}
	
}
