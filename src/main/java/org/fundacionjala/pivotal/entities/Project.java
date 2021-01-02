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
     * @param projectId
     */
    public void setId(final String projectId) {
        this.id = projectId;
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
     * @param projectName
     */
    public void setName(final String projectName) {
        this.name = projectName;
    }

    /**
     * Gets the account of the project.
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account of the project.
     * @param projectAccount
     */
    public void setAccount(final String projectAccount) {
        this.account = projectAccount;
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
     * @param projectPrivacy
     */
    public void setPrivacy(final String projectPrivacy) {
        this.privacy = projectPrivacy;
    }
}
