package com.henu.wxsb.service;

import com.henu.wxsb.entity.Area;

import java.util.List;

public interface AreaService {

    /**
     * 获取区域列表
     */
    List<Area> getAreaList();

    /**
     * 通过区域Id获取区域信息
     */
    Area getAreaById(int areaId);

    /**
     * 增加区域信息
     */
    boolean addArea(Area area);

    /**
     * 修改区域信息
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     */
    boolean deleteArea(int areaId);

}
