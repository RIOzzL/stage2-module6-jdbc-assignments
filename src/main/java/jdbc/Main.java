package jdbc;

public class Main {
    public static void main(String[] args) {
        User user = User.builder().firstName("Roman")
                .lastName("Gulevich")
                .age(26).build();

        SimpleJDBCRepository repository = new SimpleJDBCRepository();
        Long user1 = repository.createUser(user);
        user.setId(user1);
        System.out.println(repository.findUserById(user.getId()).getFirstName());
        System.out.println(repository.findUserByName(user.getFirstName()).getFirstName());
        user.setFirstName("Polina");
        repository.updateUser(user);
        System.out.println(repository.findUserById(user.getId()).getFirstName());
        repository.deleteUser(user.getId());
    }
}
