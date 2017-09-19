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
public class ShowMapService {
    @Autowired
    private ShowMapMapper showMapMapper;

    public List<ProjectStatus> getProjectStatusList(Param param) throws Exception{

        int[] projectSum = {
                0,0,0,0,0
                ,0,0,0,0,0
                ,0,0,0,0,0
        };

        List<ProjectStatus> projectStatusList = showMapMapper.getProjectStatusList(param);
        ProjectStatus newProjectStatus = new ProjectStatus();
        newProjectStatus.setZoneName("합 계");
        if(projectStatusList.size() != 0){
            for(int i = 0; i < projectSum.length; i++){
                makeTotalValue(projectStatusList,newProjectStatus,i,projectSum);
            }
            projectStatusList.add(newProjectStatus);
        }

        return projectStatusList;
    }

    private void makeTotalValue(List<ProjectStatus> projectStatusList,ProjectStatus newProjectStatus, int i,int[] projectSum) {

        for(int j = 0; j < projectStatusList.size(); j++){
            ProjectStatus projectStatus = projectStatusList.get(j);
            if(i == 0){
                projectSum[i] += projectStatus.getBusinessName1();
            }else if(i == 1){
                projectSum[i] += projectStatus.getBusinessName2();
            }else if(i == 2){
                projectSum[i] += projectStatus.getBusinessName3();
            }else if(i == 3){
                projectSum[i] += projectStatus.getBusinessName4();
            }else if(i == 4){
                projectSum[i] += projectStatus.getBusinessName5();
            }else if(i == 5){
                projectSum[i] += projectStatus.getBusinessName6();
            }else if(i == 6){
                projectSum[i] += projectStatus.getBusinessName7();
            }else if(i == 7){
                projectSum[i] += projectStatus.getBusinessName8();
            }else if(i == 8){
                projectSum[i] += projectStatus.getBusinessName9();
            }else if(i == 9){
                projectSum[i] += projectStatus.getBusinessName10();
            }else if(i == 10){
                projectSum[i] += projectStatus.getBusinessName11();
            }else if(i == 11){
                projectSum[i] += projectStatus.getBusinessName12();
            }else if(i == 12){
                projectSum[i] += projectStatus.getBusinessName13();
            }else if(i == 13){
                projectSum[i] += projectStatus.getBusinessName14();
            }else if(i == 14){
                projectSum[i] += projectStatus.getBusinessName15();
            }
        }

        if(i == 0){
            newProjectStatus.setBusinessName1(projectSum[i]);
        }else if(i == 1){
            newProjectStatus.setBusinessName2(projectSum[i]);
        }else if(i == 2){
            newProjectStatus.setBusinessName3(projectSum[i]);
        }else if(i == 3){
            newProjectStatus.setBusinessName4(projectSum[i]);
        }else if(i == 4){
            newProjectStatus.setBusinessName5(projectSum[i]);
        }else if(i == 5){
            newProjectStatus.setBusinessName6(projectSum[i]);
        }else if(i == 6){
            newProjectStatus.setBusinessName7(projectSum[i]);
        }else if(i == 7){
            newProjectStatus.setBusinessName8(projectSum[i]);
        }else if(i == 8){
            newProjectStatus.setBusinessName9(projectSum[i]);
        }else if(i == 9){
            newProjectStatus.setBusinessName10(projectSum[i]);
        }else if(i == 10){
            newProjectStatus.setBusinessName11(projectSum[i]);
        }else if(i == 11){
            newProjectStatus.setBusinessName12(projectSum[i]);
        }else if(i == 12){
            newProjectStatus.setBusinessName13(projectSum[i]);
        }else if(i == 13){
            newProjectStatus.setBusinessName14(projectSum[i]);
        }else if(i == 14){
            newProjectStatus.setBusinessName15(projectSum[i]);
        }

    }
}
