package com.showmap.service;

import com.showmap.mapper.ShowMapMapper;
import com.showmap.vo.Param;
import com.showmap.vo.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WYKIM on 2017-09-19.
 */
@Service
public class MakeChartService {

    @Autowired
    private ShowMapMapper showMapMapper;

    // label list == color list
    private String[] labelList = {"'마을학교'","'현장포럼'","'우수마을'","'선행사업'","'창조적경관생태'"
            ,"'창조적소득체험'","'창조적문화복지'","'창조적마을종합'","'권역단위'","'면소재지정비'"
            ,"'읍소재지정비'","'중심지선도'","'중심지일반'","'농촌체험'","'농촌인성'"
    };
    private String[] colorList = {"'#ff6384'","'#36a2eb'","'#cc65fe'","'#36a2eb'","'#cc65fe'"
            ,"'#CCFF00'","'#CCFFCC'","'#FFFF99'","'#CCCC00'","'#CCCCCC'"
            ,"'#FFCC99'","'#CC9900'","'#CC99CC'","'#FF9999'","'#CC6600'"
    };

    private String chartLabel = "";
    private String chartData = "";

    public String getChartLabel(Param param) throws Exception{
        List<ProjectStatus> projectStatusList = showMapMapper.getProjectStatusList(param);
        chartLabel = "";
        for(int i = 0; i < projectStatusList.size(); i++){
            ProjectStatus projectStatus = projectStatusList.get(i);
            chartLabel += "" + projectStatus.getZoneName() + ",";
        }
        if(projectStatusList.size() != 0)
            chartLabel = chartLabel.substring(0,chartLabel.length()-1);
        return chartLabel;
    }
    public String getChartData(Param param) throws Exception {
        chartData = "[";
        String templete = "{label: %s, backgroundColor: %s, borderColor: %s, data: [%s] }";
        List<ProjectStatus> projectStatusList = showMapMapper.getProjectStatusList(param);

        if(projectStatusList.size() != 0){
            for(int i = 0; i < labelList.length; i++){
                String label = labelList[i];
                String color = colorList[i];
                String data = makeDataString(projectStatusList, i);
                data = data.substring(0,data.length()-1);
                chartData += String.format(templete,label,color,color,data) +",";
            }

            chartData = chartData.substring(0,chartData.length()-1);
            chartData += "]";
        }else
            chartData = "";


        return chartData;
    }

    private String makeDataString(List<ProjectStatus> projectStatusList, int i) {
        String data = "";
        for(int j = 0; j < projectStatusList.size(); j++){
            ProjectStatus projectStatus = projectStatusList.get(j);
            if(i == 0){
                data += projectStatus.getBusinessName1() + ",";
            }else if(i == 1){
                data += projectStatus.getBusinessName2() + ",";
            }else if(i == 2){
                data += projectStatus.getBusinessName3() + ",";
            }else if(i == 3){
                data += projectStatus.getBusinessName4() + ",";
            }else if(i == 4){
                data += projectStatus.getBusinessName5() + ",";
            }else if(i == 5){
                data += projectStatus.getBusinessName6() + ",";
            }else if(i == 6){
                data += projectStatus.getBusinessName7() + ",";
            }else if(i == 7){
                data += projectStatus.getBusinessName8() + ",";
            }else if(i == 8){
                data += projectStatus.getBusinessName9() + ",";
            }else if(i == 9){
                data += projectStatus.getBusinessName10() + ",";
            }else if(i == 10){
                data += projectStatus.getBusinessName11() + ",";
            }else if(i == 11){
                data += projectStatus.getBusinessName12() + ",";
            }else if(i == 12){
                data += projectStatus.getBusinessName13() + ",";
            }else if(i == 13){
                data += projectStatus.getBusinessName14() + ",";
            }else if(i == 14){
                data += projectStatus.getBusinessName15() + ",";
            }
        }
        return data;
    }


}
