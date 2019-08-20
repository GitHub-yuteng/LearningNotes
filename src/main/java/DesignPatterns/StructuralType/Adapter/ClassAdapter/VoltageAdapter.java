package DesignPatterns.StructuralType.Adapter.ClassAdapter;


public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        //获取到220V电压
        System.out.println("使用类适配器进行适配！");
        int srcV = output220V();
        int dstV = srcV / 44;
        System.out.println("适配完成电压为：" + dstV + "V");
        return dstV;
    }
}
