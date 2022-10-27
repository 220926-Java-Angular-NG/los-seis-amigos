package org.project2.controller;
import org.project2.model.User;
import org.project2.services.UserServices;
import io.javalin.http.Handler;

public class UserController {

    UserServices services;

    public UserController(){

        services = new UserServices();
    }

    public UserController(UserServices userServices){
        services = userServices;
    }

    // CREATE A NEW USER HANDLER //////////////////////////////

    public Handler createNewUser = context ->{

        //send the user to our service -> repo layers

        User user = context.bodyAsClass(User.class);
        int id = services.createUser(user);

        // id is a valid number
        if (id > 0 ){
            user.setId(id);
            context.json(user).status(200);

        }
        // id out of bounds/ does not exist
        else{
            context.result("User not created").status(400);
        }
    };

    //GET USER BY ID HANDLER///////////////////////////////////////////////////

    public Handler getUserById = context ->  {
        String param = context.pathParam("id");
        User user = context.bodyAsClass(User.class); // model on db

        try{
            //get the id from the url
            int id= Integer.parseInt(param);
            user = services.getById(id);

            if(user != null){
                context.json(user).status(202);
            }else{
                context.result("User not found!").status(400);
            }
        }catch(NumberFormatException nFE){
            System.out.println(nFE.getMessage());

        }

    };

    //UPDATE USER HANDLER/////////////////////////////////////////////////


    public Handler updateUser = context -> {
        User user = context.bodyAsClass(User.class);// model on db
        user = services.updateUser(user);

        if(user != null){
            context.json(user).status(202);
        }else{
            context.result("User not updated!").status(400);
        }
    };

    //LOGIN USER HANDLER//////////////////////////////////////////////////

    public Handler loginUser = context -> {
        User user = context.bodyAsClass(User.class);// model on db
        user = services.getByLogin(user);
        System.out.println(user.toString());
        if (user != null){

           context.json(user).status(202).result("User logged in successful!");

        }else {
            context.result("Sorry, wrong email or password!").status(404);
        }


    };
}
