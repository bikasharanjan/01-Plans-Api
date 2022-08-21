package com.bikash.planapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bikash.planapi.entity.Plans;

public interface PlanService {
	
	//Requirement methods analysis
	
	// every action or button is a method that is performing some task
	
	//try to analysis what this method return or what is it going to show
	
	
	//pre-populated data in drop down you first get those data
	// in map string =plan_name , integer = submitting plan category id
	public Map<Integer ,String> getPlanCategories();
	
	
	
	// give  a message plan is saved or not
	public boolean savePlan(Plans plans);
	
	
	//after submitting plan you have to fetch the data
	
	public List<Plans> getAllPlans();
	
	// edit a existing plan id 
	public Plans getPlanById(Integer planId);
	
	
	//after modifying a single plan you need to save 
	//we can also call the save plan method but we will do it later
	
	public boolean updatePlan(Plans plans);
	
	
	//delete a plan
	
	public boolean deletePlanById(Integer planId);
	
	//active or de-active a plan
	
	public boolean checkPlanStatus(Integer planId ,String status);

}
