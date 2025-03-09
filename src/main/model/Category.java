package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.DoesNotContainException;

public class Category {
    private Set<Tag> tags;
    private String name;

    // creates a new category of tags with a name and empty list of tags
    public Category(String inName) {
        tags = new HashSet<Tag>();
        name = inName;
    }

    // adds a tag to the category
    public void addTag(Tag addThis) {
        tags.add(addThis);
    }

    // removes a tag from the category
    public void removeTag(Tag removeThis) throws DoesNotContainException {
        if (tags.contains(removeThis)) {
            tags.remove(removeThis);
        } else {
            throw new DoesNotContainException();
        }
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tags == null) ? 0 : tags.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (tags == null) {
            if (other.tags != null)
                return false;
        } else if (!tags.equals(other.tags))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
