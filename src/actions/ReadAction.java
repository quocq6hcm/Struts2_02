package actions;

import com.opensymphony.xwork2.ActionSupport;

import daos.UserHelper;
import models.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class ReadAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;

    private daos.UserHelper _db;

    private String username;

    private String password;

    private String fullName;

    private String photo;

    private String email;

    private int level;

    ///region getter-setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    ///endregion


    public ReadAction()
    {
        _db = new UserHelper();
    }

    public String execute() throws Exception
    {
        request = ServletActionContext.getRequest();
        request.setAttribute("list", _db.findAllUser());
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }

    public String delete() throws Exception {
        _db.removeUser(username);
        return "delete";
    }

    public String update() throws Exception {
        _db.putUser(new User(username, password, fullName, photo, email, level));
        return "update";
    }

    public String getUpdate() throws Exception {
        request = ServletActionContext.getRequest();
        System.out.println(username);
        User temp = _db.findUserByUsername(username);
        request.setAttribute("username", temp.getUsername());
        request.setAttribute("password", temp.getPassword());
        request.setAttribute("fullName", temp.getFullName());
        request.setAttribute("photo", temp.getPhoto());
        request.setAttribute("email", temp.getEmail());
        request.setAttribute("level", temp.getLevel());
        return "getUpdate";
    }

    public String create() throws Exception {
        _db.postUser(new User(username, password, fullName, photo, email, level));
        return "create";
    }
}
