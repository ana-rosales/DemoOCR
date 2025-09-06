package saif.casetas.demoOcr.classes;

public class MarcaEconomica {
	private int cve_me, status;
	private String me_name;
	
	public MarcaEconomica() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCve_Me() {
		return this.cve_me;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setCve_Me(int cve_me) {
		this.cve_me = cve_me;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMe_name() {
		return this.me_name;
	}
	
	public void setMe_Name(String me_name) {
		this.me_name = me_name;
	}
}
