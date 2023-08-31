package design_pattern.singleton;

public class UserService {
    private static class ClassHolder{
        private static final UserService userService = new UserService();
    }

    public static UserService getUserService(){
        return ClassHolder.userService;
    }

    public static void main(String[] args) {
        UserService u1 = UserService.getUserService();
        UserService u2 = UserService.getUserService();
        System.out.println(" u1 == u2 는 true OR false ? " + Boolean.toString(u1==u2));

        UserService u3 = ClassHolder.userService;
        System.out.println(" u1 == u3 는 true OR false ? " + Boolean.toString(u1==u3));
    }
}
