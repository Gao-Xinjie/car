package com.tx652.sys.service;


import com.tx652.sys.domain.News;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.NewsVo;

/**
 * 
 * 公告管理的服务接口
 * @author 高鑫杰
 *
 */


public interface NewsService {

	/**
	 * 
	 * 查询所有公告
	 * @param newsVo
	 * @return
	 */
	public DataGridView queryAllnews(NewsVo newsVo);
	/**
	 * 
	 * 添加公告
	 * @param newsVo
	 */
	public void addNews(NewsVo newsVo);
	/**
	 * 
	 * 修改公告
	 * @param newsVo
	 */
	public void updateNews(NewsVo newsVo);

	/**
	 * 
	 * 根据id删除公告
	 * @param newsid
	 */
	public void deleteNews(Integer newsid);
	
	/**
	 * 批量删除公告
	 * 
	 */
	public void deleteBatchNews(Integer [] ids);
	/**
	 * 
	 * 主页显示公告根据id查询
	 * @param id
	 * @return
	 */
	
	public News queryNewsById(Integer id);
	
}
