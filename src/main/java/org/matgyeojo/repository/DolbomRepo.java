package org.matgyeojo.repository;

import java.util.List;

import org.matgyeojo.dto.Dolbom;
import org.matgyeojo.dto.Users;
import org.springframework.data.repository.CrudRepository;

public interface DolbomRepo extends CrudRepository<Dolbom, Integer>{

	//펫시터 가능한 날짜 필터링
	public List<Dolbom> findByScheduleDay(String scheduleDay);
	//펫시터 돌봄옵션 필터링
	public List<Dolbom> findByDolbomOptionLike(String dolbomOption);
	//펫시터가 누군지 필터링
	public List<Dolbom> findByUser2(Users user);
}
