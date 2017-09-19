package com.showmap.mapper;

import com.showmap.vo.Param;
import com.showmap.vo.ProjectStatus;
import com.showmap.vo.Zone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

/**
 * Created by WYKIM on 2017-09-18.
 */
@Mapper
public interface ShowMapMapper {
    List<Zone> getZoneList(Param param) throws Exception;
    List<ProjectStatus> getProjectStatusList(Param param) throws Exception;
}
