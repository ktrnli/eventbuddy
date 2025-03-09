package model;

import java.util.HashSet;
import java.util.Set;

import exceptions.DoesNotContainException;
import exceptions.NotAUserTagOption;

public class User {
    // has a list of identity tags
    // has a list of interest tags
    // has a list of events
    // has a list of looking-for tags
    // has a description
    // has a profile picture
    // has a list of messengers

    private Set<Tag> userTags;
    private Set<Tag> interestTags;
    private Set<Event> eventsAttending;
    private Set<Tag> lookingForTags;
    private String description;
    private String imageURL;
    private String name;

    public User(String name, String image, String description) {
        this.name = name;
        this.imageURL = image;
        this.description = description;
        userTags = new HashSet<Tag>();
        interestTags = new HashSet<Tag>();
        lookingForTags = new HashSet<Tag>();
        eventsAttending = new HashSet<Event>();
    }

    // adds a new Tag to one of the lists
    public void addTagToList(Tag addThis, Character c) throws NotAUserTagOption {
        switch (c) {
            case 'u':
                userTags.add(addThis);
                break;
            case 'i':
                interestTags.add(addThis);
                break;
            case 'l':
                lookingForTags.add(addThis);
                break;
            default:
                throw new NotAUserTagOption();
        }
    }

    // removes Tag from one of the lists
    public void removeUser(User removeThis, Character c) throws DoesNotContainException, NotAUserTagOption {
        switch (c) {
            case 'u':
                if (userTags.contains(removeThis)) {
                    userTags.remove(removeThis);
                } else {
                    throw new DoesNotContainException();
                }
                break;
            case 'i':
                if (interestTags.contains(removeThis)) {
                    interestTags.remove(removeThis);
                } else {
                    throw new DoesNotContainException();
                }
                break;
            case 'l':
                if (lookingForTags.contains(removeThis)) {
                    lookingForTags.remove(removeThis);
                } else {
                    throw new DoesNotContainException();
                }
                break;
            default:
                throw new NotAUserTagOption();
        }
    }

    // adds a new Event to eventsAttending
    public void addEvent(Event addThis) {
        eventsAttending.add(addThis);
    }

    // removes Event from eventsAttending
    public void removeEvent(Event removeThis) throws DoesNotContainException {
        if (eventsAttending.contains(removeThis)) {
            eventsAttending.remove(removeThis);
        } else {
            throw new DoesNotContainException();
        }
    }

    public Set<Tag> getUserTags() {
        return userTags;
    }

    public void setUserTags(Set<Tag> userTags) {
        this.userTags = userTags;
    }

    public Set<Tag> getInterestTags() {
        return interestTags;
    }

    public void setInterestTags(Set<Tag> interestTags) {
        this.interestTags = interestTags;
    }

    public Set<Event> getEventsAttending() {
        return eventsAttending;
    }

    public void setEventsAttending(Set<Event> eventsAttending) {
        this.eventsAttending = eventsAttending;
    }

    public Set<Tag> getLookingForTags() {
        return lookingForTags;
    }

    public void setLookingForTags(Set<Tag> lookingForTags) {
        this.lookingForTags = lookingForTags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
