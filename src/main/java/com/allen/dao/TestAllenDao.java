package com.allen.dao;

import com.allen.api.TransferDto;
import com.allen.domain.TestAllen;
import com.allen.mapper.TestAllenMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-08 12:51
 * Version  1.0
 */
@RegisterMapper(TestAllenMapper.class)
public abstract class TestAllenDao {
    @SqlUpdate("create table if not exists t_test_allen(ID int auto_increment primary key,NAME varchar(100) null,BALANCE double null)")
    public abstract void createTable();

    @SqlQuery("select * from t_test_allen")
    public abstract List<TestAllen> findAll();

    @SqlUpdate("update t_test_allen set balance=balance+:balance where id=:id")
    public abstract int updateBalance(@Bind("id") @NotNull Integer id, @Bind("balance") @NotNull Double balance);

    /**
     *带事务控制的转账方法
     * @return
     */
    @Transaction
    public void transfer(TransferDto transferDto) {
        updateBalance(transferDto.getFrom(), -transferDto.getAmount());
        updateBalance(transferDto.getTo(), transferDto.getAmount());
    }

}
