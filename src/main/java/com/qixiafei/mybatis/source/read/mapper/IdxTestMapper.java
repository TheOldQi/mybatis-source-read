package com.qixiafei.mybatis.source.read.mapper;

import com.qixiafei.mybatis.source.read.po.IdxTestPo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IdxTestMapper {

//    @Select("select * from idx_test limit 1000")
    List<IdxTestPo> listAll();
}
