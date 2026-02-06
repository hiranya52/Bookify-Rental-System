package model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    private String id;
    private String title;
    private String author;
    private String category;
    private int quantity;

}
