package model.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private String id;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String role;

}
