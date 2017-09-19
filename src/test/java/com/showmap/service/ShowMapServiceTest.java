package com.showmap.service;

import com.showmap.vo.Param;
import com.showmap.vo.ProjectStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by WYKIM on 2017-09-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ShowMapServiceTest {
    @Autowired
    private ShowMapService showMapService;


    @Test
    public void test_getProjectStatusList()throws Exception{
        String code = "KOR4413100000";
        code = code.substring(0,8);
        Param param = new Param();
        param.setCode(code + "%");
        List<ProjectStatus> projectStatusList = showMapService.getProjectStatusList(param);
        System.out.println(projectStatusList);
    }

}
