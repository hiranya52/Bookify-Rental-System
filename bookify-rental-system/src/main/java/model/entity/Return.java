package model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Return {

    private String id;
    private String bookId;
    private String customerId;
    private String issueDate;
    private String dueDate;
    private String overdueDate;
    private double fine;

}
