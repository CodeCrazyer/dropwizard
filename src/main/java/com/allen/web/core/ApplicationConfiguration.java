package com.allen.web.core;

import com.allen.provider.ProviderFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.sql.DataSource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-07 16:27
 * Version  1.0
 */
@Data
public class ApplicationConfiguration extends Configuration {


    @NotBlank
    private String template;
    private String defaultName;

    @Valid
    @NotNull
    @JsonProperty("person")
    private ProviderFactory providerFactory;

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

}
