package DesignPatterns.BehavioralType.ChainOfResponsibility;

public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        // TODO Auto-generated method stub
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("请求编号 id= " + purchaseRequest.getId() + "被" + this.name + "处理！");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
