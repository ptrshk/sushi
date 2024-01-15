package coursework.sushi.model;


import coursework.sushi.entity.SushiEntity;

public class Sushi {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageLink;

    public static Sushi toModel(SushiEntity entity) {
        Sushi model = new Sushi();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPrice(entity.getPrice());
        model.setDescription(entity.getDescription());
        model.setImageLink(entity.getImageLink());
        return model;
    }
    public Sushi() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageLink() {
        return imageLink;
    }
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
