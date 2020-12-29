package org.fundacionjala.pivotal.entities;

public class Project {

    private String id;
    private String name;
    private String account;
    private String privacy;

    /**
     * Gets the id of the project.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the project.
     * @param pId
     */
    public void setId(String pId) {
        this.id = pId;
    }

    /**
     * Gets the name of the project.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the project.
     * @param pName
     */
    public void setName(String pName) {
        this.name = pName;
    }

    /**
     * Gets the account of the project.
     * @return
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account of the project.
     * @param pAccount
     */
    public void setAccount(String pAccount) {
        this.account = pAccount;
    }

    /**
     * Gets the privacy of the project.
     * @return privacy
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Sets the privacy of the project.
     * @param pPrivacy
     */
    public void setPrivacy(String pPrivacy) {
        this.privacy = pPrivacy;
    }
}
