package com.instagram.story.model.mapper;


import com.instagram.story.model.dto.Story;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface StoryMapper {

    void insertStory(Story story);
    void updateStoryImage(int storyId, String storyImage);
    void deleteStory(int userId, int storyId);

    List<Story> selectAllStories();

    Story selectStoriesByStoryId(int storyId);

    Story selectStoryById(int storyId);

    List<Story> selectStoriesByUserId(int userId);
    // 만료된 스토리 void updateStory(Story story);


}