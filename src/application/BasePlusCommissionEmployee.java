package application;


public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalery;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commisionRate, double baseSalery) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commisionRate);
		setBaseSalery(baseSalery);
	}

	public String toString() {
		return "base-salariede commission employee: " + getFirstName() + " " + getLastName() + "\n"
				+ "social security number: " + getSocialSecurityNumber() + " \n" + "gross sales: " + "$"
				+ getGrossSales() + " commision rate: " + getCommisionRate() + "\n"
				+ "Base Salary:" +  getBaseSalery() + " payment amount: " + "$"
				+ getPaymentAmount();
	}

	public double getPaymentAmount() {
		return super.getPaymentAmount() + getBaseSalery();
	}

	public double getBaseSalery() {
		return baseSalery;
	}

	public void setBaseSalery(double baseSalery) {
		if (baseSalery >= 0) {
			this.baseSalery = baseSalery;
		} else {
			throw new IllegalArgumentException("baseSalery");
		}
	}

}



