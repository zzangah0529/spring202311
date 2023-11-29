package exam01;


import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE) // 기본 생성자
//@AllArgsConstructor
//@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
public class Book {
    private String title;
    private String author;
    private String publisher;

}
