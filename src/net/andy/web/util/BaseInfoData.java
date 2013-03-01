package net.andy.web.util;

import net.andy.web.elements.BaseInfo;

public class BaseInfoData {
	private String packageNameInput;
	private String scriptAuthInput;
	private String scriptDescInput;
	private String scriptNameInput;
	private String classNameInput;
	
	public BaseInfoData() {
		this.packageNameInput = BaseInfo.packageNameInput.getText();
		this.scriptAuthInput = BaseInfo.scriptAuthInput.getText();
		this.scriptDescInput = BaseInfo.scriptDescInput.getText();
		this.scriptNameInput = BaseInfo.scriptNameInput.getText();
		this.classNameInput = BaseInfo.classNameInput.getText();
	}
	
	public String getPackageNameInput() {
		return packageNameInput;
	}
	public String getScriptAuthInput() {
		return scriptAuthInput;
	}
	public String getScriptDescInput() {
		return scriptDescInput;
	}
	public String getScriptNameInput() {
		return scriptNameInput;
	}
	public String getClassNameInput() {
		return classNameInput;
	}
	
	
}
