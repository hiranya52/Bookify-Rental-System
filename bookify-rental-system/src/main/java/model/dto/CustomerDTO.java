package model.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {

    private String Id;
    private String name;
    private String phoneNo;
    private String email;

}
