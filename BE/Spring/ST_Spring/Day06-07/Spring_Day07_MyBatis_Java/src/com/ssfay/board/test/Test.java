package com.ssfay.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssfay.board.config.MyBatisConfig;

public class Test {
	
	public static void main(String[] args) {
		//팩토리를 얻어와서 세션을 열어야한다
		/*
		 * try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
		 * List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll"); 
		 * for(Board board : boards) { System.out.println(board); } }
		 */
		
		
		/*
		 * try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){ //아래
		 * 코드를 통해 mapper xml과 boardDao를 결합해서 daoimpl을 만드는 역할을 함 //여기서 풀패키지를 다 쓸 필요가 사라짐
		 * -> session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
		 * BoardDao dao = session.getMapper(BoardDao.class); Board board =
		 * dao.selectOne(1); //id를 넘김 System.out.println(board); }
		 */
		
		
		
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
//			//아래 코드를 통해  mapper xml과 boardDao를 결합해서 daoimpl을 만드는 역할을 함
//			//여기서 풀패키지를 다 쓸 필요가 사라짐 ->  session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll"); 
//			BoardDao dao = session.getMapper(BoardDao.class);
//			Board board = new Board("이제는 알아야해22", "양띵균", "싱글턴을 모르면,,곤란");
//			dao.insertBoard(board);
//		}
		
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
//			//아래 코드를 통해  mapper xml과 boardDao를 결합해서 daoimpl을 만드는 역할을 함
//			//여기서 풀패키지를 다 쓸 필요가 사라짐 ->  session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll"); 
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.deleteBoard(4);
//
//			
//		}
//		
		
		
		//업데이트 : 조회수 증가
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
//			//아래 코드를 통해  mapper xml과 boardDao를 결합해서 daoimpl을 만드는 역할을 함
//			//여기서 풀패키지를 다 쓸 필요가 사라짐 ->  session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll"); 
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.updateViewCnt(1);
//
//			
//		}
		
		//업데이트 : 수정날짜 변경
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
			//아래 코드를 통해  mapper xml과 boardDao를 결합해서 daoimpl을 만드는 역할을 함
			//여기서 풀패키지를 다 쓸 필요가 사라짐 ->  session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll"); 
			BoardDao dao = session.getMapper(BoardDao.class);
			Board b = dao.selectOne(1);
			b.setTitle("변경");
			dao.updateBoard(b);

			
		}
		
		
		//전체 조회
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
			//아래 코드를 통해  mapper xml과 boardDao를 결합해서 daoimpl을 만드는 역할을 함
			//여기서 풀패키지를 다 쓸 필요가 사라짐 ->  session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll"); 
			BoardDao dao = session.getMapper(BoardDao.class);
			List<Board> boards = dao.selectAll();
			for(Board b : boards) {
				System.out.println(b);
			}
			
		}
		
		

		
			
	}

}
