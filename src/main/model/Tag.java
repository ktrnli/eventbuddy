package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.DoesNotContainException;

public class Tag {
    // tag belongs to a category
    // has a name
    // has a list of users belonging to that name
    private Category category;
    private String name;
    private Set<User> users;

    // creates a new Tag with a name, category it belongs to and a list of users
    public Tag(String name, Category category) {
        this.category = category;
        this.name = name;
        this.users = new HashSet<User>();
    }

    // adds a new user to the Tag
    public void addUser(User addThis) {
        users.add(addThis);
    }

    // removes user from the Tag
    public void removeUser(User removeThis) throws DoesNotContainException {
        if (users.contains(removeThis)) {
            users.remove(removeThis);
        } else {
            throw new DoesNotContainException();
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((users == null) ? 0 : users.hashCode());
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
        Tag other = (Tag) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (users == null) {
            if (other.users != null)
                return false;
        } else if (!users.equals(other.users))
            return false;
        return true;
    }

    
}
