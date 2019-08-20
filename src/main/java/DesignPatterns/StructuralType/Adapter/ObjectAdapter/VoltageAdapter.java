package DesignPatterns.StructuralType.Adapter.ObjectAdapter;

public class VoltageAdapter implements IVoltage5V {

    //聚合进来
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220v) {
        this.voltage220V = voltage220v;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if (null != voltage220V) {
            System.out.println("使用对象进行适配！");
            int srcV = voltage220V.output220V();
            dstV = srcV / 44;
            System.out.println("适配完成电压为：" + dstV + "V");
        }
        return dstV;
    }
}
