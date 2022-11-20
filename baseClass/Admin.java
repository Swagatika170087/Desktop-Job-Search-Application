public class Admin extends User
{
    private int adminID;
    private String company;

    public Admin(int userID, int adminID, String company)
    {
        super(userID);
        this.adminID = adminID;
        this.company = company;
    }

    public int getUserID()
    {
        return super.getUserID();
    }

    public int getAdminID()
    {
        return adminID;
    }

    public String getCompany()
    {
        return company;
    }

    public void setAdminID(int adminID)
    {
        this.adminID = adminID;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }
}
