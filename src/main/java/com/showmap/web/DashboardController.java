package com.showmap.web;


import com.showmap.mapper.ShowMapMapper;
import com.showmap.service.MakeChartService;
import com.showmap.service.ShowMapService;
import com.showmap.vo.Param;
import com.showmap.vo.ProjectStatus;
import com.showmap.vo.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by WYKIM on 2017-08-17.
 */
@Controller
public class DashboardController {
    @Autowired
    private ShowMapMapper showMapMapper;

    @Autowired
    private MakeChartService makeChartService;

    @Autowired
    private ShowMapService showMapService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String dashboard(Model model) throws Exception
    {
        List<Zone> zoneList = showMapMapper.getZoneList(new Param());

        model.addAttribute("zoneList",zoneList);
        return "dashboard";
    }

    @RequestMapping(value="/dashboard/showlist", method = RequestMethod.GET)
    public String showlist(Model model, @ModelAttribute("Param") Param param) throws Exception
    {
        setParameter(param);
        List<ProjectStatus> projectStatusList = showMapService.getProjectStatusList(param);

        model.addAttribute("projectStatusList",projectStatusList);
        return "showmap/show_list";
    }

    @RequestMapping(value="/dashboard/showchart", method = RequestMethod.GET)
    public String showchart(Model model, @ModelAttribute("Param") Param param) throws Exception
    {
        setParameter(param);

        String chartLabel = makeChartService.getChartLabel(param);
        String chartData = makeChartService.getChartData(param);

        model.addAttribute("chartLabel",chartLabel);
        model.addAttribute("chartData",chartData);

        return "showmap/show_chart";
    }

    private void setParameter(@ModelAttribute("Param") Param param) {
        String code = param.getCode();
        code = code.substring(0,8);
        param.setCode(code + "%");
    }
}
