package com.jeong.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeong.demo.model.BoardMapper;
import com.jeong.demo.model.BoardVo;

@Service
public class BoardService {

	private final BoardMapper boardMapper;
	
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	public List<BoardVo> boardList() throws Exception {
		return boardMapper.boardList();
	}

	public BoardVo boardDetail(int bno) throws Exception {		
		return boardMapper.boardDetail(bno);
	}
	
	public void boardSave(BoardVo boardVo) throws Exception {
		boardMapper.boardSave(boardVo);
	}
	
	public void boardUpdate(BoardVo boardVo) throws Exception {
		boardMapper.boardUpdate(boardVo);
	}
	
	public void boardDelete(int bno) throws Exception {
		boardMapper.boardDelete(bno);
	}
}
