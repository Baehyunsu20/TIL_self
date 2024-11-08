package com.ssafy.mvc.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.boardService;

@RestController
@RequestMapping("/api-b")
public class BoardController {
	
	//보드 서비스에 대한 의존성 주입 -> 생성자 주입
	private final boardService boardService;
	//의존성 주입이 하나만 이뤄지므로 오토 생략 가능
	public BoardController(com.ssafy.mvc.model.service.boardService boardService) {
		this.boardService = boardService;
	}
	
	
	//기능 추가
	//검색과 전체 조회가 같은 get으로 겹침 
	
	//전체조회
	@GetMapping("/allBoard")
	public ResponseEntity<List<Board>> list(){
		System.out.println("모든게시글을 가져옵니다");
		List<Board> list = boardService.getBoardList();
		//new로 만들어서 보내야함
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	//파라미터를 추가했을 경우는 Modelattribute로 써야함
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition){
		//검색한 것을 바탕으로
		List<Board> result = boardService.search(condition);
		//검색 결과가 없을 경우를 고려
		if(result == null) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(result, HttpStatus.OK);
		
	}
	
	//하나만 조회
	@GetMapping("/board/{id}")
	public ResponseEntity<?> listid(@PathVariable("id") int id){
		Board result = boardService.readBoard(id);
		if(result == null) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Board>(result, HttpStatus.OK);
	}

	
	
	//c : 추가하고 전체 목록을 보여줌.
	@PostMapping("/board")
	//이거는 json으로 보낼때는 requestbody, form으로 보낼거면 modelAttribute
	//위를 바꿔주면 이제 500에러 발생
	public ResponseEntity<?> insert(@ModelAttribute Board board){
		boardService.writeBoard(board);//추가를 했어
		List<Board> all = boardService.getBoardList();
		return new ResponseEntity<List<Board>>(all, HttpStatus.OK);
		
	}
	
	//수정 -> 수정된 글 
	@PutMapping("/board/{id}")
	public ResponseEntity<?> change(@PathVariable("id") int id, @ModelAttribute Board board){
		//새롭게 입력받은 보드의 id를 입력 받은 id로 만들어둠
		Board pre = boardService.readBoard(id);
		if(pre==null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		board.setId(id);
		System.out.println(board.toString());
		boardService.modifyBoard(board);
		Board change = boardService.readBoard(id);
		return new ResponseEntity<Board>(change, HttpStatus.OK);
		
	}
	
	
	
	//삭제 : id를 받아서 삭제
	@DeleteMapping("board/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(boardService.removeBoard(id)) {
			//삭제되면 1-> true
			return ResponseEntity.status(HttpStatus.OK).body("삭제완료");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("그런거없어");
	}
	

	
	
	
	
	

}
