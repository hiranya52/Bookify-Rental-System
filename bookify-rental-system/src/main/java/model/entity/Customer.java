package model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private String Id;
    private String name;
    private String phoneNo;
    private String email;

}
