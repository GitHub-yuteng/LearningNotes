package DesignPatterns.Proxy.DynamicProxy;

/**
 * @author Yu
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课！");
    }

    @Override
    public String write(String name) {
        System.out.println("name:" + name);
        return "success！";
    }
}
