package com.example.demo.dao;

import com.example.demo.entity.Area;
import java.util.List;

public interface AreaDao
{
	/**
	 * 列出区域列表
	 * @return areaList
	 */
    List<Area> queryArea();

	/**
	 * 根据ID列出具体区域
	 * @param id
	 * @return area
	 */
	Area queryAreaById(int id);

	/**
	 * 插入区域信息
	 * @param area
	 * @return
	 */
    int insertArea(Area area);

	/**
	 * 更新区域信息
	 * @param area
	 * @return
	 */
	int updateArea(Area area);

	/**
	 * 删除区域信息
	 * @param areaId
	 * @return
	 */
    int deleteArea(int areaId);

}
