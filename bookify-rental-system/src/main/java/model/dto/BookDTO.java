package model.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO {

    private String id;
    private String title;
    private String author;
    private String category;
    private int quantity;

}
