package com.wuya.cyy.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.FriendDao;
import com.wuya.cyy.dao.UpvoteDao;
import com.wuya.cyy.pojo.Friend;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.service.FriendService;
import com.wuya.cyy.service.UpvoteService;
/**
 * friend service
 * Cinyky 
 *
 * 2017年4月9日下午4:21:57
 */
@Service
public class FriendServiceImpl implements FriendService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FriendDao friendDao;

	@Override
	public boolean friendAdd(Friend friend) {
		return friendDao.addFriend(friend)>0;
	}

	@Override
	public boolean friendUpdate(Friend friend) {
		return friendDao.updateFriend(friend)>0;
	}

	@Override
	public List<Friend> friendSelectByUid(String uid) {
		return friendDao.selectFriendByUid(uid);
	}

	@Override
	public List<Friend> friendSelectByAnotherUid(String anotherUid) {
		return friendDao.selectFriendByAnotherUid(anotherUid);
	}

	@Override
	public String friendCountSelectByUid(String uid) {
		return friendDao.selectFriendCountByUid(uid);
	}

	@Override
	public String friendCountSelectByAnotherUid(String anotherUid) {
		return friendDao.selectFriendCountByAnotherUid(anotherUid);
	}

	@Override
	public boolean friendDelete(String uid, String anotherUid) {
		return friendDao.deleteFriend(uid,anotherUid)>0;
	}

	@Override
	public boolean friendExsist(String uid, String anotherUid) {
		return friendDao.selectFriendExsist(uid, anotherUid)!=null;
	}

}
