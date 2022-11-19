public class SubCategory {
    private int subCatId;
    private String subCatTitle;
    private String subCatDescription;
    private int catId;

    public String getSubCatTitle() {
        return subCatTitle;
    }

    public void setSubCatTitle(String subCatTitle) {
        this.subCatTitle = subCatTitle;
    }

    public String getSubCatDescription() {
        return subCatDescription;
    }

    public void setSubCatDescription(String subCatDescription) {
        this.subCatDescription = subCatDescription;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
