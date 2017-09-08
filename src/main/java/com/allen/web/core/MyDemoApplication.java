package com.allen.web.core;

import com.allen.dao.TestAllenDao;
import com.allen.healthcheck.ApplicationHealthCheck;
import com.allen.provider.person.PersonProvider;
import com.allen.resource.MyDemoResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-07 16:58
 * Version  1.0
 */
public class MyDemoApplication extends Application<ApplicationConfiguration>{

    public static void main(String[] args) throws Exception {
        new MyDemoApplication().run(args);
    }

    public void run(ApplicationConfiguration ac, Environment environment) {

        final ApplicationHealthCheck healthCheck = new ApplicationHealthCheck(ac.getTemplate(), ac.getDefaultName());
        environment.healthChecks().register("template", healthCheck);

        final PersonProvider pv = (PersonProvider) ac.getProviderFactory().create();
        final DBIFactory dbiFactory = new DBIFactory();
        final DBI dbi = dbiFactory.build(environment, ac.getDataSourceFactory(), "mysql");
        final TestAllenDao testAllenDao = dbi.onDemand(TestAllenDao.class);
        environment.jersey().register(new MyDemoResource(pv, testAllenDao));

    }
}
