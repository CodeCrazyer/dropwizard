package com.allen.provider.person;

import com.allen.provider.Provider;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-07 16:39
 * Version  1.0
 */
@Data
@Builder
public class PersonProvider implements Provider {

    @JsonProperty
    private String name;
    @JsonProperty
    private Integer age;
    @JsonProperty
    private Integer sex;
    @JsonProperty
    private String hobby;

    public String talk() {
        return "hello";
    }

    public void eat() {
        System.out.println("i'm eating");
    }
}
