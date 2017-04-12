package com.wuya.cyy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.UserDao;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.UserService;
import com.wuya.cyy.utils.MD5Util;
import com.wuya.cyy.utils.SendEmail;
/**
 * UserService
 * @author Cinyky
 * junliang mint
 * 29 Mar 2017 16:22:57
 */
@Service
public class UserServiceImpl  implements UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String ACTIVATE_URL = "http://localhost:8080/wuya/user/activate";
	private static final String FINDPWD_URL = "http://localhost:8080/wuya/user/findpwd?action=verify";
	@Autowired
	private UserDao userDao;
	@Override
	public boolean userReg(String loginName, String pwd, String bind_email,String nickName) {
		// TODO reg
		boolean isSuccess = false;
		User user= new User(loginName, pwd, bind_email, nickName);
		isSuccess = processReg(user.getBind_email(),user.getEmail_code(),"reg");
		logger.warn("user"+user);
		if(isSuccess){
			int affectRow = userDao.addUser(user);
			isSuccess = affectRow>0;
			logger.warn("success");
		}
		return isSuccess;
	}
	
	@Override
	public User userLogin(String loginCondition, String pwd) {
		User user = null;
		pwd = MD5Util.encode2hex(pwd);
		user = userDao.selectUserByLoginNameAndPwd(loginCondition, pwd);
		if(user == null){
			user = userDao.selectUserByEmailAndPwd(loginCondition, pwd);
			if(user ==null){
				user = userDao.selectUserByNickNameAndPwd(loginCondition, pwd);
			}
		}
		return user;
	}

	@Override
	public List<User> userSelect(String nickName) {
		List<User> users = new ArrayList<>();
		users = userDao.selectUserByNickName(nickName);
		return users;
	}

	@Override
	public boolean userActicate(String bind_email, String code) {
		User user =null;
		boolean isActivate = false;
		user  = userDao.selectUserByEmail(bind_email);
		if(user!=null && code.equals(user.getEmail_code())){
			user.setStatus(0);
			int affectRow = userDao.updateUser(user);
			isActivate = affectRow>0;
		}
		return isActivate;
	}



	
	//处理注册 发送邮件
	private boolean processReg(String bind_email,String email_code,String method){
		 ///邮件的内容  
        String mailInfo = generatMailInfo(bind_email, email_code, method);
      //发送邮件  
        logger.debug("SendEmail to"+bind_email+" emailIndo:"+mailInfo);
        return SendEmail.send(bind_email, mailInfo.toString());
	}
	//产生邮件
	private String generatMailInfo(String bind_email,String email_code,String method){
		StringBuffer mailInfo=new StringBuffer();
		if("reg".equals(method)){
			mailInfo.append("点击下面链接激活账号，10分钟内有效，否则重新注册账号，链接只能使用一次，请尽快激活！<br/>");
			mailInfo.append("<a href='"+ACTIVATE_URL+"?email=");  
		    mailInfo.append(bind_email);   
		    mailInfo.append("&validateCode=");   
		    mailInfo.append(email_code);  
		    mailInfo.append("'>点此激活");   
		    mailInfo.append("</a>");
		}else if("findpwd".equals(method)){
			mailInfo.append("点击下面链接找回密码，10分钟内有效，否则重新发送，链接只能使用一次，请尽快使用！<br/>");
			mailInfo.append("<a href='"+FINDPWD_URL+"&email=");  
		    mailInfo.append(bind_email);   
		    mailInfo.append("&validateCode=");   
		    mailInfo.append(email_code);  
		    mailInfo.append("'>点此激活");   
		    mailInfo.append("</a>");
		}
		return mailInfo.toString();
	}

	@Override
	public User userSelectByUid(String uid) {
		return userDao.selectUserByUid(uid);
	}

	@Override
	public boolean userUpdate(User user) {
		return userDao.updateUser(user)>0;
	}

}
