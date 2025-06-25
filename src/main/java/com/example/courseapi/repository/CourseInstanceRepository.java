
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

    List<CourseInstance> findByYearAndSemester(Integer year, Integer semester);

    Optional<CourseInstance> findByYearAndSemesterAndCourseId(Integer year, Integer semester, Long courseId);

    void deleteByYearAndSemesterAndCourseId(Integer year, Integer semester, Long courseId);
}
