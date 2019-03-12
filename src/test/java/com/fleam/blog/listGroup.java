package com.fleam.blog;

import com.fleam.base.util.DateUtils;
import com.fleam.base.util.MyStringUtil;
import com.fleam.base.util.XmlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class listGroup {

    static class A {

        private Integer id;
        private String name;
        private Integer count;

        public Integer getId() {
            return id;
        }

        public A setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public A setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getCount() {
            return count;
        }

        public A setCount(Integer count) {
            this.count = count;
            return this;
        }
    }

    @Test
    public  void listGroup() throws ParseException {
        List<A> inList = new ArrayList<A>();
        A a1 = new A().setId(1).setName("aaaa").setCount(1);
        A a2 = new A().setId(2).setName("bbbb").setCount(4);
        A a3 = new A().setId(3).setName("cccc").setCount(3);
        A a4 = new A().setId(4).setName("aaaa").setCount(3);
        inList.add(a1);
        inList.add(a2);
        inList.add(a3);
        inList.add(a4);

        Map<String, A> map = new HashMap<String, A>();
        A tmpUser;
        for (A oUser : inList) {
            tmpUser = map.get(oUser.getName());
            if (tmpUser != null) {
                tmpUser.setCount(tmpUser.getCount() + oUser.getCount());
            } else {
                map.put(oUser.getName(), oUser);
            }
        }

        List<A> returnList = new ArrayList<>();
        for (A a : map.values()) {
            System.out.println(a);
            returnList.add(a);
        }
        System.out.print(returnList);
    }

}
