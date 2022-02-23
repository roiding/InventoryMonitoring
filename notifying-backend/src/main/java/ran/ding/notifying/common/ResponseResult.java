package ran.ding.notifying.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {
    private String state;
    private String error;
    private T data;


    public static<T> ResponseResult<T> buildSuccessResult(T data){
        return new ResponseResult("200","",data);
    }


    public static ResponseResult buildErrorResult(String state,String error){
        return new ResponseResult(state,error,null);
    }
    public static ResponseResult buildNoLoginResult(String message){
        return new ResponseResult("993",message,null);
    }

}
