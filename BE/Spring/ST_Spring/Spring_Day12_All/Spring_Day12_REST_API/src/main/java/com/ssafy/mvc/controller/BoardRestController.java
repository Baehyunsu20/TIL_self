package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api-board")
//Http method 설명이 나오기 전에
@Tag(name="BoardRestful API", description = "게시판 CRUD")
public class BoardRestController {

	// 서비스 의존성 주입
	private final BoardService boardService;

	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 게시글 전체 조회
	// ? : 아무거나 쓸 수 있는 와일드 카드
	/*
	 * @GetMapping("/board") public ResponseEntity<?> list() { List<Board> list =
	 * boardService.getBoardList();
	 * 
	 * // 생성자 오버로딩 return new ResponseEntity<>(list, HttpStatus.OK); }
	 */

	// 게시글 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id);
		// 1000번 글을 넣으면 null 출력
		System.out.println(board);
		if (board != null) {
			return ResponseEntity.ok(board);
		}
		// 반환값이 board가 아니므로 build 처리
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// 게시글 등록(Form 데이터 형식으로 넘어왔다)
	@PostMapping("/board")
	public ResponseEntity<?> write(@ModelAttribute Board board) {
		boardService.writeBoard(board); // 여기서의 반환타입은 void지만 -> 원래는 Int로 건들인 row의 개수가 떠야함
		System.out.println(board); // 입력한 보드 찍기

		// 해당 반환 : 방금 입력한 board 자체를 넘김
		// 201 요청
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);

	}

	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	//스웨거 상에 안보이게
	@Hidden
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		boolean isDeleted = boardService.removeBoard(id);
		if (isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
	}

	// 게시글 수정
	@PutMapping("/board/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Board board) {
		board.setId(id);
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	
	  //검색 : null을 어떻게 처리할 것인지 -> Mapper에서 none => null
	  @GetMapping("/board")
	  @Operation(summary = "게시글 검색 및 조회", description = "니가 뭔데")
	  public ResponseEntity<?> list(@ModelAttribute SearchCondition condition){
		  System.out.println("무슨 상황인데???????"+condition.toString());
		  System.out.println();
		  List<Board> list = boardService.search(condition);
		  if(list == null || list.size() ==0) {
			  return new ResponseEntity<List<Board>>(list, HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		  
		  
	  }

}
