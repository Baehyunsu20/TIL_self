package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class boardServiceImpl implements boardService{
	//dao에 대한 의존성 부여
	private final BoardDao boardDao;
	

	public boardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(board);
		return;
		
	}

	@Override
	public boolean removeBoard(int id) {
		int result = boardDao.deleteBoard(id);
		//1이 맞으면 true
		return result==1;
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
		
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

}
