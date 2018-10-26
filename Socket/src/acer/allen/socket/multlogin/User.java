package acer.allen.socket.multlogin;

import java.io.Serializable;

/**
 * �û���
 * 
 * @author acer
 *
 */
public class User implements Serializable {

	/**
	 * ���а汾��
	 */
	private static final long serialVersionUID = 1L;
	// �û���
	private String name;
	// ����
	private String pwd;

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + "]";
	}

}
