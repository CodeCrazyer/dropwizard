package com.allen.provider.person;

import com.allen.provider.ProviderFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-07 16:45
 * Version  1.0
 */
@Data
@JsonTypeName("person")
public class PersonProviderFactory implements ProviderFactory<PersonProvider> {

    @JsonProperty
    private String name;
    @JsonProperty
    private Integer age;
    @JsonProperty
    private Integer sex;
    @JsonProperty
    private String hobby;

    public PersonProvider create() {
        return PersonProvider.builder()
                .name(name)
                .age(age)
                .sex(sex)
                .hobby(hobby)
                .build();
    }
}
