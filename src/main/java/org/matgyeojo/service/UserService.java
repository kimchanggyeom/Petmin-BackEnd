package org.matgyeojo.service;

import org.matgyeojo.dto.Preference;
import org.matgyeojo.dto.Users;
import org.matgyeojo.repository.PreferenceRepo;
import org.matgyeojo.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UsersRepo UsersRepo;
	
	@Autowired
	PreferenceRepo PreferenceRepo;
	
	public boolean checkDuplicateId(String userId) {
		return UsersRepo.existsByUserId(userId);
	}
	
	public String signup(Users dto) {
		try {
			UsersRepo.save(dto);
			return "회원가입 성공";
		} catch (Exception e) {
			return "회원가입 실패";
		}
	}
	
 	//카드 등록
	public Users registerCard(Users users) {
		Users user =UsersRepo.findById(users.getUserId()).orElse(null);
		user.setUserCard(users.getUserCard());
		user.setUserCardpass(users.getUserCardpass());
		UsersRepo.save(user);
		return user;
	}
	
	//개인정보 수정 - 주소
	public Users updateAddress(Users users) {
		Users user = UsersRepo.findById(users.getUserId()).orElse(null);
		user.setUserAddress(users.getUserAddress());
		UsersRepo.save(user);
		return user;
	}
  
 	public String preferenceSave(Preference dto, String userId) {
		Users user = UsersRepo.findById(userId).orElse(null);
		if(user != null) {
			dto.setUser(user);
			PreferenceRepo.save(dto);
			return "선호도 저장 성공";
		} else {
			return "선호도 저장 실패";
		}
 	}
}
