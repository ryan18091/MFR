public class Teacher {

    public String name;
    public Integer gradeLevel;
    public Integer salary;

    public Teacher(String name, Integer gradeLevel, Integer salary) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
