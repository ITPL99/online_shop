package application.dto;

public class UserDTORegister {
    private String username;
    private String password;

                 /*
        login,
        pass,
        firstName,
        surname,
        thirdName,
        dataBerth,
        email[],
        phone[],
        address,
        INN,
        MKK,
        Foto,
        Рост,
        вес,
        Gender,
        Семейное положениеб
        семьях[]
 */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
