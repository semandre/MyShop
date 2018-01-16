package menu.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long code;
    private String shortCut;
    @Column(columnDefinition="TEXT")
    private String cityName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city")
    private List<Client> clients;
    public City(int code, String shortCut, String cityName) {
        this.code = code;
        this.shortCut = shortCut;
        this.cityName = cityName;
    }


}
