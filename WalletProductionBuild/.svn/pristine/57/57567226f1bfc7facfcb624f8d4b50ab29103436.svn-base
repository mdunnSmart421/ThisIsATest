package com.o2.finance.beans;

public class FriendlyUsernameLabelBean {

	private String bfid;
	private String portalId;
	private String friendlyUsername;
	private String label;

	
	public FriendlyUsernameLabelBean(String aBfid, String aFriendlyUsername, String aLabel) {
		bfid = aBfid;
		friendlyUsername = aFriendlyUsername;
		label = aLabel;
	}
	
	public String getPortalId() {
		return portalId;
	}

	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}

	public String getFriendlyUsername() {
		return friendlyUsername;
	}

	public void setFriendlyUsername(String friendlyUsername) {
		this.friendlyUsername = friendlyUsername;
	}

	public String getLabel() {
		//Only return the non default label name
		if(label.equalsIgnoreCase("Insert Label")) {
			return "";
		}
		else {		
		  return "(" + label + ")";
		}
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBfid() {
		return bfid;
	}

	public void setBfid(String bfid) {
		this.bfid = bfid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bfid == null) ? 0 : bfid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendlyUsernameLabelBean other = (FriendlyUsernameLabelBean) obj;
		if (bfid == null) {
			if (other.bfid != null)
				return false;
		} else if (!bfid.equals(other.bfid))
			return false;
		return true;
	}
	
}
