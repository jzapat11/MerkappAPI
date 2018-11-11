package co.com.merkapp.api.model;

import lombok.Data;

import java.util.List;

public @Data class UserItems {

    private String userId;
    private List<Item> items;
}
