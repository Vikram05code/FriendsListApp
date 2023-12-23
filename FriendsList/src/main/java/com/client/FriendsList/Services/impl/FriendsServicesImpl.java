package com.client.FriendsList.Services.impl;

import com.client.FriendsList.Entities.Friends;
import com.client.FriendsList.Entities.FriendsDto;
import com.client.FriendsList.Exceptions.ResourceNotFoundException;
import com.client.FriendsList.Repository.FriendsRepository;
import com.client.FriendsList.Services.FriendsServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendsServicesImpl implements FriendsServices {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FriendsRepository friendsRepository;


    @Override
    public FriendsDto createFriends(FriendsDto friendsDto) {
        Friends friends = this.friendsDtoToFriends(friendsDto);
        Friends friendSaved = friendsRepository.save(friends);

        return friendsToFriendsDto(friendSaved);
    }

    @Override
    public FriendsDto updateFriends(FriendsDto friendsDto, int friendsId) {

        Friends friends = friendsRepository.findById(friendsId).orElseThrow(()->new ResourceNotFoundException("Friend", "FriendId", friendsId));
        friends.setId(friendsDto.getId());
        friends.setName(friendsDto.getName());
        friends.setAddress(friendsDto.getAddress());
        friends.setContact(friendsDto.getContact());
        friends.setAge(friendsDto.getAge());
        friends.setInterest(friendsDto.getInterest());

        Friends updatedFriend = friendsRepository.save(friends);

        return friendsToFriendsDto(updatedFriend);
    }

    @Override
    public List<FriendsDto> getAllFriends() {

        List<Friends> friends = friendsRepository.findAll();
        List<FriendsDto> friendsDto = friends.stream().map(friend -> friendsToFriendsDto(friend)).collect(Collectors.toList());

        return friendsDto;
    }

    @Override
    public FriendsDto getFriendsById(int friendsId) {

        Friends friends = friendsRepository.findById(friendsId).orElseThrow(()->new ResourceNotFoundException("Friends", "friendsId", friendsId));
        FriendsDto friendsDto = friendsToFriendsDto(friends);

        return friendsDto;
    }

    @Override
    public void deleteFriendsById(int friendsId) {

        friendsRepository.deleteById(friendsId);

    }


   public Friends friendsDtoToFriends(FriendsDto friendsDto){

        Friends friends = this.modelMapper.map(friendsDto, Friends.class);

        return friends;
    }

   public FriendsDto friendsToFriendsDto(Friends friends){
        FriendsDto friendsDto = this.modelMapper.map(friends, FriendsDto.class);

        return friendsDto;
    }
}
