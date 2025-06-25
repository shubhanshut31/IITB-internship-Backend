
@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService instanceService;

    @PostMapping
    public CourseInstance addInstance(@RequestBody CourseInstance instance) {
        return this.instanceService.addInstance(instance);
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getBySemester(@PathVariable Integer year, @PathVariable Integer semester) {
        return this.instanceService.getInstancesBySemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public CourseInstance getInstanceDetail(@PathVariable Integer year, @PathVariable Integer semester,
            @PathVariable Long id) {
        return this.instanceService.getInstanceDetail(year, semester, id);
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<?> deleteInstance(@PathVariable Integer year, @PathVariable Integer semester,
            @PathVariable Long id) {
        try {
            this.instanceService.deleteInstance(year, semester, id);
            return ResponseEntity.ok("Instance deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
