package co.com.merkapp.api.controller;

import co.com.merkapp.api.model.Item;
import co.com.merkapp.api.model.LoginCredentials;
import co.com.merkapp.api.model.User;
import co.com.merkapp.api.model.UserItems;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/merkapi")
public class MerkappRestController {

    @RequestMapping(
            path = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> loginUser(@RequestBody LoginCredentials loginCredentials){

        System.out.println("Login attempt: ...........");
        System.out.println("Credentials sent: ");
        System.out.println(loginCredentials.getUser() + "/" + loginCredentials.getPassword());

        System.out.println("Retrieving user...........");
        User user = new User();
        user.setId(1);
        user.setName("Juan");
        user.setLastame("Zapata");
        user.setPassword("12345");
        user.setEmail("jzapat11@gmail.com");

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @RequestMapping(
            path = "/items/{userid}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserItems> getItemListPerUser(@PathVariable("userid") String userid){

        System.out.println(" #### Retriveing market items for user: " + userid);

        List<Item> items = new ArrayList<>();

        UserItems userItems = new UserItems();
        Item item = new Item();
        item.setItemId("1");
        item.setItemName("Arepas");
        items.add(item);

        item = new Item();
        item.setItemId("2");
        item.setItemName("Mantequilla");
        items.add(item);

        item = new Item();
        item.setItemId("3");
        item.setItemName("Quesito");
        items.add(item);

        item = new Item();
        item.setItemId("4");
        item.setItemName("Galletas");
        items.add(item);

        userItems.setUserId(userid);
        userItems.setItems(items);

        return new ResponseEntity(userItems, HttpStatus.OK);
    }

    public ResponseEntity<?> createMarketItem(){
        return null;
    }

    public ResponseEntity<?> updateMarketItem(){
        return null;
    }

    public ResponseEntity<?> deleteMarketItem(){
        return null;
    }
}
