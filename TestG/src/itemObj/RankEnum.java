package itemObj;

public enum RankEnum {
	
	Easy,
	Average,
	Hard;

	private String code;
	
	private RankEnum() {
		this.code = "";
	}
	
	private RankEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

}
