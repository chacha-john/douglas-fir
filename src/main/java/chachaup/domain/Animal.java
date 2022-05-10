package chachaup.domain;

import chachaup.database.DB;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {
    public int id;
    public String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && animalName.equals(animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalName);
    }

    public void save(){
        String sql = "INSERT INTO animals (animalName) VALUES(:animalName)";
        try(Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName",this.animalName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> getAll(){
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }

    public static Animal findById(int id){
        String sql = "SELECT * FROM animals WHERE id = :id";
        try(Connection con = DB.sql2o.open()){
            Animal animal = con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
    public static List<Animal> getUnique(){
        String sql = "SELECT DISTINCT animalName FROM animals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }
}
