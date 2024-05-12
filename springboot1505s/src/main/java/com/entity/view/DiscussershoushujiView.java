package com.entity.view;

import com.entity.DiscussershoushujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 二手书籍评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-27 07:53:26
 */
@TableName("discussershoushuji")
public class DiscussershoushujiView  extends DiscussershoushujiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussershoushujiView(){
	}
 
 	public DiscussershoushujiView(DiscussershoushujiEntity discussershoushujiEntity){
 	try {
			BeanUtils.copyProperties(this, discussershoushujiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
