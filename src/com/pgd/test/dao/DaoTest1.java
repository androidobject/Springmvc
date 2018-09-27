package com.pgd.test.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.pgd.test.util.BaseDaoOne;

@Repository
public class DaoTest1 extends BaseDaoOne {
	public void getUser() {
		String selectSql = "select name,age from user";
		String insertSql = "insert into user values(?,?)";
		SQLQuery query = this.getSession().createSQLQuery(selectSql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, String>> list = query.list();
		if (list.size() > 0) {
			for (Map<String, String> map : list) {
				System.out.print("name:" + map.get("name") + ",age" + map.get("age"));
			}
		} else {
			SQLQuery query2 = this.getSession().createSQLQuery(insertSql);
			query2.setParameter(0, "张三");
			query2.setParameter(1, 23);

		}
	}
}
