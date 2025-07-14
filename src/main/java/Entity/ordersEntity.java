package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class ordersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private usersEntity ue;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private MenuEntity me;

    public ordersEntity() {}

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public usersEntity getUe() {
        return ue;
    }

    public void setUe(usersEntity ue) {
        this.ue = ue;
    }

    public MenuEntity getMe() {
        return me;
    }

    public void setMe(MenuEntity me) {
        this.me = me;
    }
}
