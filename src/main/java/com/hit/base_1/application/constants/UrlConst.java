package com.hit.base_1.application.constants;

public class UrlConst {

    private UrlConst() {
    }

    public static final class User {
        private User() {
        }

        public static final String users = "/users";

        public static final String getUserById = users+"/{id}";
    }

}
