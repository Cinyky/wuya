package com.wuya.cyy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.AdviceDao;
import com.wuya.cyy.pojo.Advice;
import com.wuya.cyy.service.AdviceService;
/**
 * Advice Service
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:47:58
 */
@Service
public class AdviceServiceImpl  implements AdviceService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdviceDao adviceDao;

	@Override
	public boolean adviceAdd(Advice advice) {
		return adviceDao.addAdvice(advice)>0;
	}

	@Override
	public boolean adviceUpdate(Advice advice) {
		return adviceDao.updateAdvice(advice)>0;
	}

	@Override
	public Advice adviceSelectByAdviceId(String adviceId) {
		return adviceDao.selectAdviceByAdviceID(adviceId);
	}

	@Override
	public List<Advice> adviceSelectByUid(String uid) {
		return adviceDao.selectAdviceByUid(uid);
	}

	@Override
	public List<Advice> adviceSelect() {
		return adviceDao.selectAdvice();
	}



	

}
