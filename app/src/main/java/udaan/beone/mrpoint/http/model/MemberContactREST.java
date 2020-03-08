package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MemberContactREST {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<MemberContactREST>() {
		@Override
		protected Class<MemberContactREST> objectClass() {
			return MemberContactREST.class;
		}
	};

	private long contactId;
	private String lang;
	private String nameTitle;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String village;
	private String grampanchayat;
	private String taluka;
	private String pinCode;
	private String district;
	private int districtId;
	private String districtCode;
	private String division;
	private String state;
	private String phone;
	private String priMobile;
	private String secMobile;
	private String email;
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getNameTitle() {
		return nameTitle;
	}
	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getGrampanchayat() {
		return grampanchayat;
	}
	public void setGrampanchayat(String grampanchayat) {
		this.grampanchayat = grampanchayat;
	}
	public String getTaluka() {
		return taluka;
	}
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPriMobile() {
		return priMobile;
	}
	public void setPriMobile(String priMobile) {
		this.priMobile = priMobile;
	}
	public String getSecMobile() {
		return secMobile;
	}
	public void setSecMobile(String secMobile) {
		this.secMobile = secMobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
