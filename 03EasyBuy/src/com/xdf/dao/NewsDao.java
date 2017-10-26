package com.xdf.dao;

import java.io.Serializable;
import java.util.List;

import com.xdf.bean.Easybuy_News;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����11:54:06
 * 
 * ��������ŵĲ����ӿ�
 */
public interface NewsDao {

	/**
	 * ���ŵ�����
	 * @param user   �û�ǰ�˴��ݹ����Ķ���
	 */
	public int addNews(Easybuy_News news);

	/**
	 * ������������ɾ��ָ��������
	 * @param id  �û�ǰ�˴��ݹ������û���
	 */
	public int deleteNewsById(Serializable id);

	/**
	 * �޸�ָ��������
	 * @param news �û�ǰ�˴��ݹ����Ķ���
	 */
	public int updateNews(Easybuy_News news);

	/**
	 * ��ѯ��������
	 * @return ���ż���
	 */
	public List<Easybuy_News> selectNews();

}
