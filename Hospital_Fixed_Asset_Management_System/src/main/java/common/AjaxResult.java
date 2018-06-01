package common;

public class AjaxResult {

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer integer) {
		this.value = integer;
	}
	private String url;
	private String message;
	private Boolean success;
	private Integer value;
}
