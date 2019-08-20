package DesignPatterns.StructuralType.Adapter.ClassAdapter;

public class Voltage220V {
	public int output220V() {
		int src = 220;
		System.out.println("电压=" + src + "V");
		return src;
	}
}
