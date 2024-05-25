package vnua.fita.springboot.api.dto.response;

import lombok.Data;

@Data
public class BaseItemResponse<T> extends BaseResponse{

	/*
	 * private T data;
	 * 
	 * public void setResult(T data) { super.setSuccess(true); this.data = data; }
	 */
}
