package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Comment;
import com.scott.b_springData2_self_project2022a.repositories.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepository;
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository=commentRepository;
	}
	public List<Comment> allComments(){
		return commentRepository.findAll();
	}
	public Comment findComment(Long id) {
		Optional<Comment> optional=commentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}	
	}
	public Comment createComment(Comment c) {
		return commentRepository.save(c);
	}
	public Comment updateComment(Long id, String content) {
		Comment c=findComment(id);
		c.setContent(content);
		return commentRepository.save(c);
	}
	public Comment updateComment(Comment c) {
		return commentRepository.save(c);
	}
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}
}