package net.andy.web.util;

import java.util.List;

import net.andy.web.elements.SelectorInfo;

public class SelectorInfoData {

	private SelectorInfo si = new SelectorInfo();
	
	private String pageUrlInput;
	private String selectorInput;
	private String selectorAliasInput;
	private String checkedType;
	private String introduceInput;
	
	public List<SelectorInfoData> selectorInfoDataList;
	
	public void setPageUrlInput(String pageURL) {
		this.pageUrlInput = si.pageURLInput.getText();
	}
	public String getPageUrlInput() {
		return pageUrlInput;
	}
	public void setSelectorInput(String selector) {
		this.selectorInput = si.selectorInput.getText();
	}
	public String getSelectorInput() {
		return selectorInput;
	}
	public void setSelectorAliasInput(String selectorAlias) {
		this.selectorAliasInput = si.selectorAliasInput.getText();
	}
	public String getSelectorAliasInput() {
		return selectorAliasInput;
	}
	public void setCheckedType(String checkType) {
		this.checkedType = si.checkTypeList.getSelectedItem().toString();
	}
	public String getCheckedType() {
		return checkedType;
	}
	public void setIntroduceInput(String introduce) {
		this.introduceInput = si.introduceInput.getText();
	}
	public String getIntroduceInput() {
		return introduceInput;
	}

}
