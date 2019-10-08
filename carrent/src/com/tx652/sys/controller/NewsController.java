package com.tx652.sys.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.sys.domain.News;
import com.tx652.sys.domain.User;
import com.tx652.sys.service.NewsService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.sys.utils.WebUtils;
import com.tx652.sys.vo.NewsVo;

/**
 * 
 * 公告管理控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	
	
	@RequestMapping("loadAllNews")
	public DataGridView loadAllNews(NewsVo newsVo) {
		return this.newsService.queryAllnews(newsVo);
	}
	/**
	 * 
	 * 添加公告
	 */
	@RequestMapping("addNews")
	public ResultObj addNews(NewsVo newsVo) {
		
		try {
			User user = (User) WebUtils.getHttpSession().getAttribute("user");
			newsVo.setCreatetime(new Date());
			newsVo.setOpername(user.getRealname());
			this.newsService.addNews(newsVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 
	 * 修改公告
	 */
	@RequestMapping("updateNews")
	public ResultObj updateNews(NewsVo newsVo) {
		
		try {
			this.newsService.updateNews(newsVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}	

	
	/**
	 * 
	 * 删除公告
	 */
	
	@RequestMapping("deleteNews")
	public ResultObj delete(NewsVo newsVo) {
		
		try {
			this.newsService.deleteNews(newsVo.getId());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}

	
	/**
	 * 
	 * 批量删除公告
	 */
	
	@RequestMapping("deleteBatchNews")
	public ResultObj deleteBatchNews(NewsVo newsVo) {
		
		try {
			this.newsService.deleteBatchNews(newsVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 根据id查询公告
	 */
	@RequestMapping("loadNewsById")
	public News loadNewsById(Integer id) {
		return this.newsService.queryNewsById(id);
	}
	

}
