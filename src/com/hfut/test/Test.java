package com.hfut.test;

import com.hfut.pojo.Student;
import com.hfut.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();

        List<Teacher>list= session.selectList("com.hfut.mapper.TeacherMapper.selAll");
        System.out.println(list);



        ///多表联合查询
        List<Student>liststu=session.selectList("com.hfut.mapper.StudentMapper.selAll");
        System.out.println(liststu);

        session.close();
        System.out.println("程序执行结束");

    }
}
