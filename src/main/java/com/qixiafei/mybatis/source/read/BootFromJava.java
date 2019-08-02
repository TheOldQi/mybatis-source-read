package com.qixiafei.mybatis.source.read;

import com.qixiafei.mybatis.source.read.mapper.IdxTestMapper;
import com.qixiafei.mybatis.source.read.po.IdxTestPo;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

public class BootFromJava {

    public static void main(String[] args) {
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/test_db?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&rewriteBatchedStatements=true&useSSL=true&serverTimezone=Asia/Shanghai");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root");

        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment env = new Environment("dev", transactionFactory, dataSource);
        Configuration conf = new Configuration(env);
        conf.setAutoMappingUnknownColumnBehavior(AutoMappingUnknownColumnBehavior.NONE);
        conf.setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
        conf.setMapUnderscoreToCamelCase(true);

        conf.addMapper(IdxTestMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(conf);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IdxTestPoResultHandler idxTestPoResultHandler = new IdxTestPoResultHandler();
        sqlSession.select(IdxTestMapper.class.getName() + ".listAll", idxTestPoResultHandler);
        List<IdxTestPo> result = idxTestPoResultHandler.getResult();
        System.out.println(result);
    }
}
