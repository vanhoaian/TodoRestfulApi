package vnua.fita.springboot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vnua.fita.springboot.api.utils.IConstant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

	@NotNull(message = IConstant.ErrorMessageTodoValidation.NOT_NULL_USERID)
	private Integer userId;
	
	@NotBlank(message = IConstant.ErrorMessageTodoValidation.NOT_BLANK_TITLE)
	private String title;
}
