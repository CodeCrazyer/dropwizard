package com.allen.domain;

import lombok.Builder;
import lombok.Data;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-08 12:52
 * Version  1.0
 */
@Data
@Builder
public class TestAllen {
    private Integer id;
    private String name;
    private Double balance;
}
