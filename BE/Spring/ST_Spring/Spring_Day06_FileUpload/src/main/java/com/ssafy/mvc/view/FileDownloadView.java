package com.ssafy.mvc.view;

import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//이렇게 컴포넌트 처리를 해서 빈 등록을 하면 빈의 이름은 앞의 글자가 소문지로 바뀌어 등록됨
@Component
public class FileDownloadView extends AbstractView {
	
	// 어디에 있는 데이터를 가지고 와야하는지에 대한 의존성을 추가해줘야함
	private ResourceLoader loader;
	
	public FileDownloadView(ResourceLoader ld) {
		this.loader = ld;
	}
	//filename으로 실어보낸 객체는 model안에 map형식(키 밸류)으로 들어있다
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName = (String) model.get("filename");
		
		//파일 내용을 가져와야함
		Resource resource = loader.getResource("classpath:/static/img");
		
		
		
		

		
	}

}
