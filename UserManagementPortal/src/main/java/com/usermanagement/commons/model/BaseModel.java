package com.usermanagement.commons.model;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeanUtils;

import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.util.UserContext;

@MappedSuperclass
@SuppressWarnings("rawtypes")
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
	public static final SimpleDateFormat SDFT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

	@Basic
	private Long createdBy;

	@Column(updatable = false)
	private Timestamp createdTime;

	@Column
	private Long lastUpdatedBy;

	@Column
	private Timestamp lastUpdatedTime;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean display = true;

	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean deleted = false;

	@Column
	private Long deletedBy;

	@Column
	private Timestamp deletedTime;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Transient
	abstract public Long getId();

	@Transient
	abstract public void setId(Long id);

	@Transient
	public boolean isNew() {
		return this.getId() == null || this.getId() == 0 ? true : false;
	}

	public <T> T toDTO(Class<T> type) throws Exception {
		try {			
			Constructor constructor = type.getConstructor();
			Object oDTO = constructor.newInstance();
			BeanUtils.copyProperties(this, oDTO);
			return type.cast(oDTO);
		} catch (InvocationTargetException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (InstantiationException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (IllegalAccessException e) {
			throw new Exception(e.getMessage(), e.getCause());
		}

	}

	public <T> T toModel(Class<T> type) throws Exception {
		try {
			Constructor constructor = type.getConstructor();
			Object oModel = constructor.newInstance();
			BeanUtils.copyProperties(this, oModel);
			return type.cast(oModel);
		} catch (InvocationTargetException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (InstantiationException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (IllegalAccessException e) {
			throw new Exception(e.getMessage(), e.getCause());
		}

	}

	public static <S> List<S> toDTOs(Class<S> type, List models) throws UMException {
		try {
			List<S> list = new ArrayList<S>();
			Constructor<S> constructor = type.getConstructor();
			for (Object o : models) {
				@SuppressWarnings("unused")
				BaseModel model = (BaseModel) o;
				Object oDTO = constructor.newInstance();
				BeanUtils.copyProperties(o, oDTO);
				list.add(type.cast(oDTO));
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Timestamp getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Timestamp deletedTime) {
		this.deletedTime = deletedTime;
	}
		
	@PrePersist
	public void prePersist() {
		UserContext userContext = UserContext.getContext();
		if (userContext != null) {
			setCreatedBy(-100L);
		} else {
			setCreatedBy(-100L);
		}
		setCreatedTime(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	public void preUpdate() {
		UserContext userContext = UserContext.getContext();
		if (userContext != null) {
			setLastUpdatedBy(-100L);
		} else {
			setLastUpdatedBy(-100L);
		}
		setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
	}

	public void delete() {
		UserContext userContext = UserContext.getContext();
		setDeleted(true);
		setDisplay(false);
		if (userContext != null) {
			setDeletedBy(-100L);
		} else {
			setDeletedBy(-100L);
		}
		setDeletedTime(new Timestamp(System.currentTimeMillis()));
	}
}
