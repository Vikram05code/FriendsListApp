package com.client.FriendsList.Services;

import com.client.FriendsList.Entities.FriendsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendsServices {

    FriendsDto createFriends(FriendsDto friendsDto);

    FriendsDto updateFriends(FriendsDto friendsDto, int friendsId);

    List<FriendsDto> getAllFriends();

    FriendsDto getFriendsById(int friendsId);

    void deleteFriendsById(int friendsId);
}
