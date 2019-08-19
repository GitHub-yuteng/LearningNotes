package DesignPatterns.StructuralType.Proxy.CGLibProxy;


/**
 * @author Yu
 */
public class TeacherDao {

    public void teach() {
        System.out.println("老师授课！");
    }

    public String write(String name) {
        System.out.println("name:" + name);
        return "success！";
    }
}
