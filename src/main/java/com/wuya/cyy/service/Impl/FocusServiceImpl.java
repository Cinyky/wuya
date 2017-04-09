package com.wuya.cyy.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.FocusDao;
import com.wuya.cyy.dao.UpvoteDao;
import com.wuya.cyy.pojo.Focus;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.service.FocusService;
import com.wuya.cyy.service.UpvoteService;
/**
 * focus service Impl
 * Cinyky 
 *
 * 2017年4月9日下午4:14:00
 */
@Service
public class FocusServiceImpl implements FocusService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FocusDao focusDao;

	@Override
	public boolean focusAdd(Focus focus) {
		return focusDao.addFocus(focus)>0;
	}

	@Override
	public boolean focusUpdate(Focus focus) {
		return focusDao.updateFocus(focus)>0;
	}
	
	@Override
	public boolean focusDelete(Focus focus) {
		return focusDao.deleteFocus(focus)>0;
	}


	@Override
	public List<Focus> focusSelectByUid(String uid) {
		return focusDao.selectFocusByUid(uid);
	}

	@Override
	public List<Focus> focusSelectByUidAndType(String uid, int focusType) {
		return focusDao.selectFocusByUidAndType(uid, focusType);
	}

	@Override
	public boolean focusExsist(Focus focus) {
		return focusDao.selectFocusExsist(focus)!=null;
	}
	@Override
	public String focusCount(String id) {
		return focusDao.selectFocusCount(id);
	}

}
