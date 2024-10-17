package com.ssafy.mvc.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource; //이거 유의해라
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


//Controller는 Component의 하위 개념이므로(상속관계)
//Component를 해줘도 된다

@Controller
public class FileController {
	//스프링에서 파일이나 클래스 등등 리소스를 로드할 때를 대비하는 인터페이스가 따로 있다.
	private ResourceLoader resourceLoader;
	
	//@Autowired를 안해줘도 한개만 있어서 자동으로 된다
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	
	}
	
	@GetMapping({"/sff"})
	public String sigleFileForm() {
		return "sff";

	}
	
	@PostMapping({"/up"})
	//form으로 보낸 파라미터를 가져오기 위해서는 
	
	//파일을 여러개 보냈다면 MultipartFile[] -> 이런식으로 표기하면 됨
	public String Upload(@RequestParam("filename") MultipartFile file, Model model) throws IllegalStateException, IOException {
//		System.out.println(file.getOriginalFilename());//사진 풀네임 출력
		
		//실제로 파일이 있는지 : 데이터를 안 넣었을 때 null이 뜨지 않음 -> 사이즈에 따른 이중장치
		 if(file != null && file.getSize() > 0) {
			 String fileName = file.getOriginalFilename();
			 
			 //코드로 img를 가져와야 저장을 하던지 말던지
			 //내 로컬에 있는 것을 가져오려면 file : 이렇게 가능
			 //하지만 우리는 src/main/resource = classpath 안에 있는 프로젝트 내의 img 경로를 가져올 것이므로
			 //만들어진 폴더를 가져옴
			 
			 
			 Resource resource = resourceLoader.getResource("classpath:/static/img");
			 //해당 파일을 가져다가 저장을 하겠다. -> target안에 생성이 될것
			 file.transferTo(new File(resource.getFile() , fileName));
			 
			 model.addAttribute("filename", fileName);
			 
			 return "result";
		 }
		 else {
			 System.out.println("등록된게 없음");
			 
			 return "sff";
		 }
		
	}
	
	
	@GetMapping({"/download"})
	public String download(@RequestParam("fileName") String filename, Model model) {
		//다운로드를 처리할 우리만의 view
		model.addAttribute("filename", filename);
		return "fileDownloadView";

		
	}
	

}
