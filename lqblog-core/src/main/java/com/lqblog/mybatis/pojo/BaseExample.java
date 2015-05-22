package com.lqblog.mybatis.pojo;

public abstract class BaseExample {

	protected Page page;

	public void setPage(Page page) {
		this.page = page;
	}

	public Page getPage() {
		return page;
	}
}
