package edu.school21.chat.models;

import java.util.List;

public class Chat {
    class Users {
        private Long id;
        private String userLogin;
        private String userPassword;
        private List<Long> createdRooms;
        private List<Long> createdRoomWhereUserSocializes;

        @java.lang.Override
        public java.lang.String toString() {
            return "Users{" +
                    "id=" + id +
                    ", userLogin=" + userLogin +
                    ", userPassword=" + userPassword +
                    ", createdRooms=" + createdRooms +
                    ", createdRoomWhereUserSocializes=" + createdRoomWhereUserSocializes +
                    '}';
        }
    }
    class Chatroom {
        private Long id;
        private String chatroomName;
        private Long chatroomOwnerId;
        private List<Long> listOfMessages;
    }
    class Message {
        private Long id;
        private Long authorId;
        private Long roomId;
        private String messageText;
        private String dataTime;
    }

}
