package model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rental {

    private String id;
    private String bookId;
    private String customerId;
    private String issueDate;
    private String dueDate;

}
