package com.showmap.service;

import com.showmap.mapper.ShowMapMapper;
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
public class MakeChartServiceTest {
    @Autowired
    private MakeChartService makeChartService;


    @Test
    public void test_chartLabel()throws Exception{
        String code = "KOR4413100000";
        code = code.substring(0,8);
        Param param = new Param();
        param.setCode(code + "%");
        String label = makeChartService.getChartLabel(param);
        System.out.println(label);
    }

    @Test
    public void test_chartData()throws Exception{
        String code = "KOR4413100000";
        code = code.substring(0,8);
        Param param = new Param();
        param.setCode(code + "%");
        String data = makeChartService.getChartData(param);
        System.out.println(data);
    }
}
