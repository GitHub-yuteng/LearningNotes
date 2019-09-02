package DesignPatterns.CreationType.Prototype.DeepClone;

public class Client {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        DeepProtoType p = new DeepProtoType();
        p.name = "余腾";
        p.deepCloneableTarget = new DeepCloneableTarget("Java", "Py");

        //TODO 方式1 完成深拷贝
//		DeepProtoType p2 = (DeepProtoType) p.clone();
////
//        System.out.println("p.name=" + p.name + " p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode() + " " + p.deepCloneableTarget.toString());
//        System.out.println("p2.name=" + p.name + " p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode() + " " + p.deepCloneableTarget.toString());

        //TODO 方式2 完成深拷贝
        DeepProtoType p2 = (DeepProtoType) p.deepClone();

        System.out.println("p.name=" + p.name + " p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode() + " " + p.deepCloneableTarget.toString());
        System.out.println("p2.name=" + p.name + " p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode() + " " + p.deepCloneableTarget.toString());
    }
}
