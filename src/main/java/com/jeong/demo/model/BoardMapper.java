package com.jeong.demo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	List<BoardVo> boardList() throws Exception;

	public BoardVo boardDetail(int bno) throws Exception;
	
	public void boardSave(BoardVo boardVo) throws Exception;
	
	public void boardUpdate(BoardVo boardVo) throws Exception;
	
	public void boardDelete(int bno) throws Exception;
}
