/**
 * 2017年10月27日
 */
package net.kingfore.model;

import java.util.List;

/**
 * 公共请求参数
 * 
 * @author JF_Hao
 *
 */
public class CommonRequest {

	private String stationNo;

	private List<Object> data;

	public CommonRequest(String stationNo, List<Object> data) {
		super();
		this.stationNo = stationNo;
		this.data = data;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

}
