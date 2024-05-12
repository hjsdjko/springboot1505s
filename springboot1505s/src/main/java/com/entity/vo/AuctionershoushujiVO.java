package com.entity.vo;

import com.entity.AuctionershoushujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 二手书籍竞拍记录表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-27 07:53:26
 */
public class AuctionershoushujiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户id
	 */
	
	private Long userid;
		
	/**
	 * 用户名
	 */
	
	private String nickname;
		
	/**
	 * 头像
	 */
	
	private String avatarurl;
		
	/**
	 * 竞拍价格
	 */
	
	private Float auctionprice;
		
	/**
	 * 竞拍状态
	 */
	
	private String auctionstatus;
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getNickname() {
		return nickname;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	
	/**
	 * 获取：头像
	 */
	public String getAvatarurl() {
		return avatarurl;
	}
				
	
	/**
	 * 设置：竞拍价格
	 */
	 
	public void setAuctionprice(Float auctionprice) {
		this.auctionprice = auctionprice;
	}
	
	/**
	 * 获取：竞拍价格
	 */
	public Float getAuctionprice() {
		return auctionprice;
	}
				
	
	/**
	 * 设置：竞拍状态
	 */
	 
	public void setAuctionstatus(String auctionstatus) {
		this.auctionstatus = auctionstatus;
	}
	
	/**
	 * 获取：竞拍状态
	 */
	public String getAuctionstatus() {
		return auctionstatus;
	}
			
}
