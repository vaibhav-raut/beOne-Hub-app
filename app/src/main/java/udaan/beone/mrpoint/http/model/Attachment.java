package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Attachment {

	@JsonIgnore
	public static JSONRepo JSONRepo = new JSONRepo<Attachment>() {
		@Override
		protected Class<Attachment> objectClass() {
			return Attachment.class;
		}
	};

	private long docId;
	private DocTypeValue docType;
	private String fileName;
	public Attachment(long docId, DocTypeValue docType, String fileName) {
		super();
		this.docId = docId;
		this.docType = docType;
		this.fileName = fileName;
	}
	public long getDocId() {
		return docId;
	}
	public void setDocId(long docId) {
		this.docId = docId;
	}
	public DocTypeValue getDocType() {
		return docType;
	}
	public void setDocType(DocTypeValue docType) {
		this.docType = docType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
