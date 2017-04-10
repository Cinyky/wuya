package com.wuya.cyy.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.ShareDao;
import com.wuya.cyy.dao.UpvoteDao;
import com.wuya.cyy.pojo.Share;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.service.ShareService;
import com.wuya.cyy.service.UpvoteService;
/**
 * demo service Impl
 * @author Cinyky
 * junliang mint
 * 6 Apr 2017 17:14:34
 */
@Service
public class ShareServiceImpl implements ShareService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ShareDao shareDao;

	@Override
	public boolean shareAdd(Share share) {
		return shareDao.addShare(share)>0;
	}

	@Override
	public boolean shareUpdate(Share share) {
		return shareDao.updateShare(share)>0;
	}

	@Override
	public List<Share> shareSelectByUid(String uid) {
		return shareDao.selectShareByUid(uid);
	}


	@Override
	public List<Share> shareSelectByType(int shareType) {
		return shareDao.selectShareByType(shareType);
	}

	@Override
	public List<Share> shareSelectByTypeAndUid(int shareType, String uid) {
		return shareDao.selectShareByTypeAndUid(shareType, uid);
	}

}
