package integration;

/**
 * Created by Anders on 2017-12-05.
 */
public class Format {
    private String name;
    private String description;
    private String butik;

    /**
     * Two columns
     * @param name
     * @param description
     */
    public Format(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * One column
     * @param butik
     */
    public Format(String butik) {
        this.butik = butik;
    }

    public String getButik() {
        return butik;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
