package model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReturnDTO {

    private String id;
    private String bookId;
    private String customerId;
    private String issueDate;
    private String dueDate;
    private String overdueDate;
    private double fine;

}
