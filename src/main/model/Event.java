package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import exceptions.DoesNotContainException;

public class Event {
    // event contains:
    // - a title
    // - a description
    // - a date (or date range)
    // - a list of tags
    // - a list of attendees

    private String imageURL;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Set<Tag> tags;
    private Set<User> attendees;
    private String host;
    private String location;

    // create an event with a start and end date
    public Event(String title, String image, String host, String location, String description, Date startDate, Date endDate) {
        this.title = title;
        this.imageURL = image;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.host = host;
        this.tags = new HashSet<Tag>();
        this.attendees = new HashSet<User>();
    }

    // adds a new user to attendees list
    public void addUser(User addThis) {
        attendees.add(addThis);
    }

    // removes user from the attendees list
    public void removeUser(User removeThis) throws DoesNotContainException {
        if (attendees.contains(removeThis)) {
            attendees.remove(removeThis);
        } else {
            throw new DoesNotContainException();
        }
    }

    // adds a new Tag to tags
    public void addTag(Tag addThis) {
        tags.add(addThis);
    }

    // removes user from the attendees list
    public void removeTag(Tag removeThis) throws DoesNotContainException {
        if (tags.contains(removeThis)) {
            tags.remove(removeThis);
        } else {
            throw new DoesNotContainException();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
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
        Event other = (Event) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (host == null) {
            if (other.host != null)
                return false;
        } else if (!host.equals(other.host))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        return true;
    }

    

}
