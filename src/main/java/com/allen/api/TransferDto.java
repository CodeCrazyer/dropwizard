package com.allen.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-08 13:09
 * Version  1.0
 */
@Data
public class TransferDto {
    @NotNull(message = "转账者ID不能为空")
    @Min(value = 1, message = "转账者ID不能小于{value}")
    @JsonProperty
    private Integer from;

    @NotNull(message = "转入者ID不能为空")
    @Min(value = 1, message = "转入者ID不能小于{value}")
    @JsonProperty
    private Integer to;

    @NotNull(message = "转账金额不能为空")
    @Digits(integer = 12, fraction = 2, message = "转账金额必须在{integer}位整数和{fraction}位小数之间")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999999.99")
    @JsonProperty
    private Double amount;

}
