package com.pgd.test.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoOne extends HibernateDaoSupport {
	// 对应数据库spmhbe
	@Resource(name = "sessionFactory")
	public void setSession(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
}
