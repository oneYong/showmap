package com.showmap.web;


import com.showmap.mapper.ShowMapMapper;
import com.showmap.vo.Param;
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
        System.out.println("---showlist---");
        System.out.println(param.getCode());

        return "showmap/show_list";
    }

    @RequestMapping(value="/dashboard/showchart", method = RequestMethod.GET)
    public String showchart(Model model, @ModelAttribute("Param") Param param) throws Exception
    {

        System.out.println("---showchart---");
        System.out.println(param.getCode());

        return "showmap/show_chart";
    }
}
