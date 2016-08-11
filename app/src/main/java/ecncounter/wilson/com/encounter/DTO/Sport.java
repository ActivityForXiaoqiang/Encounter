package ecncounter.wilson.com.encounter.DTO;

/**
 * Created by Administrator on 2016/8/9.
 */
public class Sport {
    private int id;
    private String tags;
    private boolean isSelected;

    public Sport() {
    }

    public Sport(int id, String tags, boolean isSelected) {
        this.id = id;
        this.tags = tags;
        this.isSelected = isSelected;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
