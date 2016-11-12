package com.usermanagement.commons.util;

public class QueryUtil {
	public static StringBuilder getBaseCause(String prefix) {
		StringBuilder baseCause = new StringBuilder();
		baseCause.append(prefix + ".deleted=false ");
		baseCause.append("AND " + prefix + ".display=true ");
		return baseCause;
	}

	public static StringBuilder getBaseCause(String prefix, boolean isBranchSpecific) {
		return getBaseCause(prefix, isBranchSpecific, true);
	}

	public static StringBuilder getBaseCause(String prefix, boolean isBranchSpecific, boolean isCompanySpecific) {
		@SuppressWarnings("unused")
		UserContext userContext = UserContext.getContext();
		StringBuilder baseCause = new StringBuilder();

		baseCause.append(prefix + ".deleted=false ");
		baseCause.append("AND " + prefix + ".display=true ");
		return baseCause;
	}
}
