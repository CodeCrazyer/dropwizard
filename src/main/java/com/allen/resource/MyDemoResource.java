package com.allen.resource;

import com.allen.api.TransferDto;
import com.allen.dao.TestAllenDao;
import com.allen.domain.TestAllen;
import com.allen.provider.person.PersonProvider;
import com.codahale.metrics.annotation.Timed;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-07 17:06
 * Version  1.0
 */
@Setter
@Getter
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyDemoResource {

    private TestAllenDao testAllenDao;
    private PersonProvider personProvider;

    public MyDemoResource(PersonProvider personProvider,TestAllenDao testAllenDao) {
        this.testAllenDao = testAllenDao;
        this.personProvider = personProvider;
    }

    @POST
    @Timed
    @Path("/hello")
    public Response hello(@HeaderParam("name") String name,
                          @QueryParam("age") Integer age,
                          @QueryParam("sex") Integer sex) {
        personProvider.setName(name);
        personProvider.setAge(age);
        personProvider.setSex(sex);
        return Response.ok(personProvider).build();
    }


    @GET
    @Path("/findAll")
    public Response findAll() {
        List<TestAllen> list = testAllenDao.findAll();
        return Response.ok(list).build();
    }

    @POST
    @Path("/transfer")
    public Response transferAccount(@Valid TransferDto transferDto) throws Exception {
        testAllenDao.transfer(transferDto);
        return Response.ok().build();
    }
}
