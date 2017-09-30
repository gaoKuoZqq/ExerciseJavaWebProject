package com.studentManagement_class;

public class Banji {
	private Integer banjiId = 0;
	private String banjiName = "未命名";

	public Banji(int banjiId, String banjiName) {
		super();
		this.banjiId = banjiId;
		this.banjiName = banjiName;
	}

	public Banji(int banjiId) {
		super();
		this.banjiId = banjiId;
	}

	@Override
	public String toString() {
		return "Banji [banjiId=" + banjiId + ", banjiName=" + banjiName + "]";
	}

	public Banji(String banjiName) {
		super();
		this.banjiName = banjiName;
	}

	public Banji() {
		super();
	}

	public Integer getBanjiId() {
		return banjiId;
	}

	public String getBanjiName() {
		return banjiName;
	}

}
