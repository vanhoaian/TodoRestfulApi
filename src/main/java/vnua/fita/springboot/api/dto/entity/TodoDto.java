package vnua.fita.springboot.api.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
	private Integer id;
	private Integer userId;
	private String title;
	private boolean completed;
}
