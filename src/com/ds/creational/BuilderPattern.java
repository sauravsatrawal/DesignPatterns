package com.ds.creational;

public class BuilderPattern {
	
	public static void main(String[] args) {
		LunchOrder.LunchBuider builder = new LunchOrder.LunchBuider();
		
		// No need to create object with all attributes
		builder.bread("wheat").dressing("olive oil").meat("NA");
		
		LunchOrder order = builder.build();
		System.out.println(order);
	}
} 

class LunchOrder {
	// Immutable object using final properties
	private final String bread;
	private final String condiments;
	private final String dressing;
	private final String meat;
	
	public static class LunchBuider {
		private String bread;
		private String condiments;
		private String dressing;
		private String meat;
		
		/**
		 * Real Object creation
		 */
		public LunchOrder build() {
			return new LunchOrder(this);
		}
		
		LunchBuider bread(String bread) {
			this.bread = bread;
			return this;
		}
		
		LunchBuider meat(String meat) {
			this.meat = meat;
			return this;
		}
		
		LunchBuider condiments(String condiments) {
			this.condiments = condiments;
			return this;
		}
		
		LunchBuider dressing(String dressing) {
			this.bread = dressing;
			return this;
		}
	}

	/**
	 * Restricted Object creation with no SETTER's 
	 */
	private LunchOrder(LunchBuider builder) {
		this.bread = builder.bread;
		this.dressing = builder.dressing;
		this.meat = builder.meat;
		
		// usage of Default case
		this.condiments = (builder.condiments != null) ? builder.condiments : "DEFAULT";
	}
	
	public String getBread() {return bread;}
	public String getCondiments() {return condiments;}
	public String getDressing() {return dressing;}
	public String getMeat() {return meat;}

	@Override
	public String toString() {
		return "LunchOrder [bread=" + bread + ", condiments=" + condiments + ", dressing=" + dressing + ", meat=" + meat + "]";
	}
}