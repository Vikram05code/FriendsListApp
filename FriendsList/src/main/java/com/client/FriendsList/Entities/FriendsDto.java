package com.client.FriendsList.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FriendsDto {

    private int id;
    private String name;
    private String address;
    private String contact;
    private String interest;
    private int age;
}
