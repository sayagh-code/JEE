package ma.emsi.main.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity @Table(name = "EMSI_GROUPES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Groupe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String groupName;
    @OneToMany(mappedBy = "groupe")
    private Collection<Student> etudiant;
}
