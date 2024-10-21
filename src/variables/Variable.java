package variables;

public class Variable {
    String name;
    Integer use;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getUse() {
        return use;
    }

    public void setUse(Integer use) {
        this.use = use;
    }
}
