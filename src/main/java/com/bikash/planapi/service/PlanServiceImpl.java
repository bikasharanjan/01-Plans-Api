package com.bikash.planapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.planapi.entity.PlanCategory;
import com.bikash.planapi.entity.Plans;
import com.bikash.planapi.repo.PlanCategoryRepo;
import com.bikash.planapi.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	
	private static final Object Plans = null;

	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;


	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> findAll = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap=new HashMap<>();
		findAll.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		System.out.println(categoryMap);
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plans plans) {
		com.bikash.planapi.entity.Plans saved = planRepo.save(plans);
		/*if(saved.getPlanId()!=null)
			return true;
		else
			return false; */
		
		//return saved.getPlanId()!=null?true:false;
		
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plans> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plans getPlanById(Integer planId) {
		Optional<Plans> findById = planRepo.findById(planId);
		if(findById.isPresent())
			return findById.get();
		else
			return null;
	}

	@Override
	public boolean updatePlan(Plans plans) {
		Plans saved = planRepo.save(plans);
		return plans.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try{
			planRepo.deleteById(planId);
			status=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean checkPlanStatus(Integer planId, String status) {
		Optional<Plans> findById=planRepo.findById(planId);
		if(findById.isPresent()) {
		Plans plans=findById.get();
		plans.setActiveSw(status);
		planRepo.save(plans);
		return true;
		}
		else
			return false;
	}
}
