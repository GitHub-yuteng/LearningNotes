package DesignPatterns.BehavioralType.ChainOfResponsibility;

public class Client {

    public static void main(String[] args) {

        //创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 5100, 1);

        //创建相关审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("主任");
        CollegeApprover collegeApprover = new CollegeApprover("院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");

        //需要将各个审批级别的下一个设置进去（形成环形）否则会 空指针
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);

        viceSchoolMasterApprover.processRequest(purchaseRequest);
    }
}
