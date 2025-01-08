package createdBy51mon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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
