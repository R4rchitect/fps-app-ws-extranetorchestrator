package pe.com.extranetorchestrator.domain.email.model;

import java.util.List;

public class MessageEmail {

	private String emisor;
	private List<String> destinarios;
	private String asunto;
	private String cuerpo;
	
	public MessageEmail(String emisor, List<String> destinarios, String asunto, String cuerpo) {
		super();
		this.emisor = emisor;
		this.destinarios = destinarios;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}
	
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public List<String> getDestinarios() {
		return destinarios;
	}
	public void setDestinarios(List<String> destinarios) {
		this.destinarios = destinarios;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
}
