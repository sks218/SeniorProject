package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * // -------------------------------------------------------------------------
/**
 *  Provides methods for manipulating a MySQL database.
 *
 *  @author willt
 *  @version Dec 10, 2017
 */
public class RDS
{
    private static Statement    statement;
    private static ResultSet    resultSet;
    private static Connection   connection;
    private static final String ENDPOINT  =
        "jdbc:mysql://lehighenergydata.cnzogex34uax.us-east-2.rds.amazonaws.com/";
    private static final String DATABASE  = "LehighResidential";                  // "REDD";
    private static final String USER_NAME = "sks218";
    private static final String PASS_WORD = "lehigh17";


    /**
     * use for data manipulation statements
     *
     * @param query
     *            action to be performed
     */
    public static void execute(String query)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection(ENDPOINT + DATABASE, USER_NAME, PASS_WORD);
            statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            statement = null;
            connection.close();
            connection = null;
        }
        catch (SQLException e)
        {
            //e.printStackTrace();
            System.out.println("SQL Error");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Use for manually manipulating the database
     */
    public static void shell()
    {
        try
        {
            Scanner s = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection(ENDPOINT + DATABASE, USER_NAME, PASS_WORD);
            statement = connection.createStatement();
            while (true)
            {
                String q = s.nextLine();
                if (q.equalsIgnoreCase("exit"))
                {
                    break;
                }
                try
                {
                    statement.execute(q);
                    resultSet = statement.getResultSet();
                    if (resultSet != null)
                    {
                        while (resultSet.next())
                        {
                            try
                            {
                                // for (int i = 1; i < noCols; i++)
                                int i = 1;
                                while (resultSet.getString(i) != null)
                                {
                                    System.out
                                        .print(resultSet.getString(i) + ", ");
                                    i++;
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println();
                            }
                        }
                        System.out.println();
                        resultSet.close();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            s.close();
            resultSet = null;
            statement.close();
            statement = null;
            connection.close();
            connection = null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static int[] months = {
        // 0,31,28,31,30,31,30,31,31,30,31,30,31
        0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    /**
     * Convert a timestamp into unix number
     *
     * @param date The date as a string
     * @return The date as an int
     */
    public static int date2Unix(String date)
    {
        // 2011-04-29 23:08:26-04:00
        int unix = 0;
        // System.out.println(date);
        int year = Integer.parseInt(date.substring(0, 4));
        // System.out.println(year);
        int month = Integer.parseInt(date.substring(5, 7));
        // System.out.println(month);
        int day = Integer.parseInt(date.substring(8, 10));
        // System.out.println(day);
        int hour = Integer.parseInt(date.substring(11, 13));
        // System.out.println(hour);
        int minute = Integer.parseInt(date.substring(14, 16));
        // System.out.println(minute);
        int second = Integer.parseInt(date.substring(17, 19));
        // System.out.println(second);
        int yearsSince1970 = year - 1970;
        int daysSince1970 = yearsSince1970 * 365;
        daysSince1970 = daysSince1970 + (int)Math.floor(yearsSince1970 / 4); // one
                                                                             // extra
                                                                             // day
                                                                             // every
                                                                             // four
                                                                             // years
        int daysThisYear = months[month];
        if ((year % 4 == 0) && (month > 2))
        {
            daysThisYear = daysThisYear + 1;
        }
        daysSince1970 = daysSince1970 + daysThisYear + day;
        int secondsThisDay = (hour * 60 * 60);
        secondsThisDay = secondsThisDay + (minute * 60);
        secondsThisDay = secondsThisDay + second;
        unix = daysSince1970 * 86400;
        unix = unix + secondsThisDay;
        return unix;
    }


    /*public static void insertUnix(String tableName)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection(ENDPOINT + DATABASE, USER_NAME, PASS_WORD);
            statement = connection.createStatement();
            System.out.println(tableName);
            statement.execute("select Time, Power from " + tableName);
            ResultSet rSet = statement.getResultSet();
            ArrayList<String[]> newData = new ArrayList<String[]>();
            while (rSet.next())
            {
                try
                {
                    String time = rSet.getString("Time");
                    float power = rSet.getFloat("Power");
                    int unix = date2Unix(time);
                    // System.out.println(unix+" | "+time+" | "+power);
                    String[] vec = { unix + "", time, power + "" };
                    newData.add(vec);

                }
                catch (Exception e)
                {
                    // System.out.println();
                }
                // System.out.println();
            }
            rSet.close();
            // statement.execute("create table "+tableName+"_1 (Unix int, Time
            // varchar(32), Power float)");
            for (String[] vec : newData)
            {
                System.out.println(vec[0] + " | " + vec[1] + " | " + vec[2]);
                statement.addBatch(
                    "insert into " + tableName
                        + "_1 (Unix, Time, Power) values (" + vec[0] + ", '"
                        + vec[1] + "', " + vec[2] + ")");
            }
            long[] x = statement.executeLargeBatch();
            for (long a : x)
            {
                System.out.println(a);
            }
            statement.close();
            statement = null;
            connection.close();
            connection = null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/

    /**
     * Build a database table from a lehigh data set
     *
     * @param building The name of the building
     */
    public static void uploadData(String building)
    {
        try
        {
            RawData data = new RawData("abc123", "password");
            System.out.println(building);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection(ENDPOINT + DATABASE, USER_NAME, PASS_WORD);
            statement = connection.createStatement();
            statement.execute("drop table " + building);
            statement.execute(
                "create table " + building
                    + "(Unix int, Time varchar(32), Power float)");
            String s1 = data.requestBdg(building);
            JSONParser parser = new JSONParser(s1);
            ArrayList<String[]> list = new ArrayList<String[]>();
            try
            {
                list = parser.parseList("Watts Total");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            for (String[] point : list)
            {
                System.out.println(point[0] + " | " + point[1] + " Watts");
                int unix = date2Unix(point[0]);
                statement.execute(
                    "insert into " + building + "(Unix, Time, Power)"
                        + "values (" + unix + ", " + point[0] + ", " + point[1]
                        + ")");
            }
            statement.close();
            statement = null;
            connection.close();
            connection = null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
