
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId;
    private Integer year;
    private Integer semester;
}
