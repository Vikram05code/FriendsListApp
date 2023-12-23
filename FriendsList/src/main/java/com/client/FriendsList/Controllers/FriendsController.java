package com.client.FriendsList.Controllers;

import com.client.FriendsList.Entities.FriendsDto;
import com.client.FriendsList.Services.FriendsServices;
import com.client.FriendsList.payloads.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    @Autowired
    private FriendsServices friendsServices;


    @PostMapping("/create")
    public ResponseEntity<FriendsDto> addFriends( @RequestBody FriendsDto friendsDto){

        FriendsDto friendsDto1 = friendsServices.createFriends(friendsDto);

        return new ResponseEntity<>(friendsDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{friendsId}")
    public ResponseEntity<FriendsDto> updatedFriends(@RequestBody FriendsDto friendsDto, @PathVariable Integer friendsId){
        FriendsDto friendsDtoUpdated  = friendsServices.updateFriends(friendsDto, friendsId);

        return new ResponseEntity<>(friendsDtoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{friendsId}")
    public ResponseEntity<ApiResponse> deletedFriends(@PathVariable Integer friendsId){

        friendsServices.deleteFriendsById(friendsId);

        return new ResponseEntity<>(new ApiResponse("friend deleted successfully", true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<FriendsDto>> getFriendsList(){
        List<FriendsDto> friendsList = friendsServices.getAllFriends();

        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }

    @GetMapping("/{friendsId}")
    public ResponseEntity<FriendsDto> findFriendById(@PathVariable Integer friendsId){

      FriendsDto friendsDto1 =  friendsServices.getFriendsById(friendsId);

      return new ResponseEntity<>(friendsDto1, HttpStatus.OK);
    }

}
