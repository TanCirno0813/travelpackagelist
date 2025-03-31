package com.example.post.service;

import com.example.post.dto.CommentRequestDto;
import com.example.post.dto.CommentResponseDto;
import com.example.post.entity.Comment;
import com.example.post.entity.Post;
import com.example.post.repository.CommentRepository;
import com.example.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentResponseDto createComment(Long postId, String username, CommentRequestDto request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Comment comment = Comment.builder()
                .post(post)
                .username(username)
                .content(request.getContent())
                .build();

        commentRepository.save(comment);
        return new CommentResponseDto(comment.getId(), comment.getContent(), comment.getUsername());
    }

    public List<CommentResponseDto> getComments(Long postId) {
        return commentRepository.findByPostId(postId).stream()
                .map(c -> new CommentResponseDto(c.getId(), c.getContent(), c.getUsername()))
                .collect(Collectors.toList());
    }


    public void deleteComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

        if (!comment.getPost().getId().equals(postId)) {
            throw new RuntimeException("게시글과 댓글 정보가 일치하지 않습니다.");
        }

        commentRepository.delete(comment);
    }

}
