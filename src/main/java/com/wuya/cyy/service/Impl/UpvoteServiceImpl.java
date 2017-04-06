package com.wuya.cyy.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.UpvoteDao;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.service.UpvoteService;
/**
 * upvote service Impl
 * @author Cinyky
 * junliang mint
 * 6 Apr 2017 17:14:34
 */
@Service
public class UpvoteServiceImpl implements UpvoteService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UpvoteDao upvoteDao;
	
	@Override
	public boolean upvoteAdd(Upvote upvote) {
		return upvoteDao.addUpvote(upvote)>0;
	}

	@Override
	public boolean upvoteUpdate(Upvote upvote) {
		return upvoteDao.updateUpvote(upvote)>0;
	}

	@Override
	public List<Upvote> upvoteSelectByUid(String uid) {
		return upvoteDao.selectUpvoteByUid(uid);
	}

	@Override
	public Upvote upvoteSelectByUpvoteId(String upvoteId) {
		return upvoteDao.selectUpvoteByUpvoteId(upvoteId);
	}

	@Override
	public List<Upvote> upvoteSelectByAnswerId(String answerId) {
		return upvoteDao.selectUpvoteByAnswerId(answerId);
	}

	@Override
	public String upvoteCountSelectByAnswerId(String answerId) {
		return upvoteDao.selectUpvoteCountByAnswerId(answerId);
	}

	@Override
	public boolean upvoteSelectByAnswerIdAndUid(String answerId, String uid) {
		return upvoteDao.selectUpvoteByAnswerIdAndUid(answerId, uid)!=null;
	}

}
