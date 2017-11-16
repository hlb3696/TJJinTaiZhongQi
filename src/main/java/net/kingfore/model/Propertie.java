/**
 * 2017年10月12日
 */
package net.kingfore.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
public class Propertie {

	@Value("${realExcelFilePath}")
	private String realExcelFilePath;

	@Value("${jkIP}")
	private String jkIP;

	@Value("${jkPort}")
	private int jkPort;

	@Value("${Zoomkey_Auth_Token}")
	private String Zoomkey_Auth_Token;

	@Value("${j_username}")
	private String j_username;

	@Value("${j_password}")
	private String j_password;

	public String getRealExcelFilePath() {
		return realExcelFilePath;
	}

	public void setRealExcelFilePath(String realExcelFilePath) {
		this.realExcelFilePath = realExcelFilePath;
	}

	public String getJkIP() {
		return jkIP;
	}

	public void setJkIP(String jkIP) {
		this.jkIP = jkIP;
	}

	public int getJkPort() {
		return jkPort;
	}

	public void setJkPort(int jkPort) {
		this.jkPort = jkPort;
	}

	public String getZoomkey_Auth_Token() {
		return Zoomkey_Auth_Token;
	}

	public void setZoomkey_Auth_Token(String zoomkey_Auth_Token) {
		Zoomkey_Auth_Token = zoomkey_Auth_Token;
	}

	public String getJ_username() {
		return j_username;
	}

	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}

	public String getJ_password() {
		return j_password;
	}

	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

	public Propertie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Propertie(String realExcelFilePath, String jkIP, int jkPort, String zoomkey_Auth_Token, String j_username,
			String j_password) {
		super();
		this.realExcelFilePath = realExcelFilePath;
		this.jkIP = jkIP;
		this.jkPort = jkPort;
		Zoomkey_Auth_Token = zoomkey_Auth_Token;
		this.j_username = j_username;
		this.j_password = j_password;
	}

	@Override
	public String toString() {
		return "Propertie [realExcelFilePath=" + realExcelFilePath + ", jkIP=" + jkIP + ", jkPort=" + jkPort
				+ ", Zoomkey_Auth_Token=" + Zoomkey_Auth_Token + ", j_username=" + j_username + ", j_password="
				+ j_password + "]";
	}

}
