package com.tx652.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tx652.sys.domain.News;
import com.tx652.sys.mapper.NewsMapper;
import com.tx652.sys.service.NewsService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.NewsVo;

@Service
public class NewsServiceImp implements NewsService {
	
	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public DataGridView queryAllnews(NewsVo newsVo) {
		Page<Object> page = PageHelper.startPage(newsVo.getPage(), newsVo.getLimit());
		List<News> data = this.newsMapper.queryAllNews(newsVo);
		
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addNews(NewsVo newsVo) {
		this.newsMapper.insertSelective(newsVo);
	}

	@Override
	public void deleteNews(Integer newsid) {
		this.newsMapper.deleteByPrimaryKey(newsid);
	}

	@Override
	public void deleteBatchNews(Integer[] ids) {
		for (Integer id : ids) {
			this.deleteNews(id);
		}
	}

	@Override
	public void updateNews(NewsVo newsVo) {
		this.newsMapper.updateByPrimaryKeySelective(newsVo);
	}

	@Override
	public News queryNewsById(Integer id) {
		return this.newsMapper.selectByPrimaryKey(id);
	}

}
