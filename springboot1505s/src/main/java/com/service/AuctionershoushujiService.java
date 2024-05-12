package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AuctionershoushujiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AuctionershoushujiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AuctionershoushujiView;


/**
 * 二手书籍竞拍记录表
 *
 * @author 
 * @email 
 * @date 2023-02-27 07:53:26
 */
public interface AuctionershoushujiService extends IService<AuctionershoushujiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AuctionershoushujiVO> selectListVO(Wrapper<AuctionershoushujiEntity> wrapper);
   	
   	AuctionershoushujiVO selectVO(@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);
   	
   	List<AuctionershoushujiView> selectListView(Wrapper<AuctionershoushujiEntity> wrapper);
   	
   	AuctionershoushujiView selectView(@Param("ew") Wrapper<AuctionershoushujiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AuctionershoushujiEntity> wrapper);
   	

}

