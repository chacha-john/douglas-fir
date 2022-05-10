package chachaup.domain;

import chachaup.database.DB;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Sighting {
    private int id;
    private String animalName;
    private Timestamp timeOfSight;
    private String rangerName;

    public Sighting(String animalName, String rangerName) {
        this.animalName = animalName;
        this.rangerName = rangerName;
        timeOfSight = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Timestamp getTimeOfSight() {
        return timeOfSight;
    }

    public void setTimeOfSight(Timestamp timeOfSight) {
        this.timeOfSight = timeOfSight;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }
    public void save(){
        String sql = "INSERT INTO sightings (animalName, rangerName,timeOfSight) VALUES(:animalName, :rangerName, now())";
        try(Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName",this.animalName)
                    .addParameter("rangerName",this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sighting> getAll(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
    
    public static Sighting findById(int id){
        String sql = "SELECT * FROM sightings WHERE id = :id";
        try(Connection con = DB.sql2o.open()){
            Sighting sighting = con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }

}
