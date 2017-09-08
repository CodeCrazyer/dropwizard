package com.allen.provider;

import com.allen.provider.person.PersonProviderFactory;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.dropwizard.jackson.Discoverable;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-07 16:31
 * Version  1.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({@JsonSubTypes.Type(name = "allen", value = PersonProviderFactory.class)})
public interface ProviderFactory<T extends Provider> extends Discoverable {
    T create();
}
