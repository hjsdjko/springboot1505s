package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ErshoushujiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ErshoushujiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ErshoushujiView;


/**
 * 二手书籍
 *
 * @author 
 * @email 
 * @date 2023-02-27 07:53:25
 */
public interface ErshoushujiService extends IService<ErshoushujiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ErshoushujiVO> selectListVO(Wrapper<ErshoushujiEntity> wrapper);
   	
   	ErshoushujiVO selectVO(@Param("ew") Wrapper<ErshoushujiEntity> wrapper);
   	
   	List<ErshoushujiView> selectListView(Wrapper<ErshoushujiEntity> wrapper);
   	
   	ErshoushujiView selectView(@Param("ew") Wrapper<ErshoushujiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ErshoushujiEntity> wrapper);
   	

}

