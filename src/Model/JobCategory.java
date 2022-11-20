package Model;

import java.util.Objects;

public class JobCategory {
    private int categoryId;
    private String categoryName;
    private String description;
    private String subCategory;

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobCategory)) return false;
        JobCategory that = (JobCategory) o;
        return getCategoryId() == that.getCategoryId() && getCategoryName().equals(that.getCategoryName()) && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getCategoryName(), getDescription());
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
