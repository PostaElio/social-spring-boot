package alkemy.firstdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Where(clause = "softdelete = false" )
@Entity(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String category;
    @Temporal(value = TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private Date creationdate;
    @ManyToOne
    private UserEntity author;
    @JsonIgnore
    @Column(name = "softdelete",columnDefinition = "boolean DEFAULT 'false'")
    private boolean softdelete = false;

    public PostEntity(String title, String content, String image, String category, Date creationdate, UserEntity author) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.category = category;
        this.creationdate = creationdate;
        this.author = author;
    }

}
