package practice.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "name")
public class Name implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;

    public Integer getID(){
        return id;
    }
    public String  setName(String name) {
        this.name = name;
        return name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "test{" +
                "name='" + name + "\' }";
    }
}
