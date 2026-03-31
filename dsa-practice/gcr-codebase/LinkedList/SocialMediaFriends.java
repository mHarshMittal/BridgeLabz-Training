class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

class SocialNetwork {
    private UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode user = new UserNode(userId, name, age);
        user.next = head;
        head = user;
    }

    private UserNode findUserById(int userId) {
        UserNode curr = head;
        while (curr != null) {
            if (curr.userId == userId) return curr;
            curr = curr.next;
        }
        return null;
    }

    public UserNode searchByName(String name) {
        UserNode curr = head;
        while (curr != null) {
            if (curr.name.equalsIgnoreCase(name)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        addFriendToList(u1, userId2);
        addFriendToList(u2, userId1);

        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    private void addFriendToList(UserNode user, int friendId) {
        FriendNode f = new FriendNode(friendId);
        f.next = user.friends;
        user.friends = f;
    }

    public void removeFriendConnection(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        removeFriendFromList(u1, userId2);
        removeFriendFromList(u2, userId1);

        System.out.println("Friend connection removed.");
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode curr = user.friends, prev = null;

        while (curr != null) {
            if (curr.friendId == friendId) {
                if (prev == null) user.friends = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode curr = user.friends;
        if (curr == null) {
            System.out.println("No friends.");
            return;
        }

        while (curr != null) {
            System.out.print(curr.friendId + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void countFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        int count = 0;
        FriendNode curr = user.friends;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        System.out.println(user.name + " has " + count + " friends.");
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.print("Mutual friends of " + u1.name + " and " + u2.name + ": ");

        FriendNode f1 = u1.friends;
        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found) System.out.print("None");
        System.out.println();
    }

    public void searchUser(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("Found: " + user.userId + " | " + user.name + " | " + user.age);
        }
    }
}


public class SocialMediaFriends {
    public static void main(String[] args) {

        SocialNetwork sn = new SocialNetwork();

        sn.addUser(1, "Arjun", 21);
        sn.addUser(2, "Aman", 22);
        sn.addUser(3, "Rahul", 20);
        sn.addUser(4, "Rohan", 23);

        sn.addFriendConnection(1, 2);
        sn.addFriendConnection(1, 3);
        sn.addFriendConnection(2, 3);
        sn.addFriendConnection(3, 4);

        sn.displayFriends(1);
        sn.displayFriends(3);

        sn.findMutualFriends(1, 2);
        sn.findMutualFriends(1, 4);

        sn.countFriends(3);

        sn.searchUser(2);

        sn.removeFriendConnection(1, 3);
        sn.displayFriends(1);
        sn.displayFriends(3);
    }
}