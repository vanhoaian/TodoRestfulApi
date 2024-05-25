package vnua.fita.springboot.api.dto.response;

import lombok.Data;

@Data
public class BaseResponse {

	private boolean isSuccess;
	private ErrorResponse erorr;
	

}
