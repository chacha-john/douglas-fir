package chachaup.database;

import org.sql2o.Sql2o;

public class DB {
//    static String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
    static String connectionString = "jdbc:postgresql://ec2-107-22-238-112.compute-1.amazonaws.com:5432/dal944u6isvbf3";
    static Sql2o sql2o = new Sql2o(connectionString,"mssvdwwzvjuacq","b54b18a36912df8f8b756f668809cdac8becf9c6757a35c25a510bd4b98c2e9e");
}
