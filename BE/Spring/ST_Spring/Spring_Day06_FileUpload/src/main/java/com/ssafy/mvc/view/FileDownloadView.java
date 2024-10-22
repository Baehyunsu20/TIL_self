package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// return의 처리 방식 : jsp를 찾다가 없네? -> 등록된 Bean(어노테이션으로 등록)
// 중에 다시 찾음 -> 빈 기본적으로 우선순위가 낮다. -> 나중에 CONFIG로 바꿀 수 있음
//이렇게 컴포넌트 처리를 해서 빈 등록을 하면 빈의 이름은 앞의 글자가 소문지로 바뀌어 등록됨
@Component
public class FileDownloadView extends AbstractView {
	
	// 데이터를 가져와야하기 떄문에 필요한 과정
	// 어디에 있는 데이터를 가지고 와야하는지에 대한 의존성을 추가해줘야함
	private ResourceLoader loader;
	
	public FileDownloadView(ResourceLoader ld) {
		this.loader = ld;
	}
	//filename으로 실어보낸 객체는 model안에 map형식(키 밸류)으로 들어있다
	//view는 Model이라는 바구니를 쓸 수 있다.
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName = (String) model.get("filename");
		
		//파일 내용을 가져와야함
		Resource resource = loader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName);
		
		
		//여기까지 사전 준비////////
		//파일 규정이 utf일 수 있으니까 형식을 바꿔주는 코드를 추가해주면 좋음. 실습해서는 없어도 됨
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		//그냥 약속 : 다운로드를 받으려면 이러한 약속임을 명시 -> 그냥 받아들이기
		response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName +"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		////////응답 헤더 설정 끝///////
		
		//try-with resourese
		//내가 file을 가져와서 fis로 읽겠다 , 내가 읽은 것을 os명시
		try(FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				) {
			FileCopyUtils.copy(fis, os);
			
		}
		
	}

}
