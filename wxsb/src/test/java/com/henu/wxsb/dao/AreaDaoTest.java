package com.henu.wxsb.dao;

import com.henu.wxsb.entity.Area;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testAQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        // 验证预期值和实际值是否相符
        assertEquals(2, areaList.size());
    }

    @Test
    public void testBInsertArea() {
        //创建一个区域对象
        Area area = new Area();
        area.setAreaName("南苑");
        area.setCreateTime(new Date());
        area.setPriority(1);
        //将该对象实例添加入库
        int effectedNum = areaDao.insertArea(area);
        //检测影响行数
        assertEquals(1, effectedNum);
    }

    @Test
    public void testCQueryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    public void testDUpateArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testEDeleteArea() {
        int effectedNum = areaDao.deleteArea(3);
        assertEquals(1, effectedNum);
    }
}