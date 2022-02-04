public class Problem_1_1 {
    public static void main(String[] args) {
        int numPeople = 312032486;
        int yearB = 31536000, yearD = 31536000, yearI = 31536000, tempYearValue = 31536000;

        for (int i = 0; i < 5; i++) {
            int birth = yearB / 7;
            int death = yearD / 13;
            int newImmi = yearI / 45;
            numPeople += (birth - death + newImmi);
            System.out.printf("Year %d : %d\n", i + 1, numPeople);
            yearB = (tempYearValue + yearB % 7);
            yearD = (tempYearValue + yearD % 7);
            yearI = (tempYearValue + yearI % 7);
        }
    }
}