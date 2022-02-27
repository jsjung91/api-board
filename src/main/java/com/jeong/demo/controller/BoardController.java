package com.jeong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeong.demo.model.BoardVo;
import com.jeong.demo.service.BoardService;
import com.jeong.demo.util.ApiResponse;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	@Autowired
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}	
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> boardList() throws Exception {
		return new ApiResponse(boardService.boardList()).send(HttpStatus.OK);	
	}
	
	@GetMapping("/view/{bno}")
	public BoardVo boardDetail(@PathVariable("bno") int bno) throws Exception {
		return boardService.boardDetail(bno);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> boardSave(@RequestBody BoardVo boardVo) throws Exception {
		boardService.boardSave(boardVo);
		
		return new ApiResponse(boardVo).send(HttpStatus.OK);
	}
	
	@PutMapping("/update/{bno}")
	public ResponseEntity<ApiResponse> boardUpdate(@PathVariable("bno")int bno, @RequestBody BoardVo boardVo) throws Exception {
		
		BoardVo board = boardService.boardDetail(bno);
		
		if(board == null) {
			return new ApiResponse().errorSend(HttpStatus.FAILED_DEPENDENCY, "Failed");
		}
		
		board.setSubject(boardVo.getSubject());
		board.setContent(boardVo.getContent());
		boardService.boardUpdate(boardVo);
		
		return new ApiResponse(board).send(HttpStatus.OK);
	}
	
	@DeleteMapping("/{bno}")
	public ResponseEntity<ApiResponse> boardDelete(@PathVariable("bno") int bno) throws Exception {
		
		BoardVo board = boardService.boardDetail(bno);
		
		if(board == null) {
			return new ApiResponse().errorSend(HttpStatus.FAILED_DEPENDENCY, "Failed");
		}
		
		boardService.boardDelete(bno);
		
		return new ApiResponse(board).send(HttpStatus.OK);
	}
	
}