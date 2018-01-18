package com.zgodnji.fifastattracker;

import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;


@RequestScoped
@Path("user-friends")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public Response getAllUsers() {
        Map<String, List<UserFriends>> users = Database.getUsers();
        return Response.ok(users).build();
    }

    @GET
    @Path("{userId}")
    public Response getFriends(@PathParam("userId") String userId) {
        List<UserFriends> friends = Database.getFriends(userId);
        return friends != null
                ? Response.ok(friends).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @Inject
    @DiscoverService(value = "user-friends-service", environment = "dev", version = "1.0.0")
    private String urlString;


    /*
    @POST
    public Response addUser(String id, String friends) {
        Database.addUser(id, friends);
        return Response.noContent().build();
    }
    */

    @DELETE
    @Path("{userId}")
    public Response deleteUser(@PathParam("userId") String userId) {
        Database.deleteUser(userId);
        return Response.noContent().build();
    }

    @GET
    @Path("create")
    public Response fillDatabse() {

        List<UserFriends> friends = new ArrayList<UserFriends>();
        friends.add(new UserFriends("3", new Date(), true, "Zivjo, veselim se tekmovanja s tabo!"));
        friends.add(new UserFriends("4", new Date(), false, "Zivjo, veselim se tekmovanja s tabo!"));
        friends.add(new UserFriends("5", new Date(), false, "Zivjo, veselim se tekmovanja s tabo!"));

        Database.addUser("1", friends);
        Database.addUser("2", friends);

        return Response.noContent().build();
    }

    @Inject
    private UserFriendsProperties properties;

    @GET
    @Path("config")
    public Response getConfig() {
        String response =
                "{" +
                        "\"stringProperty\": \"%s\"," +
                        "\"booleanProperty\": %b," +
                        "\"integerProperty\": %d" +
                        "}";

        response = String.format(
                response,
                properties.getStringProperty(),
                properties.getBooleanProperty(),
                properties.getIntegerProperty());

        return Response.ok(response).build();
    }

}
