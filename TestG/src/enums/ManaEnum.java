package enums;

public enum ManaEnum {
	Black, White, Colorless;

	private String code;

	private ManaEnum() {
		this.code = "";
	}

	private ManaEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}