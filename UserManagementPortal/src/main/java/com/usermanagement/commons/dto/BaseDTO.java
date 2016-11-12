package com.usermanagement.commons.dto;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeanUtils;
import com.usermanagement.commons.exception.UMException;

public class BaseDTO {

	public static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
	public static final SimpleDateFormat SDFT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

	}
	
	public <T> T toModel(Class<T> type) throws UMException {
		try {
			Constructor<T> constructor = type.getConstructor();
			Object oModel = constructor.newInstance();
			BeanUtils.copyProperties(this, oModel);
			return type.cast(oModel);
		} catch (InvocationTargetException e) {
			throw new UMException(e.getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			throw new UMException(e.getMessage(), e.getCause());
		} catch (InstantiationException e) {
			throw new UMException(e.getMessage(), e.getCause());
		} catch (IllegalAccessException e) {
			throw new UMException(e.getMessage(), e.getCause());
		}

	}

	public <T> T toModel(Class<T> type, Object model) throws UMException {
		BeanUtils.copyProperties(this, model);
		return type.cast(model);
	}

	public static <T> List<T> toModels(Class<T> type, @SuppressWarnings("rawtypes") List dtos) throws UMException {
		try {
			List<T> list = new ArrayList<T>();
			Constructor<T> constructor = type.getConstructor();
			for (Object o : dtos) {
				Object model = constructor.newInstance();
				BeanUtils.copyProperties(o, model);
				list.add(type.cast(model));
			}
			return list;
		} catch (InvocationTargetException e) {
			throw new UMException(e.getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			throw new UMException(e.getMessage(), e.getCause());
		} catch (InstantiationException e) {
			throw new UMException(e.getMessage(), e.getCause());
		} catch (IllegalAccessException e) {
			throw new UMException(e.getMessage(), e.getCause());
		}

	}
}
