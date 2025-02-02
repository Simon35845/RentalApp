package createdBy51mon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private Integer age;
}
