
@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository instanceRepo;

    public CourseInstance addInstance(CourseInstance instance) {
        return this.instanceRepo.save(instance);
    }

    public List<CourseInstance> getInstancesBySemester(Integer year, Integer semester) {
        return this.instanceRepo.findByYearAndSemester(year, semester);
    }

    public CourseInstance getInstanceDetail(Integer year, Integer semester, Long courseId) {
        return this.instanceRepo.findByYearAndSemesterAndCourseId(year, semester, courseId)
                .orElseThrow(() -> new RuntimeException("Instance not found"));
    }

    public void deleteInstance(Integer year, Integer semester, Long courseId) {
        CourseInstance instance = this.getInstanceDetail(year, semester, courseId);
        this.instanceRepo.delete(instance);
    }
}
