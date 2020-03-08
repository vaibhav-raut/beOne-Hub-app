package udaan.beone.mrpoint.http.model.s;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import udaan.beone.mrpoint.http.model.JSONRepo;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MrVisitS {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MrVisitS>() {
		@Override
		protected Class<MrVisitS> objectClass() {
			return MrVisitS.class;
		}
	};

	private long mrVisitId;
	private long ownerAcNo;
	private long authAcNo;
	private String visitStatus;
	private String visitType;
	private String location;
	private String description;

	public long getMrVisitId() {
		return mrVisitId;
	}

	public void setMrVisitId(long mrVisitId) {
		this.mrVisitId = mrVisitId;
	}

	public long getOwnerAcNo() {
		return ownerAcNo;
	}

	public void setOwnerAcNo(long ownerAcNo) {
		this.ownerAcNo = ownerAcNo;
	}

	public long getAuthAcNo() {
		return authAcNo;
	}

	public void setAuthAcNo(long authAcNo) {
		this.authAcNo = authAcNo;
	}

	public String getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
