package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


public class TestAction extends ActionSupport {
    @Action( value = "/hello",

            results = {
                    @Result(name = "success", location = "/test.jsp", params = {"param1", "ok", "param2","nope"})
            }
    )
    public String execute()
    {
        return SUCCESS;
    }

}
