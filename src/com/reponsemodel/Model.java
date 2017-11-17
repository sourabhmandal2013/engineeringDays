package com.reponsemodel;

public class Model {

	private String url;
	private String variables;
	private String id_type;
	private String extendeddata;
	private String header;
	private String merchantId;
	private String expected_phone;
	private String status;
	private String expected_accountNumber;
	private String expected_realmId;
	private String expected_legalname;
	private String expected_businessName;
	
	
	private String expected_status;
	
	public String getExpected_accountNumber() {
		return expected_accountNumber;
	}
	public void setExpected_accountNumber(String expected_accountNumber) {
		this.expected_accountNumber = expected_accountNumber;
	}
	public String getExpected_realmId() {
		return expected_realmId;
	}
	public void setExpected_realmId(String expected_realmId) {
		this.expected_realmId = expected_realmId;
	}
	public String getExpected_status() {
		return expected_status;
	}
	public void setExpected_status(String expected_status) {
		this.expected_status = expected_status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getVariables() {
		return variables;
	}
	public void setVariables(String variables) {
		this.variables = variables;
	}
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getExtendeddata() {
		return extendeddata;
	}
	public void setExtendeddata(String extendeddata) {
		this.extendeddata = extendeddata;
	}
	public String getExpected_legalname() {
		return expected_legalname;
	}
	public void setExpected_legalname(String expected_legalname) {
		this.expected_legalname = expected_legalname;
	}
	public String getExpected_businessName() {
		return expected_businessName;
	}
	public void setExpected_businessName(String expected_businessName) {
		this.expected_businessName = expected_businessName;
	}
	public String getExpected_phone() {
		return expected_phone;
	}
	public void setExpected_phone(String expected_phone) {
		this.expected_phone = expected_phone;
	}
	
	
}
