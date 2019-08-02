package com.qixiafei.mybatis.source.read;

import com.qixiafei.mybatis.source.read.mapper.IdxTestMapper;
import com.qixiafei.mybatis.source.read.po.IdxTestPo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BootFromXml {

    public static void main(String[] args) throws IOException {
        final InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        System.out.println("mybatis配置文件加载成功");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IdxTestPoResultHandler result = new IdxTestPoResultHandler();
        sqlSession.select(IdxTestMapper.class.getName() + ".listAll", result);


        List<IdxTestPo> result1 = result.getResult();
        System.out.println(result1);
    }
}
