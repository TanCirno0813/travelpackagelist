package com.example.post.service;

import com.example.post.dto.PostRequestDto;
import com.example.post.dto.PostResponseDto;
import com.example.post.entity.Post;
import com.example.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto createPost(String username, PostRequestDto request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .username(username)
                .build();
        postRepository.save(post);
        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getUsername());
    }

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(p -> new PostResponseDto(p.getId(), p.getTitle(), p.getContent(), p.getUsername()))
                .collect(Collectors.toList());
    }

    public void deletePost(Long id, String username) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }

    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getUsername());
    }

    public PostResponseDto updatePost(Long id, String username, PostRequestDto request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(post);
        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getUsername());
    }
}
