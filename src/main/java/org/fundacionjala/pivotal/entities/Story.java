package org.fundacionjala.pivotal.entities;

public class Story {
    private String id;
    private String name;

    /**
     * Constructor for Story class.
     * @param storyName of the Story
     */
    public Story(String storyName) {
        this.name = storyName;
    }

    /**
     * Gets the id of the story.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the story.
     * @param storyId
     */
    public void setId(String storyId) {
        this.id = storyId;
    }

    /**
     * Gets the name of the story.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the story.
     * @param storyName
     */
    public void setName(String storyName) {
        this.name = storyName;
    }
}
