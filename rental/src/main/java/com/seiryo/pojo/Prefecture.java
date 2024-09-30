package com.seiryo.pojo;
/**
 * エンティティクラス：都道府県
 */
public class Prefecture {
	private String preCd;
	private String preName;
	public String getPreCd() {
		return preCd;
	}
	public void setPreCd(String preCd) {
		this.preCd = preCd;
	}
	public String getPreName() {
		return preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public Prefecture(String preCd, String preName) {
		super();
		this.preCd = preCd;
		this.preName = preName;
	}
	public Prefecture() {
		super();
	}
	@Override
	public String toString() {
		return "Prefecture [preCd=" + preCd + ", preName=" + preName + "]";
	}
	
}
