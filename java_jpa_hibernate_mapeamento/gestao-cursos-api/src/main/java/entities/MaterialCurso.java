package entities;

import javax.persistence.*;

@Entity
public class MaterialCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String url;

    @OneToOne(mappedBy = "materialCurso")
    Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MaterialCurso{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
