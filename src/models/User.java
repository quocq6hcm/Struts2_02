package models;

public class User

{

    public String getUsername()

    {

        return username;

    }



    public void setUsername(String username)

    {

        this.username = username;

    }



    public String getPassword()

    {

        return password;

    }



    public void setPassword(String password)

    {

        this.password = password;

    }



    public String getFullName()

    {

        return fullName;

    }



    public void setFullName(String fullName)

    {

        this.fullName = fullName;

    }



    public String getPhoto()

    {

        return photo;

    }



    public void setPhoto(String photo)

    {

        this.photo = photo;

    }



    public String getEmail()

    {

        return email;

    }



    public void setEmail(String email)

    {

        this.email = email;

    }



    public int getLevel()

    {

        return level;

    }



    public void setLevel(int level)

    {

        this.level = level;

    }



    public User()

    {



    }



    public User(String username, String password, String fullName, String photo, String email, int level)

    {



        this.username = username;

        this.password = password;

        this.fullName = fullName;

        this.photo = photo;

        this.email = email;

        this.level = level;

    }



    private String username;

    private String password;

    private String fullName;

    private String photo;

    private String email;

    private int level;

}