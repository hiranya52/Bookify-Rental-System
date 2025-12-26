package model.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private String id;
    private String title;
    private String name;
    private String contact;
    private String email;
    private String role;

}
