package integration;

/**
 * This class helps with the formatting of our output to users
 * U can use one, two, three or four columns
 */
public class Format {
    private String first;
    private String second;
    private String third;
    private String fourth;


    /**
     * Four columns
     * @param first
     * @param second
     * @param third
     * @param fourth
     */
    public Format(String first, String second, String third, String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    /**
     * Three columns
     * @param first
     * @param third
     * @param third
     */
    public Format(String first, String second, String third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Two columns
     * @param first
     * @param second
     */
    public Format(String first, String second) {
        this.first = first;
        this.second = second;
    }

    /**
     * One column
     * @param first
     */
    public Format(String first) {
        this.first = first;
    }


    /**
     * Getters
     * @return
     */
    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }

    public String getFourth() {
        return fourth;
    }
}
