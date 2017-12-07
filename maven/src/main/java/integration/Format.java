package integration;

/**
 * Created by Anders on 2017-12-05.
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
