package model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String id;
    private String title;
    private String name;
    private String contact;
    private String email;
    private String role;

}
