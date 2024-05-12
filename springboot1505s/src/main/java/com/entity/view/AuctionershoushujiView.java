package com.entity.view;

import com.entity.AuctionershoushujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 二手书籍竞拍记录表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-27 07:53:26
 */
@TableName("auctionershoushuji")
public class AuctionershoushujiView  extends AuctionershoushujiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AuctionershoushujiView(){
	}
 
 	public AuctionershoushujiView(AuctionershoushujiEntity auctionershoushujiEntity){
 	try {
			BeanUtils.copyProperties(this, auctionershoushujiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
