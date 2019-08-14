package Spring.IOC;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Yu
 */

class ApplicationResourceContext {
    private String url;

    public ApplicationResourceContext(String url) {
        this.url = url;
    }

    public Object getBean(String id) throws Exception {
        //获取 xml 文件
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(url);

        SAXReader reader = new SAXReader();
        // 解析 XML 文档，获取 document
        Document document = reader.read(resourceAsStream);
        // 获取根节点
        Element beans = document.getRootElement();
        // 获取所有 beans 根节点，放入List
        List<Element> beansList = beans.elements();

        for (int i = 0; i < beansList.size(); i++) {
            Element bean = beansList.get(i);
            if (!bean.attributeValue("id").equals(id)) {
                continue;
            }

            String beanClass = bean.attributeValue("class");
            Class<?> forName = Class.forName(beanClass);
            Object instance = forName.newInstance();


            // 获取所有 bean节点属性
            List<Element> attrsList = bean.elements();

            //对属性进行赋值
            for (int j = 0; j < attrsList.size(); j++) {
                String key = attrsList.get(j).attributeValue("key");
                String value = attrsList.get(j).attributeValue("value");

                Field declaredField = forName.getDeclaredField(key);
                declaredField.setAccessible(true);
                declaredField.set(instance, value);
            }
            return instance;
        }
        return null;
    }
}

public class HandWritingIoc {
    public static void main(String[] args) throws Exception {
        ApplicationResourceContext applicationContext = new ApplicationResourceContext("IOC.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }
}
