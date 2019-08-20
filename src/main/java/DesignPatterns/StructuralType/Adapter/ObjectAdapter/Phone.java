package DesignPatterns.StructuralType.Adapter.ObjectAdapter;


public class Phone {

	public void charging(IVoltage5V iVoltage5V) {
		if(iVoltage5V.output5V() == 5) {
			System.out.println("5V => Phone Charging");
		} else if (iVoltage5V.output5V() > 5) {
			System.out.println(">5V => Excessive Voltage");
		}
	}
}
