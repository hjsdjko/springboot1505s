package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ErshoushujiDao;
import com.entity.ErshoushujiEntity;
import com.service.ErshoushujiService;
import com.entity.vo.ErshoushujiVO;
import com.entity.view.ErshoushujiView;

@Service("ershoushujiService")
public class ErshoushujiServiceImpl extends ServiceImpl<ErshoushujiDao, ErshoushujiEntity> implements ErshoushujiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErshoushujiEntity> page = this.selectPage(
                new Query<ErshoushujiEntity>(params).getPage(),
                new EntityWrapper<ErshoushujiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ErshoushujiEntity> wrapper) {
		  Page<ErshoushujiView> page =new Query<ErshoushujiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ErshoushujiVO> selectListVO(Wrapper<ErshoushujiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ErshoushujiVO selectVO(Wrapper<ErshoushujiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ErshoushujiView> selectListView(Wrapper<ErshoushujiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ErshoushujiView selectView(Wrapper<ErshoushujiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
