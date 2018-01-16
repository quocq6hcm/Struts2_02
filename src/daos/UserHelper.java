package daos;

import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserHelper

{



    private List<User> listUser = new ArrayList<>();

    private DBHandler db = new DBHandler();

    private Statement st;

    private PreparedStatement pst;

    private ResultSet rs;



    public List<User> findAllUser()

    {

        try

        {

            this.st = db.openCnnDB().createStatement();

            this.rs = st.executeQuery("SELECT  * from Users ");

            while (rs.next())

            {

                this.listUser.add(new User(

                        rs.getString(1),

                        rs.getString(2),

                        rs.getString(3),

                        rs.getString(4),

                        rs.getString(5),

                        Integer.parseInt(rs.getString(6))));

            }

        }

        catch (SQLException e)

        {

            e.printStackTrace();

        } finally

        {

            db.closeCnnDB();

        }

        return listUser;

    }



    public User findUserByUsername(String username)

    {

        User temp = new User();

        try

        {

            st = db.openCnnDB().createStatement();

            rs = st.executeQuery("SELECT * from users where username = '" + username + "'");

            while (rs.next())

            {

                temp.setUsername(rs.getString(1));

                temp.setPassword(rs.getString(2));

                temp.setFullName(rs.getString(3));

                temp.setPhoto(rs.getString(4));

                temp.setEmail(rs.getString(5));

                temp.setLevel(rs.getInt(6));

            }

        }

        catch (Exception e)

        {

            temp = null;

        }

        finally

        {

            db.closeCnnDB();

        }

        return temp;

    }



    public List<User> findUsersByFullname(String fullname)

    {

        try

        {

            this.pst = db.openCnnDB().

                    prepareStatement("SELECT  * from Users where fullname LIKE ? ");

            this.pst.setString(1, "%" + fullname + "%");

            this.rs = pst.executeQuery();

            while (rs.next())

            {

                this.listUser.add(new User(

                        rs.getString(1),

                        rs.getString(2),

                        rs.getString(3),

                        rs.getString(4),

                        rs.getString(5),

                        Integer.parseInt(rs.getString(6))));

            }

        }

        catch (SQLException e)

        {

            e.printStackTrace();

        }

        finally

        {

            db.closeCnnDB();

        }

        return listUser;

    }



    public void postUser(User u)

    {

        try

        {

            pst = db.openCnnDB().prepareStatement("insert into Users VALUES (?,?,?,?,?,?)");

            pst.setString(1, u.getUsername());

            pst.setString(2, u.getPassword());

            pst.setString(3, u.getFullName());

            pst.setString(4, u.getPhoto());

            pst.setString(5, u.getEmail());

            pst.setInt(6, u.getLevel());

            pst.execute();

        }

        catch (SQLException e)

        {

            System.out.println(e.getMessage());

        }

        finally

        {

            db.closeCnnDB();

        }

    }



    public void putUser(User u)

    {

        try

        {

            pst = db.openCnnDB().prepareStatement("update Users set password = ?, fullname = ? , photo = ? , email = ? , level = ? where username = ?");

            //?? chú ý tại sao xuống hàng thì k chạy được....

            pst.setString(1, u.getPassword());

            pst.setString(2, u.getFullName());

            pst.setString(3, u.getPhoto());

            pst.setString(4, u.getEmail());

            pst.setInt(5, u.getLevel());

            pst.setString(6, u.getUsername());

            pst.execute();

        }

        catch (SQLException e)

        {

            e.printStackTrace();

        }

        finally

        {

            db.closeCnnDB();

        }

    }



    public void removeUser(String username)

    {

        try

        {

            pst = db.openCnnDB().prepareStatement("delete users where username = ?");

            pst.setString(1, username);

            pst.executeUpdate();

        }

        catch (Exception e)

        {

            System.out.println(e.getMessage());

        }

        finally

        {

            db.closeCnnDB();

        }

    }






    public static void main(String[] args)

    {

        UserHelper uh = new UserHelper();

        System.out.println(uh.findAllUser().size());

        System.out.println(uh.findAllUser().get(1).getFullName());

    }

}