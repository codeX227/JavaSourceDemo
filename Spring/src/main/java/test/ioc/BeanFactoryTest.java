package test.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
    public static void main(String[] args) {

        //创建一个 beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //创建一个载入 BeanDefinition 的读取器，通过回调配置给 BeanFactory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        //创建 Ioc 配置文件的抽象资源，这个抽象资源包含 BeanFactory 的定义信息
        ClassPathResource resource = new ClassPathResource("beans.xml");

        //从定义好的资源位置读入配置信息，由 XmlBeanDefinitionReader 来进行解析
        reader.loadBeanDefinitions(resource);

        Object user = beanFactory.getBean("user");

        System.out.println(user);
    }
}
