package com.anl.card.persistence.mapper;

import com.anl.card.persistence.mapper.BaseMapper;
import com.anl.card.persistence.po.UserFlowUsedDay;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 类名: UserFlowUsedDay
 * 创建日期: 
 * 功能描述: 
 */
public interface UserFlowUsedDayMapper extends BaseMapper<UserFlowUsedDay> {
    Integer getBeforeUsedFlow(@Param("cardId") Integer cardId, @Param("monthFirstDay") Date monthFirstDay, @Param("currentDay") Date currentDay);
}