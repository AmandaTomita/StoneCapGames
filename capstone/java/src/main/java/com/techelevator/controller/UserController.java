package com.techelevator.controller;

import com.techelevator.dao.BoardGameDao;
import com.techelevator.dao.FriendDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.BoardGame;
import com.techelevator.model.Friend;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private UserDao userDao;
    private BoardGameDao boardGameDao;
    private FriendDao friendDao;
    private PostDao postDao;
    //private String path = "/user";

    public UserController(UserDao userDao, BoardGameDao boardGameDao, FriendDao friendDao, PostDao postDao) {
        this.userDao = userDao;
        this.boardGameDao = boardGameDao;
        this.friendDao = friendDao;
        this.postDao = postDao;
    }

    @RequestMapping(path = "/all-users", method = RequestMethod.GET)
    public List<String> findAll() {
        List<String> usernames = new ArrayList<>();
        List<User> users = userDao.findAll();
        for (User user: users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        return user;
    }

    @RequestMapping(path = "/user/{userId}/friends", method = RequestMethod.GET)
    public List<Integer> findAllFriendsById(@PathVariable int userId){
        List<Integer> friendsUserIds = new ArrayList<>();
        List<Friend> friends = friendDao.findAllFriendsById(userId);
        for (Friend friend : friends) {
            friendsUserIds.add(friend.getUserIdTwo());
        }
        return friendsUserIds;
    }
    @RequestMapping(path = "/user/MyFriends", method = RequestMethod.GET)
    public List<User> findAllFriendsById(Principal principle){
        String username = principle.getName();
        int userId= userDao.findByUsername(username).getId();
        List<Integer> friendsUserIds = new ArrayList<>();
        List<Friend> friends = friendDao.findAllFriendsById(userId);
        List<User> users = new ArrayList<>();
        for (Friend friend : friends) {
            friendsUserIds.add(friend.getUserIdTwo());
        }
        for (int Id :friendsUserIds){
            users.add(userDao.getUserById(Id));
        }
        return users;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/user/{username}/add-friend")
    public Friend createFriendship(@RequestBody Friend newFriend){
        return friendDao.createFriendship(newFriend);
    }

    @RequestMapping(path = "/user/friends/{friendId}")
    public Friend createFriendship(@PathVariable int friendId){
        return friendDao.getFriend(friendId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/user/{username}/remove-friend", method = RequestMethod.DELETE)
    public void deleteFriend(@PathVariable int userId){
        friendDao.deleteFriend(userId);
    }

    @RequestMapping(path = "/user/boardgame/{boardGameId}")
    public List<String> usersByBoardGame(@PathVariable String boardGameId){
        List<String> users = new ArrayList<>();
        List<User> getUsersByBoardGame = userDao.usersByBoardGame(boardGameId);
        for(User user : getUsersByBoardGame) {
            users.add(user.getUsername());
        }
        return users;
    }
    @RequestMapping(path = "/user/search/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable String username) {
        User user = userDao.findByUsername(username);

        return user;
    }
    @RequestMapping(path = "/user/search/contains/{username}", method = RequestMethod.GET)
    public List<User> getUserByUsernameFuzzy(@PathVariable String username) {
        List<User> userList = userDao.findByUsernameContains(username);

        return userList;
    }


}
