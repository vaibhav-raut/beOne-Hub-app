package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DocTypeEnum {

	@JsonIgnore
	public static final JSONRepo JSONRepo = new JSONRepo<DocTypeEnum>() {
		@Override
		protected Class<DocTypeEnum> objectClass() {
			return DocTypeEnum.class;
		}
	};

	private String enumName;
	private List<DocTypeValue> enumValues;
	
	public DocTypeEnum() {
		enumValues = new ArrayList<DocTypeValue>();
	}
	
	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
	public List<DocTypeValue> getEnumValues() {
		return enumValues;
	}
	public void setEnumValues(List<DocTypeValue> enumValues) {
		this.enumValues = enumValues;
	}
	public void addEnumValue(DocTypeValue enumValue) {
		this.enumValues.add(enumValue);
	}
}
