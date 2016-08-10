package ecncounter.wilson.com.encounter.DTO;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Proposal {
    private int id;
    private String tags;
    private String time;

    public Proposal() {
    }

    public Proposal(int id, String tags, String time) {
        this.id = id;
        this.tags = tags;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
