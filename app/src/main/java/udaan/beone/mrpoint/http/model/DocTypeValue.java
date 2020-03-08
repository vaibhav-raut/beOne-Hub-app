package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DocTypeValue {

	private int docTypeId;
	private String docType;
	private String docFor;
	private String docCategory;
	private String docDesc;
	
	public DocTypeValue() {
	}

	public DocTypeValue(String docType, String docFor, String docCategory,
			String docDesc) {
		super();
		this.docType = docType;
		this.docFor = docFor;
		this.docCategory = docCategory;
		this.docDesc = docDesc;
	}

	public DocTypeValue(int docTypeId, String docType, String docFor,
			String docCategory, String docDesc) {
		super();
		this.docTypeId = docTypeId;
		this.docType = docType;
		this.docFor = docFor;
		this.docCategory = docCategory;
		this.docDesc = docDesc;
	}

	public int getDocTypeId() {
		return docTypeId;
	}

	public void setDocTypeId(int docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocFor() {
		return docFor;
	}

	public void setDocFor(String docFor) {
		this.docFor = docFor;
	}

	public String getDocCategory() {
		return docCategory;
	}

	public void setDocCategory(String docCategory) {
		this.docCategory = docCategory;
	}

	public String getDocDesc() {
		return docDesc;
	}

	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}
	
}
