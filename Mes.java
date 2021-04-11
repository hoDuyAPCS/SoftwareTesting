package MobileAutomation;

public class Mes {
    String phone_num = "";
    String parent_name = "";
    String student_name = "";
    String student_id = "";
    String score = "";

    void getPhoneNum(String s){
        phone_num = s;
    }

    void getParentName(String s){
        parent_name = s;
    }

    void getStudentName(String s){
        student_name = s;
    }

    void getScore(String s){
        score = s;
    }

    void getStudentID(String s){
        student_id = s;
    }

    String givePhoneNum(){
        return phone_num;
    }
    String giveParentName(){
        return parent_name;
    }
    String giveStudentName() { return student_name; }
    String giveStudentID() {return student_id;}
    String giveScore() {return score;}
}
