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


import com.dao.DiscussershoushujiDao;
import com.entity.DiscussershoushujiEntity;
import com.service.DiscussershoushujiService;
import com.entity.vo.DiscussershoushujiVO;
import com.entity.view.DiscussershoushujiView;

@Service("discussershoushujiService")
public class DiscussershoushujiServiceImpl extends ServiceImpl<DiscussershoushujiDao, DiscussershoushujiEntity> implements DiscussershoushujiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussershoushujiEntity> page = this.selectPage(
                new Query<DiscussershoushujiEntity>(params).getPage(),
                new EntityWrapper<DiscussershoushujiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussershoushujiEntity> wrapper) {
		  Page<DiscussershoushujiView> page =new Query<DiscussershoushujiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussershoushujiVO> selectListVO(Wrapper<DiscussershoushujiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussershoushujiVO selectVO(Wrapper<DiscussershoushujiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussershoushujiView> selectListView(Wrapper<DiscussershoushujiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussershoushujiView selectView(Wrapper<DiscussershoushujiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
