package coursework.sushi.model;

import coursework.sushi.entity.UserEntity;

public class User {
    private Long id;
    private String username;
    private int role;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setRole(entity.getRole());
        return model;
    }
    public User() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
