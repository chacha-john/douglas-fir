package chachaup;

import chachaup.domain.Animal;
import chachaup.domain.Endangered;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
            port(getHerokuAssignedPort());
            staticFileLocation("/public");

            // path to the home page
        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.getAll();
            model.put("animals",animals);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        //get - show more details about an animal
        get("/animals/:id",(request,response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(request.params(":id"));
            Animal animal = Animal.findById(idOfPostToFind);
            model.put("animal",animal);
            return new ModelAndView(model, "details.hbs");
        },new HandlebarsTemplateEngine());

        get("/animals/all/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-animal.hbs");
        }, new HandlebarsTemplateEngine());

        //get - form for adding endangered animal
        get("/animals/endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"add-endangered.hbs");
        }, new HandlebarsTemplateEngine());

        //post - process data collected when someone is adding a new animal
        post("/animals/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String nameOfAnimal = request.queryParams("animalName");
            Animal animal = new Animal(nameOfAnimal);
            animal.save();
            model.put("animal",animal);
            System.out.println(animal.getAnimalName());
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get - display all the animal
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.getAll();
            model.put("animals",animals);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get - display all endangered animals
        get("/animals/endangered/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> animals = Endangered.all();
            model.put("animals",animals);
            model.put("endangered",animals);
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());

//        post - process endangered animals input
        post("/animals/endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String health = request.queryParams("health");
            int ageCollected = Integer.parseInt(request.queryParams("age"));
            Endangered endangered = new Endangered(animalName,health,ageCollected);
            endangered.save();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
    }


}