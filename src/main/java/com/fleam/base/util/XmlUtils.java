package com.fleam.base.util;


import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * XML工具类
 *
 */
public class XmlUtils {

    public static List<Object> readXML(String xmlString,String itemsString,String itemString, Class<?> clazz) {

        List<Object> list = new ArrayList();//创建list集合
        try {
            //1.创建一个SAXBuilder的对象
            SAXReader reader = new SAXReader();
            org.dom4j.Document doc = reader.read(new InputSource(new ByteArrayInputStream(xmlString.getBytes("utf8"))));//dom4j读取
            // 4.通过document对象获取xml文件的根节点
            org.dom4j.Element root = doc.getRootElement();//获得根节点
            // 5. 获取根节点下的子节点body
            org.dom4j.Element body = root.element(itemsString);
            // 6. 获取根节点下的二级节点
            org.dom4j.Element foo;
            for (Iterator i = body.elementIterator(itemString); i.hasNext(); ) {//遍历t.getClass().getSimpleName()节点
                foo = (org.dom4j.Element) i.next();//下一个二级节点
                //实例化Object对象
                Object obj = clazz.newInstance();
                Field[] properties = obj.getClass().getDeclaredFields();//获得实例的属性
                //实例的get方法
                Method getmeth;
                //实例的set方法
                Method setmeth;
                //遍历实体类的属性
                for (int j = 0; j < properties.length; j++) {
                    //实例的set方法
                    if (properties[j].getName().equals("serialVersionUID")) {
                        continue;
                    } else {
                        setmeth = obj.getClass().getMethod(
                                "set"
                                        + properties[j].getName().substring(0, 1).toUpperCase()
                                        + properties[j].getName().substring(1), properties[j].getType());
                        Object setStr = foo.elementText(properties[j].getName());

                        if (foo.elementText(properties[j].getName()) != null&&!"".equals(foo.elementText(properties[j].getName()))) {
                            if (properties[j].getType() == java.util.Date.class) {
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date sj = df.parse(foo.elementText(properties[j].getName()));
                                setStr = sj;
                            } else if (properties[j].getType() == java.lang.Integer.class) {
                                setStr = Integer.parseInt(foo.elementText(properties[j].getName()));
                            } else if (properties[j].getType() == java.lang.Character.class) {
                                setStr = foo.elementText(properties[j].getName()).charAt(0);
                            }else if (properties[j].getType() == java.lang.Double.class) {
                                setStr = Double.parseDouble(foo.elementText(properties[j].getName()));
                            }
                        } else {
                            setStr = null;
                        }
                        //将对应节点的值存入
                        setmeth.invoke(obj, setStr);
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}