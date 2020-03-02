package domain.db;

import domain.model.Person;
import domain.model.Product;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDbSql implements PersonDb {
    private Properties properties;
    private String url;

    public PersonDbSql(Properties p) {
        try {
            Class.forName("org.postgresql.Driver");
            this.properties = p;
            this.url = properties.getProperty("url");
        } catch (Exception e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public Person get(String personId) {
        Person p = new Person();
        ResultSet result = null;

        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            result = statement.executeQuery("select * from \"WinnepenninckxDennisWeb3\".\"Person\" where userid = '" + personId+"'");
            p = makePersonFromSet(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Person> getAll() {
        ResultSet result = null;
        ArrayList list = new ArrayList();
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            result = statement.executeQuery("SELECT * FROM \"WinnepenninckxDennisWeb3\".\"Person\"");
            list = (ArrayList) makePersonsFromSet(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void add(Person person) {

        String firstname = person.getFirstName();
        String userid = person.getUserid();
        String lastname = person.getLastName();
        String email = person.getEmail();
        String password = person.getPassword();



        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into \"WinnepenninckxDennisWeb3\".\"Person\"(userid,firstname,lastname,email,password)\n" +
                    "values('" + userid + "','" + firstname + "','" + lastname + "','" + email + "','" + password + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Person person) {

        String firstname = person.getFirstName();
        String userid = person.getUserid();
        String lastname = person.getLastName();
        String email = person.getEmail();
        String password = person.getPassword();

        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE  \"WinnepenninckxDennisWeb3\".\"Person\" \n" +
                    "set firstname='" + firstname + "',lastname='" + lastname + "',email='" + email + "',password='"+ password +"' \n" +
                    "Where productid = '" + userid +"'");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String personId) {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from \"WinnepenninckxDennisWeb3\".\"Person\" \n where  userid = '" + personId +"'");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfPersons() {
        return getAll().size();
    }

    private Person makePersonFromSet(ResultSet result) {
        Person p = null;
        try {
            result.next();
            String userid = result.getString("userid");
            String fistname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String password = result.getString("password");
            try {    // validation of data stored in database
                p = new Person(userid, email, password, fistname, lastname);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    private List<Person> makePersonsFromSet(ResultSet result) {
        ArrayList<Person> Persons = new ArrayList<>();
        Person p = null;

        try {
            while (result.next()) {
                String userid = result.getString("userid");
                String fistname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String email = result.getString("email");
                String password = result.getString("password");
                try {    // validation of data stored in database
                    p = new Person(userid, email, password, fistname, lastname);
                    Persons.add(p);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Persons;
    }
}
