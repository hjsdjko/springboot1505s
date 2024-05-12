package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.AuctionershoushujiEntity;
import com.entity.view.AuctionershoushujiView;

import com.service.AuctionershoushujiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 二手书籍竞拍记录表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-27 07:53:26
 */
@RestController
@RequestMapping("/auctionershoushuji")
public class AuctionershoushujiController {
    @Autowired
    private AuctionershoushujiService auctionershoushujiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AuctionershoushujiEntity auctionershoushuji,
		HttpServletRequest request){
        EntityWrapper<AuctionershoushujiEntity> ew = new EntityWrapper<AuctionershoushujiEntity>();

		PageUtils page = auctionershoushujiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, auctionershoushuji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AuctionershoushujiEntity auctionershoushuji, 
		HttpServletRequest request){
        EntityWrapper<AuctionershoushujiEntity> ew = new EntityWrapper<AuctionershoushujiEntity>();

		PageUtils page = auctionershoushujiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, auctionershoushuji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AuctionershoushujiEntity auctionershoushuji){
       	EntityWrapper<AuctionershoushujiEntity> ew = new EntityWrapper<AuctionershoushujiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( auctionershoushuji, "auctionershoushuji")); 
        return R.ok().put("data", auctionershoushujiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AuctionershoushujiEntity auctionershoushuji){
        EntityWrapper< AuctionershoushujiEntity> ew = new EntityWrapper< AuctionershoushujiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( auctionershoushuji, "auctionershoushuji")); 
		AuctionershoushujiView auctionershoushujiView =  auctionershoushujiService.selectView(ew);
		return R.ok("查询二手书籍竞拍记录表成功").put("data", auctionershoushujiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AuctionershoushujiEntity auctionershoushuji = auctionershoushujiService.selectById(id);
        return R.ok().put("data", auctionershoushuji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AuctionershoushujiEntity auctionershoushuji = auctionershoushujiService.selectById(id);
        return R.ok().put("data", auctionershoushuji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AuctionershoushujiEntity auctionershoushuji, HttpServletRequest request){
    	auctionershoushuji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(auctionershoushuji);
        auctionershoushujiService.insert(auctionershoushuji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AuctionershoushujiEntity auctionershoushuji, HttpServletRequest request){
    	auctionershoushuji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(auctionershoushuji);
        List<AuctionershoushujiEntity> alist = auctionershoushujiService.selectList(new EntityWrapper<AuctionershoushujiEntity>().eq("refid", auctionershoushuji.getRefid()));
        if(alist!=null && alist.size()>0) {
            for(AuctionershoushujiEntity a : alist) {
                a.setAuctionstatus("出局");
            }
            auctionershoushujiService.updateBatchById(alist);
        }
        auctionershoushujiService.insert(auctionershoushuji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AuctionershoushujiEntity auctionershoushuji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(auctionershoushuji);
        auctionershoushujiService.updateById(auctionershoushuji);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        auctionershoushujiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<AuctionershoushujiEntity> wrapper = new EntityWrapper<AuctionershoushujiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = auctionershoushujiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
