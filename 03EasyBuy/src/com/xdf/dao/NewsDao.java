package com.xdf.dao;

import java.io.Serializable;
import java.util.List;

import com.xdf.bean.Easybuy_News;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午11:54:06
 * 
 * 针对于新闻的操作接口
 */
public interface NewsDao {

	/**
	 * 新闻的新增
	 * @param user   用户前端传递过来的对象
	 */
	public int addNews(Easybuy_News news);

	/**
	 * 根据新闻名称删除指定的新闻
	 * @param id  用户前端传递过来的用户名
	 */
	public int deleteNewsById(Serializable id);

	/**
	 * 修改指定的新闻
	 * @param news 用户前端传递过来的对象
	 */
	public int updateNews(Easybuy_News news);

	/**
	 * 查询所有新闻
	 * @return 新闻集合
	 */
	public List<Easybuy_News> selectNews();

}
