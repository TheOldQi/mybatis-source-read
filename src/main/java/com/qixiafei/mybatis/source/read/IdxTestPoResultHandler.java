package com.qixiafei.mybatis.source.read;

import com.qixiafei.mybatis.source.read.po.IdxTestPo;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   </P>
 * <P>CREATE DATE: 2019/6/11 11:43</P>
 * <P>UPDATE DATE: </P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
public class IdxTestPoResultHandler implements ResultHandler<IdxTestPo> {
    List<IdxTestPo> result = new ArrayList<IdxTestPo>();

    public void handleResult(ResultContext<? extends IdxTestPo> resultContext) {
        result.add(resultContext.getResultObject());
    }

    public List<IdxTestPo> getResult() {
        return result;
    }
}
