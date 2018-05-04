package com.zonesun.daiqian.entity;

import java.util.List;

public class bankEntity {

	private String result;

	private MsgEntity msgEntity;
	

	public bankEntity(String result, MsgEntity msgEntity) {
		super();
		this.result = result;
		this.msgEntity = msgEntity;
	}
	
	

	public bankEntity() {
		super();
	}



	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public MsgEntity getMsgEntity() {
		return msgEntity;
	}

	public void setMsgEntity(MsgEntity msgEntity) {
		this.msgEntity = msgEntity;
	}


	

	@Override
	public String toString() {
		return "bankEntity [result=" + result + ", msgEntity=" + msgEntity
				+ "]";
	}




	public class MsgEntity {

		private String repaymentAbility;

		private IndexProperty indexProperty;

		private IndexTransBehavior indexTransBehavior;

		private List<IndexMonthConsumes> IndexMonthConsumes;

		private List<IndexConsumeCities> indexConsumeCities;
		private List<IndexConsumeCategories> indexConsumeCategories;
		private List<IndexTransCredits> indexTransCredits;
		public MsgEntity(
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
		public MsgEntity() {
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

	class IndexProperty {

		private boolean hasHouse;
		private boolean hasCar;
		private String housePurTime;
		private String carPurTime;
		private String houseValue;
		private String carValue;
		public IndexProperty(boolean hasHouse, boolean hasCar,
				String housePurTime, String carPurTime, String houseValue,
				String carValue) {
			super();
			this.hasHouse = hasHouse;
			this.hasCar = hasCar;
			this.housePurTime = housePurTime;
			this.carPurTime = carPurTime;
			this.houseValue = houseValue;
			this.carValue = carValue;
		}
		public IndexProperty() {
			super();
		}
		public boolean isHasHouse() {
			return hasHouse;
		}
		public void setHasHouse(boolean hasHouse) {
			this.hasHouse = hasHouse;
		}
		public boolean isHasCar() {
			return hasCar;
		}
		public void setHasCar(boolean hasCar) {
			this.hasCar = hasCar;
		}
		public String getHousePurTime() {
			return housePurTime;
		}
		public void setHousePurTime(String housePurTime) {
			this.housePurTime = housePurTime;
		}
		public String getCarPurTime() {
			return carPurTime;
		}
		public void setCarPurTime(String carPurTime) {
			this.carPurTime = carPurTime;
		}
		public String getHouseValue() {
			return houseValue;
		}
		public void setHouseValue(String houseValue) {
			this.houseValue = houseValue;
		}
		public String getCarValue() {
			return carValue;
		}
		public void setCarValue(String carValue) {
			this.carValue = carValue;
		}
		@Override
		public String toString() {
			return "IndexProperty [hasHouse=" + hasHouse + ", hasCar=" + hasCar
					+ ", housePurTime=" + housePurTime + ", carPurTime="
					+ carPurTime + ", houseValue=" + houseValue + ", carValue="
					+ carValue + "]";
		}
		
		
	}

	class IndexTransBehavior {
		private boolean businessTrip;
		private boolean marriageConsume;
		private boolean employed;
		private boolean childInvest;
		private boolean nightConsume;
		private String city;
		private String workRegion;
		private String freeRegion;
		public IndexTransBehavior(boolean businessTrip,
				boolean marriageConsume, boolean employed, boolean childInvest,
				boolean nightConsume, String city, String workRegion,
				String freeRegion) {
			super();
			this.businessTrip = businessTrip;
			this.marriageConsume = marriageConsume;
			this.employed = employed;
			this.childInvest = childInvest;
			this.nightConsume = nightConsume;
			this.city = city;
			this.workRegion = workRegion;
			this.freeRegion = freeRegion;
		}
		public IndexTransBehavior() {
			super();
		}
		public boolean isBusinessTrip() {
			return businessTrip;
		}
		public void setBusinessTrip(boolean businessTrip) {
			this.businessTrip = businessTrip;
		}
		public boolean isMarriageConsume() {
			return marriageConsume;
		}
		public void setMarriageConsume(boolean marriageConsume) {
			this.marriageConsume = marriageConsume;
		}
		public boolean isEmployed() {
			return employed;
		}
		public void setEmployed(boolean employed) {
			this.employed = employed;
		}
		public boolean isChildInvest() {
			return childInvest;
		}
		public void setChildInvest(boolean childInvest) {
			this.childInvest = childInvest;
		}
		public boolean isNightConsume() {
			return nightConsume;
		}
		public void setNightConsume(boolean nightConsume) {
			this.nightConsume = nightConsume;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getWorkRegion() {
			return workRegion;
		}
		public void setWorkRegion(String workRegion) {
			this.workRegion = workRegion;
		}
		public String getFreeRegion() {
			return freeRegion;
		}
		public void setFreeRegion(String freeRegion) {
			this.freeRegion = freeRegion;
		}
		@Override
		public String toString() {
			return "IndexTransBehavior [businessTrip=" + businessTrip
					+ ", marriageConsume=" + marriageConsume + ", employed="
					+ employed + ", childInvest=" + childInvest
					+ ", nightConsume=" + nightConsume + ", city=" + city
					+ ", workRegion=" + workRegion + ", freeRegion="
					+ freeRegion + "]";
		}
		
		
	}

	class IndexMonthConsumes {

		private String month;
		private String amount;
		private String count;
		private String amountRanking;
		private String countRanking;
		public IndexMonthConsumes(String month, String amount, String count,
				String amountRanking, String countRanking) {
			super();
			this.month = month;
			this.amount = amount;
			this.count = count;
			this.amountRanking = amountRanking;
			this.countRanking = countRanking;
		}
		public IndexMonthConsumes() {
			super();
		}
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getAmountRanking() {
			return amountRanking;
		}
		public void setAmountRanking(String amountRanking) {
			this.amountRanking = amountRanking;
		}
		public String getCountRanking() {
			return countRanking;
		}
		public void setCountRanking(String countRanking) {
			this.countRanking = countRanking;
		}
		@Override
		public String toString() {
			return "IndexMonthConsumes [month=" + month + ", amount=" + amount
					+ ", count=" + count + ", amountRanking=" + amountRanking
					+ ", countRanking=" + countRanking + "]";
		}

		
	}

	class IndexConsumeCities {
		private String name;
		private String amount;
		private String count;
		public IndexConsumeCities(String name, String amount, String count) {
			super();
			this.name = name;
			this.amount = amount;
			this.count = count;
		}
		public IndexConsumeCities() {
			super();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "IndexConsumeCities [name=" + name + ", amount=" + amount
					+ ", count=" + count + "]";
		}
		
		

	}

	class IndexConsumeCategories {

		private String name;
		private String amount;
		private String count;
		public IndexConsumeCategories(String name, String amount, String count) {
			super();
			this.name = name;
			this.amount = amount;
			this.count = count;
		}
		public IndexConsumeCategories() {
			super();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "IndexConsumeCategories [name=" + name + ", amount="
					+ amount + ", count=" + count + "]";
		}
		
		
	}

	class IndexTransCredits {
		private String name;
		private String count;
		private String amount;
		public IndexTransCredits(String name, String count, String amount) {
			super();
			this.name = name;
			this.count = count;
			this.amount = amount;
		}
		public IndexTransCredits() {
			super();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "IndexTransCredits [name=" + name + ", count=" + count
					+ ", amount=" + amount + "]";
		}
		
		
		
		

	}

}
