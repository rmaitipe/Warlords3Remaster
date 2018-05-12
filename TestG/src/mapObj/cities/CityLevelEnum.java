package mapObj.cities;

public enum CityLevelEnum {
	
	Village,
	Castle,
	Citadel;

	private String code;
	
	private CityLevelEnum() {
		this.code = "";
	}
	
	private CityLevelEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

}
