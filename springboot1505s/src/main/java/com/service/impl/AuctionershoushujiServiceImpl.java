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


import com.dao.AuctionershoushujiDao;
import com.entity.AuctionershoushujiEntity;
import com.service.AuctionershoushujiService;
import com.entity.vo.AuctionershoushujiVO;
import com.entity.view.AuctionershoushujiView;

@Service("auctionershoushujiService")
public class AuctionershoushujiServiceImpl extends ServiceImpl<AuctionershoushujiDao, AuctionershoushujiEntity> implements AuctionershoushujiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AuctionershoushujiEntity> page = this.selectPage(
                new Query<AuctionershoushujiEntity>(params).getPage(),
                new EntityWrapper<AuctionershoushujiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AuctionershoushujiEntity> wrapper) {
		  Page<AuctionershoushujiView> page =new Query<AuctionershoushujiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<AuctionershoushujiVO> selectListVO(Wrapper<AuctionershoushujiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AuctionershoushujiVO selectVO(Wrapper<AuctionershoushujiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AuctionershoushujiView> selectListView(Wrapper<AuctionershoushujiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AuctionershoushujiView selectView(Wrapper<AuctionershoushujiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
