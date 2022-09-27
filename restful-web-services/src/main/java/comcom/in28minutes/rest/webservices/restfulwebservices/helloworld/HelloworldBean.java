package comcom.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloworldBean {

	private String msg;

	public HelloworldBean(String msg) {
		this.msg=msg;
	}

	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return String.format("helloworldBean [msg=%s]", msg); 
	}

}
