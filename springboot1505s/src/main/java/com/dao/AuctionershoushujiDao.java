package com.dao;

import com.entity.AuctionershoushujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AuctionershoushujiVO;
import com.entity.view.AuctionershoushujiView;


/**
 * 二手书籍竞拍记录表
 * 
 * @author 
 * @email 
 * @date 2023-02-27 07:53:26
 */
public interface AuctionershoushujiDao extends BaseMapper<AuctionershoushujiEntity> {
	
	List<AuctionershoushujiVO> selectListVO(@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);
	
	AuctionershoushujiVO selectVO(@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);
	
	List<AuctionershoushujiView> selectListView(@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);

	List<AuctionershoushujiView> selectListView(Pagination page,@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);
	
	AuctionershoushujiView selectView(@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);
	

}
