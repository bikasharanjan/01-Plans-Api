package com.bikash.planapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN_MASTER")
public class Plans {
	
	@Id
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="PLAN_CREATED_BY")
	private String planCreatedBy;
	
	@Column(name="PLAN_UPDATED_BY")
	private String planUpdatedBy;
	
	@Column(name="PLAN_CREATED_DATE" ,updatable = false)
	@CreationTimestamp
	private LocalDate planCreatedDate;
	
	@Column(name="PLAN_UPDATED_DATE" ,insertable = false)
	@UpdateTimestamp
	private LocalDate planUpdatedDate;

}
