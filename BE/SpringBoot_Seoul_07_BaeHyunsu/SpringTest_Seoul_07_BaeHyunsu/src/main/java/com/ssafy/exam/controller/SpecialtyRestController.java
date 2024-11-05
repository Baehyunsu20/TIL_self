package com.ssafy.exam.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {
	//Service 의존성 주입
	private final SpecialtyService service;
	//하나의 의존성은 autowired 생략 가능
    public SpecialtyRestController(SpecialtyService service) {
		this.service = service;
	}
    
    
    
    @PostMapping("/")//전공정보 등록
	public ResponseEntity<?> addSpecialty(@RequestBody Specialty specialty) {
    	if(service.addSpecialty(specialty)) {
    		//추가에 성공했을 경우
    		return new ResponseEntity<String>(HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    

    @GetMapping("/{specialtyCode}")//code로 전공 정보 조회
    public ResponseEntity<Specialty> getSpecialty(@PathVariable("specialtyCode") int specialtyCode) {
    	Specialty specialty = service.getSpecialtyByCode(specialtyCode);
    	return new ResponseEntity<Specialty>(specialty, HttpStatus.OK);
    }

    
    
    //전공정보 삭제
    @DeleteMapping("/{specialtyCode}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable("specialtyCode") int specialtyCode) {
    	if(service.deleteSpecialty(specialtyCode)) {
    		//삭제에 성공했을 경우
    		return new ResponseEntity<String>(HttpStatus.OK);
    		
    	}
    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}