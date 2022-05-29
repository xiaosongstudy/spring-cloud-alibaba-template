package life.hopeurl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 宋世平 email:2453332538@qq.com 2022/5/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable {
    private Integer userId;
    private String username;
    private String password;
}
