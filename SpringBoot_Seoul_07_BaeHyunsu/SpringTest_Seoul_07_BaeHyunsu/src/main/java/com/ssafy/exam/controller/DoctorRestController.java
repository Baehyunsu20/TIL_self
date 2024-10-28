package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;
//
import org.springframework.web.bind.annotation.RequestBody;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
	//서비스에 대한 의존성 주입, 하나밖에 없으므로 autowired 생략
	private final DoctorService doctorService;

	public DoctorRestController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	//기능 시작

	//의사정보를 추가
	@PostMapping("")
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		if(doctorService.addDoctor(doctor)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		System.out.println("추가 안됨");
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	//의사 전체 정보 조회
	@GetMapping("")
	public ResponseEntity<?> getAllDoctors() {
		List<Doctor> list = doctorService.getAllDoctors();
		if(list.size() == 0) {
			//등록된 의사가 0명일 경우, no content
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);
	}

	//의사 개인 정보 조회
	@GetMapping("/{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId) {
		Doctor doctor = doctorService.getDoctorById(doctorId);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	

	//의사 개인 정보 삭제
	@DeleteMapping("/{doctorId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") int doctorId) {
		if(doctorService.deleteDoctor(doctorId)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	//의사 개인 정보 수정
	@PutMapping("/{doctorId}")
	public ResponseEntity<String> updateDoctor(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctor) {
		if(doctorService.updateDoctor(doctorId, doctor)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
