package com.client.FriendsList.Entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Friends {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String interest;
    private int age;
}
