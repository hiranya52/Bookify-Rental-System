package model.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {

    private String id;
    private String name;
    private String phoneNo;
    private String email;

}
