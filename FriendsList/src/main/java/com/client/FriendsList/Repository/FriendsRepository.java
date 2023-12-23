package com.client.FriendsList.Repository;

import com.client.FriendsList.Entities.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {

}
