package org.geekbang.ioc.java.beans;

import java.beans.*;
import java.util.stream.Stream;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)){
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        //propertyDescriptor.createPropertyEditor();
                    }
                });
    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        public void setAsText(String text){
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
