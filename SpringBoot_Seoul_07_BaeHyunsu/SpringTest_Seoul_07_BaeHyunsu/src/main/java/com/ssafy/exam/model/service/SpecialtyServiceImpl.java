package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	
	//dao에 대한 의존성 주입, 하나만 존재하므로 Autowired 생략
	private final SpecialtyDao dao;
	
	public SpecialtyServiceImpl(SpecialtyDao dao) {
		this.dao = dao;
	}
	
	

	@Override
	public boolean addSpecialty(Specialty specialty) {
		int result = dao.insertSpecialty(specialty);
		return result==1;
	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
		Specialty specialty = dao.selectSpecialtyByCode(code);
		return specialty;
	}

	@Override
	public boolean deleteSpecialty(int code) {
		int result = dao.deleteSpecialty(code);
		return result==1;
	}

}
