package demo;

public class Article {
    private String emailto;
    private String subject;
    private String message;
    private int id;
	public String getEmailto() {
		return emailto;
	}
	public void setEmailto(String emailto) {
		this.emailto = emailto;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Article [emailto=" + emailto + ", subject=" + subject + ", message=" + message + ", id=" + id + "]";
	}
	
    
    
}
