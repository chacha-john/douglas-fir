package chachaup.domain;

import chachaup.database.DB;
import org.sql2o.Connection;

import java.util.List;

public class Endangered extends Animal{

    private String health;
    private int age;
    private String category;

//    public static final String
    public Endangered(String animalName, String health, int age) {
        super(animalName);
        this.health = health;
        this.age = age;
        this.category = "endangered";
    }
//    public static List<Endangered> getAllEndangered(){
//        String sql = "SELECT * FROM animals where category = 'endangered';";
//        try(Connection con = DB.sql2o.open()){
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(Endangered.class);
//        }
//    }


    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void save() {
        super.save();
        String sql = "INSERT INTO animals (animalName,health,age,category) VALUES(:animalName,:health,:age,:category)";
        try(Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName",this.animalName)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .addParameter("category",this.category)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Endangered> all(){
        String sql = "SELECT * FROM animals WHERE category = 'endangered';";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }
    public static Endangered searchById(int id){
        String sql = "SELECT * FROM animals WHERE id = :id";
        try(Connection con = DB.sql2o.open()){
            Endangered endangered = con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Endangered.class);
            return endangered;
        }
    }
}
