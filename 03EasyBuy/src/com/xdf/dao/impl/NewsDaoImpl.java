package com.xdf.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xdf.bean.Easybuy_News;
import com.xdf.dao.NewsDao;
import com.xdf.util.BaseDao;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����11:57:25
 * 
 * ���ŵ�ʵ����  �����������ݿ�
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

	/**
	 * ��������
	 */
	@Override
	public int addNews(Easybuy_News news) {
		String sql = "INSERT INTO easybuy_news(title,content,createTime) VALUES (?,?,?)";
		Object[] params = { news.getTitle(), news.getContent(), new Date() };
		// ���ø���ķ���
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * ����idɾ������
	 */
	@Override
	public int deleteNewsById(Serializable id) {
		String sql = "delete  from easybuy_news where id=?";
		Object[] params = { id };
		// ���ø���ķ���
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * ���ŵ��޸�
	 */
	@Override
	public int updateNews(Easybuy_News news) {
		String sql = "update   easybuy_news set title=?,content=?  where id=?";
		Object[] params = { news.getTitle(), news.getContent(), news.getId() };
		// ���ø���ķ���
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * ��ѯ��������
	 */
	@Override
	public List<Easybuy_News> selectNews() {
		List<Easybuy_News> lists = new ArrayList<>();

		String sql = "select * from easybuy_news";
		rs = executeQuery(sql);
		try {
			while (rs.next()) {
				Easybuy_News news = new Easybuy_News();
				news.setId(rs.getInt("id"));
				news.setContent(rs.getString("content"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getTimestamp("createTime"));
				lists.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lists;
	}

}
