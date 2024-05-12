package com.dao;

import com.entity.ErshoushujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErshoushujiVO;
import com.entity.view.ErshoushujiView;


/**
 * 二手书籍
 * 
 * @author 
 * @email 
 * @date 2023-02-27 07:53:25
 */
public interface ErshoushujiDao extends BaseMapper<ErshoushujiEntity> {
	
	List<ErshoushujiVO> selectListVO(@Param("ew") Wrapper<ErshoushujiEntity> wrapper);
	
	ErshoushujiVO selectVO(@Param("ew") Wrapper<ErshoushujiEntity> wrapper);
	
	List<ErshoushujiView> selectListView(@Param("ew") Wrapper<ErshoushujiEntity> wrapper);

	List<ErshoushujiView> selectListView(Pagination page,@Param("ew") Wrapper<ErshoushujiEntity> wrapper);
	
	ErshoushujiView selectView(@Param("ew") Wrapper<ErshoushujiEntity> wrapper);
	

}
