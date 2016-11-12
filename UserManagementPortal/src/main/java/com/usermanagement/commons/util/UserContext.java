package com.usermanagement.commons.util;

import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import com.usermanagement.commons.dto.UserDTO;

public class UserContext {
	private static final String USER_CONTEXT_NAME = "userContext";

	private static final ThreadLocal<UserContext> USER_CONTEXT = new InheritableThreadLocal<UserContext>() {
		protected UserContext initialValue() {
			return new UserContext();
		}
	};

	private static Long id;
	private static String userName;

	public UserContext init(UserDTO userDTO, HttpSession httpSession) {
		BeanUtils.copyProperties(userDTO, this);
		if(httpSession!=null){
			httpSession.setAttribute(USER_CONTEXT_NAME, this);
		}
		return this;
	}

	public static void unset(HttpSession httpSession) {
		if(httpSession!=null){
			httpSession.removeAttribute(USER_CONTEXT_NAME);
		}
		USER_CONTEXT.remove();
	}

	public static void set(UserContext userContext) {
		USER_CONTEXT.set(userContext);
	}

	public static synchronized UserContext getContext() {
		return USER_CONTEXT.get();
	}
	
	public static synchronized UserContext getFromHttpSession(HttpSession httpSession) {
		UserContext userContext = (UserContext)httpSession.getAttribute(USER_CONTEXT_NAME);
		USER_CONTEXT.set(userContext);
		return userContext;
	}

	
	public boolean isActive() {
		return id!=null && id > 0L;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		UserContext.userName = userName;
	}

	public static Long getId() {
		return id;
	}

	public static void setId(Long id) {
		UserContext.id = id;
	}
}
