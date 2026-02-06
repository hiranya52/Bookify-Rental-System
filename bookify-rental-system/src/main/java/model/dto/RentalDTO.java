package model.dto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentalDTO {

    private String id;
    private String bookId;
    private String customerId;
    private String issueDate;
    private String dueDate;

}
