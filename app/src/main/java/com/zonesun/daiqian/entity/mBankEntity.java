package com.zonesun.daiqian.entity;

import java.util.List;

import com.zonesun.daiqian.entity.bankEntity.IndexConsumeCategories;
import com.zonesun.daiqian.entity.bankEntity.IndexConsumeCities;
import com.zonesun.daiqian.entity.bankEntity.IndexMonthConsumes;
import com.zonesun.daiqian.entity.bankEntity.IndexProperty;
import com.zonesun.daiqian.entity.bankEntity.IndexTransBehavior;
import com.zonesun.daiqian.entity.bankEntity.IndexTransCredits;

public class mBankEntity {

	private String repaymentAbility;

	private IndexProperty indexProperty;

	private IndexTransBehavior indexTransBehavior;

	private List<IndexMonthConsumes> IndexMonthConsumes;

	private List<IndexConsumeCities> indexConsumeCities;
	private List<IndexConsumeCategories> indexConsumeCategories;
	private List<IndexTransCredits> indexTransCredits;
	public mBankEntity(
			String repaymentAbility,
			IndexProperty indexProperty,
			IndexTransBehavior indexTransBehavior,
			List<bankEntity.IndexMonthConsumes> indexMonthConsumes,
			List<IndexConsumeCities> indexConsumeCities,
			List<IndexConsumeCategories> indexConsumeCategories,
			List<IndexTransCredits> indexTransCredits) {
		super();
		this.repaymentAbility = repaymentAbility;
		this.indexProperty = indexProperty;
		this.indexTransBehavior = indexTransBehavior;
		IndexMonthConsumes = indexMonthConsumes;
		this.indexConsumeCities = indexConsumeCities;
		this.indexConsumeCategories = indexConsumeCategories;
		this.indexTransCredits = indexTransCredits;
	}
	public mBankEntity() {
		super();
	}
	public String getRepaymentAbility() {
		return repaymentAbility;
	}
	public void setRepaymentAbility(String repaymentAbility) {
		this.repaymentAbility = repaymentAbility;
	}
	public IndexProperty getIndexProperty() {
		return indexProperty;
	}
	public void setIndexProperty(IndexProperty indexProperty) {
		this.indexProperty = indexProperty;
	}
	public IndexTransBehavior getIndexTransBehavior() {
		return indexTransBehavior;
	}
	public void setIndexTransBehavior(IndexTransBehavior indexTransBehavior) {
		this.indexTransBehavior = indexTransBehavior;
	}
	public List<IndexMonthConsumes> getIndexMonthConsumes() {
		return IndexMonthConsumes;
	}
	public void setIndexMonthConsumes(List<IndexMonthConsumes> indexMonthConsumes) {
		IndexMonthConsumes = indexMonthConsumes;
	}
	public List<IndexConsumeCities> getIndexConsumeCities() {
		return indexConsumeCities;
	}
	public void setIndexConsumeCities(List<IndexConsumeCities> indexConsumeCities) {
		this.indexConsumeCities = indexConsumeCities;
	}
	public List<IndexConsumeCategories> getIndexConsumeCategories() {
		return indexConsumeCategories;
	}
	public void setIndexConsumeCategories(
			List<IndexConsumeCategories> indexConsumeCategories) {
		this.indexConsumeCategories = indexConsumeCategories;
	}
	public List<IndexTransCredits> getIndexTransCredits() {
		return indexTransCredits;
	}
	public void setIndexTransCredits(List<IndexTransCredits> indexTransCredits) {
		this.indexTransCredits = indexTransCredits;
	}
	@Override
	public String toString() {
		return "MsgEntity [repaymentAbility=" + repaymentAbility
				+ ", indexProperty=" + indexProperty
				+ ", indexTransBehavior=" + indexTransBehavior
				+ ", IndexMonthConsumes=" + IndexMonthConsumes
				+ ", indexConsumeCities=" + indexConsumeCities
				+ ", indexConsumeCategories=" + indexConsumeCategories
				+ ", indexTransCredits=" + indexTransCredits + "]";
	}

		

}


