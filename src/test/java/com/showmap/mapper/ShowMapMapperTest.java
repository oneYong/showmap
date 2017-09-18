package com.showmap.mapper;

import com.showmap.vo.Param;
import com.showmap.vo.ProjectStatus;
import com.showmap.vo.Zone;
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
public class ShowMapMapperTest {
    @Autowired
    private ShowMapMapper showMapMapper;

    @Test
    public void test_ZONE리스트()throws Exception{
        Param param = new Param();
        List<Zone> zoneList = showMapMapper.getZoneList(param);
        System.out.println(zoneList);
    }

    @Test
    public void test_ProjectStatus리스트()throws Exception{
        String code = "KOR4413100000";
        code = code.substring(0,8);
        System.out.println(code);
        Param param = new Param();
        param.setCode(code + "%");
        List<ProjectStatus> projectStatusList = showMapMapper.getProjectStatusList(param);
        System.out.println(projectStatusList);
    }
}
