package com.allen.mapper;

import com.allen.domain.TestAllen;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-08 13:01
 * Version  1.0
 */
public class TestAllenMapper implements ResultSetMapper<TestAllen> {
    public TestAllen map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return TestAllen.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .balance(resultSet.getDouble("balance"))
                .build();
    }
}
