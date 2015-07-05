package com.gmail.miv;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfGroups")
public class ListOfGroups {

    @XmlElement(name = "Group")
    @XmlElementWrapper(name = "List")
    private Set<Group> groups = new HashSet<Group>();

    public ListOfGroups() {
    }

    public void addGroup(String desc, int id) {
        groups.add(new Group(desc, id));

    }

    public void addGroup(Group group) {
        groups.add(group);

    }

    public void removeByID(int id) {
        groups.removeIf(e -> e.getId() == id);
    }

    public Group getGroupByID(int id) {
        return groups.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    @Override
    public String toString() {

        String result = "List of groups:\n";

        Iterator<Group> it = groups.iterator();

        while (it.hasNext()) {
            Group next = it.next();
            result += "" + next.getId() + " - " + next.getDescription() + "\n";
        }

        return result;
    }

}
