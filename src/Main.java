import baseSystem.GlobalStrings;
import baseSystem.Management;
import baseSystem.ManagementInter;
import globalData.GlobalData;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import menuEnums.FirstMenu;
import service.Interfaces.LoginServiceInter;
import service.LoginService;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        LoginServiceInter loginService = new LoginService();
        ManagementInter management = new Management();
//        for(int i = 0 ; i<GlobalData.dynamicArrayPerson.size() ; i++){
//            System.out.println(GlobalData.dynamicArrayPerson.get(i));
//        }

        boolean sign = true;
        while (sign) {
            for (FirstMenu firstMenu : FirstMenu.values()) {
                System.out.println("[" + firstMenu.getId() + "]" + "--->" + firstMenu.getOption());
            }
            Person loggedIn = null;
            try {
                int option = InputUtil.inputInt("Choose option:");
                switch (option) {
                    case 1:
                        boolean backToLogin = false;
                        loggedIn = loginService.login(InputUtil.inputString("Enter username: "));
                        GlobalData.loginPerson = loggedIn;

                        if (loggedIn != null) {
                            String log = "Person logged with name: "+loggedIn.getName()+" "+loggedIn.getSurname()+" " + "Time: "+ LocalDateTime.now();
                            FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                            if (loggedIn instanceof Admin) {
                                System.out.println("Welcome " + loggedIn.getName() + " ><!");
                                while (!backToLogin) {
                                    backToLogin = management.adminSpecification();
                                }
                            } else if (loggedIn instanceof Teacher) {
                                System.out.println("Welcome " + loggedIn.getName() + " ><!");
                                while (!backToLogin) {
                                    backToLogin = management.teacherSpecification();
                                }
                            } else if (loggedIn instanceof Student) {
                                System.out.println("Welcome " + loggedIn.getName() + " ><!");
                                while (!backToLogin) {
                                    backToLogin = management.studentSpecification(loggedIn);
                                }
                            }
                        }
                        break;
                    case 0:
                        FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
                        FileUtils.saveAllClasses(GlobalStrings.SAVE_CLASS_NAME);
                        loginService.exit();
                        break;
                    default:
                        System.out.println("Wrong option!");
                        break;

                }
            } catch (InputMismatchException ex) {
                System.out.println("You can enter only numbers!");

            }
        }
    }
}