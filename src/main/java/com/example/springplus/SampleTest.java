package com.example.springplus;

import com.example.springplus.entity.Person;
import com.example.springplus.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class SampleTest {
    @Autowired
    public UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Person> personList = new ArrayList<Person>();
        List<Person> personLists2 = new ArrayList<Person>();
        personList.add(new Person("A", 8000, 21, "male"));
        personList.add(new Person("B", 7000, 22, "male"));
        personList.add(new Person("C", 7000, 23, "female"));
        personList.add(new Person("D", 8000, 24, "female"));
        personList.add(new Person("E", 9500, 20, "male"));
        personLists2.add(new Person("F", 9500, 20, "male"));
        //根据工资来进行分组
        Map<Integer, List<Person>> listMap = personList.stream().collect(Collectors.groupingBy(Person::getSalary));
        listMap.forEach((salary, d) -> {
         Person pp=   new Person(d.get(0).getName(), d.get(0).getSalary()
                    , d.get(0).getAge(), d.get(0).getSex());
            personLists2.add(pp);
        });
        personLists2.forEach(d->{
            System.out.println("分组"+d.getName());
        });
        //过滤掉年龄小于22岁的人

        personList.stream().filter(d ->d.getAge()>22).forEach(d -> System.out.println("过滤"+d.getAge()));
        //找到年龄最大的人
        Person person2 = personList.stream().max((d1, d2) -> Integer.compare(d1.getAge(), d2.getAge())).get();
        // 拼接两个数据流 concat
        List<Person> personLists1 = Stream.concat(personList.stream(), personLists2.stream()).distinct().collect(Collectors.toList());
        System.out.println(personLists1.get(5).getName());
        //去重、合并、跳过、截取（concat、distinct、skip、limit）
        List<Person> personListskip = personList.stream().skip(2).collect(Collectors.toList());
        List<Person> personListlimit = personList.stream().limit(2).collect(Collectors.toList());
        List<Person> personListdistinct = personList.stream().distinct().collect(Collectors.toList());
        personList.stream().filter(d -> d.getAge() > 21).forEach(d -> {
            Person person = new Person(d.getName(), d.getSalary(), d.getAge(), d.getSex());
        });

        // 获取工资最高的人员信息
        Person person = personList.stream().max((p1, p2) -> Integer.compare(p1.getSalary(), p2.getSalary())).get();
        List<Person> person1 = personList.stream().filter(d -> d.getAge() > 20).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //筛选员工中工资高于8000的人，并形成新的集合
        List<String> listName = personList.stream().filter(p -> p.getSalary() > 9000).map(Person::getName).collect(Collectors.toList());
        List<String> listName1 = personList.stream().filter(p -> p.getAge() > 21).map(Person::getName).collect(Collectors.toList());
        System.out.println("获取工资高于8000的人员姓名:" + listName.get(0));
        //将员工的薪资全部增加1000
        List<Person> personList1 = personList.stream().map(p -> {
            p.setSalary(p.getSalary() + 1000);
            return p;
        }).collect(Collectors.toList());
        List<Person> personList2 = personList.stream().map(p -> {
            p.setAge(p.getAge() + 1);
            return p;
        }).collect(Collectors.toList());

        System.out.println("将员工的薪资全部增加1000:" + personList1.get(0).getSalary());
        //获取所有员工的工资总和和平均值
        Integer sumSalary = personList.stream().mapToInt(Person::getSalary).sum();
        System.out.println("获取所有员工的工资总和:" + sumSalary);
        System.out.println("获取年龄大于20的人员信息:" + person1.get(0).getName());
        System.out.println("获取工资最高的人员信息:" + person.getName());
        //List<Usert> userList = userMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        //userList.forEach(System.out::println);
//        String index = "abcdefghijk";
//        int a = index.indexOf("f");
//        System.out.println(a);
//        if (a != -1) {
//            System.out.println(a);
//        }
    }

}
