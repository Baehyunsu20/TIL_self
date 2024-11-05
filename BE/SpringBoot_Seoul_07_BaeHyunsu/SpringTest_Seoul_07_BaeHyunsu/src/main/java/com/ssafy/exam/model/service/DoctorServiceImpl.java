package com.ssafy.exam.model.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	//dao에 대한 의존성 주입, 하나만 존재하므로 Autowired 생략
	private final DoctorDao dao;

	public DoctorServiceImpl(DoctorDao dao) {
		this.dao = dao;
	}
	
	
	
	

	@Override
	public boolean addDoctor(Doctor doctor) {
		int result = dao.insertDoctor(doctor);
		//입력정보가 들어가면 dao에서 1이 반환되므로 1인지 아닌지를 반환해줌.
		return result ==1;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> list = dao.selectAllDoctors();
		return list;
	}

	@Override
	public Doctor getDoctorById(int id) {
		Doctor doctor = dao.selectDoctorById(id);
		return doctor;
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		doctor.setDoctorId(id);
		int result = dao.updateDoctor(doctor);
		return result==1;
	}

	@Override
	public boolean deleteDoctor(int id) {
		int result = dao.deleteDoctor(id);
		return result==1;
	}

}
