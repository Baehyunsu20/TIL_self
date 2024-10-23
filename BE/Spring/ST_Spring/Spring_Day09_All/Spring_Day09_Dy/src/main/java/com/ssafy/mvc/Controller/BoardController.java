package com.ssafy.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.Service.BoardService;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Controller
public class BoardController {
	
	//가장 먼저 할 점은 BoardService를 통해 기능을 처리할 것이므로
	//service에 대한 의존성을 injection 해준다.
	//Service는 인터페이스이지만 구현체가 있므로 인터페이스로 가져온다
	private BoardService boardService;
	
	//의존성 인젝션을 해줄 것이 하나만 있으니까 AUTO 안해줘도됨
	/* @Autowired */
	public BoardController(BoardService boardService) {
		this.boardService= boardService;
	}
	
	
	//////////////기능 시작//////////////////
	
	@GetMapping("/list")
	public String list(Model model) {
		//서비스를 통해서.... 게시글들을 가져와야한다.
		List<Board> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		return "/board/list";
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id")int id, Model model) {
		//게시글을 하나 가지고와서 updateform으로 넘겨야된다.
		//지금은 readBoard 밖에 없어서.. 이걸로 하긴 하겠지만.. 이거 하면 게시글 조회수 하나 올라감
		//그냥 쌩 게시글 하나 가져오는것 고민할 필요가 있다...
		model.addAttribute("board", boardService.readBoard(id));
		return "/board/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();}
	
	//////여기까지는 정적커리와 동일/////
	
	@GetMapping({"/search"})
	//검색에서 설정한 요소들을 선택할 객체를 만들어서 한번에 처리
	public String search(@ModelAttribute SearchCondition condition, Model model) {
		//list.jsp에서 boards로 처리하니까 이름을 그렇게 설정
		model.addAttribute("boards", boardService.search(condition));
		
		return "board/list";
	}
	
	

}
