package pro.fengjian.ioc.java.beans;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.BeanInfo;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 *
 * @author 风间
 * @since 2022/7/27
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    // PropertyDescriptor 允许添加属性编辑器 PropertyEditor
                    // GUI -> text(String) -> PropertyType
                    // name -> String
                    // age -> Integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();

                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)) {
                        // String -> Integer : Integer.valueOf("xxx")
                        propertyDescriptor.setPropertyEditorClass(String2IntegerPropertyEditor.class);
                        propertyDescriptor.createPropertyEditor(new Person());
                    }
                });

    }

    static class String2IntegerPropertyEditor extends PropertyEditorSupport {

        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }

    }
}
