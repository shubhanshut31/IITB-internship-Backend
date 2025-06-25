
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public Course addCourse(Course course) {
        // Prerequisite validation
        for (Long prereqId : course.getPrerequisites()) {
            if (!this.courseRepo.existsById(prereqId)) {
                throw new IllegalArgumentException("Prerequisite course not found: " + prereqId);
            }
        }
        return this.courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return this.courseRepo.findAll();
    }

    public Course getCourse(Long id) {
        return this.courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        List<Course> all = this.courseRepo.findAll();
        for (Course c : all) {
            if (c.getPrerequisites().contains(id)) {
                throw new RuntimeException("Course is a prerequisite for another. Cannot delete.");
            }
        }
        this.courseRepo.deleteById(id);
    }
}
