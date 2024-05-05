package comp3111.qsproject;

import java.lang.reflect.Field;

/**
 * One QS info item
 */

public class QSItem {
    public String name;
    public String year;
    public String rank;
    public String score;
    public String country;
    public String city;
    public String region;
    public String type;
    public String researchOutput;
    public String studentFacultyRatio;
    public String internationalStudents;
    public String size;
    public String facultyCount;
    public String grade;

    public String link;

    public String logo;

    QSItem(String[] string_line) {
        assert(string_line.length == 15);
        name = string_line[0];
        year = string_line[1];
        rank = string_line[2];
        score = string_line[3];
        link = string_line[4];
        country = string_line[5];
        city = string_line[6];
        region = string_line[7];

        logo = string_line[8];
        type = string_line[9];
        researchOutput = string_line[10];
        studentFacultyRatio = string_line[11];
        internationalStudents = string_line[12];
        size = string_line[13];
        facultyCount = string_line[14];

        grade = "N/A";
    }

    public String getRank() {
        return rank;
    }

    public String getName() { return name; }

    public String getScore() { return score; }

    public String getCountry() { return country; }

    public String getCity() { return city; }

    public String getType() { return type; }

    public String getResearchOutput() { return researchOutput; }

    public String getStudentFacultyRatio() {return  studentFacultyRatio; }

    public String getInternationalStudents() {
        return internationalStudents;
    }

    public String getFacultyCount() {
        return facultyCount;
    }

    public String getYear() {
        return year;
    }
    public String getRegion() {
        return region;
    }
    public String getSize() {
        return size;
    }


    public String getLink() { return link; }


    public String getLogo() { return logo; }


    public String getGrade() {
        return grade;
    }

    public double getDoubleScore() {
        double g = 0.0;
        try {
            g = Double.parseDouble(this.getScore());
        } catch (NumberFormatException e) {

        }
        return g;
    }




    /**
     * Sets the grade for a QSItem based on the provided mean and standard deviation.
     * The grade is determined by comparing the difference between the item's score
     * and the mean score with multiples of the standard deviation.
     *
     * @param mean The mean score for the dataset.
     * @param sd   The standard deviation of scores for the dataset.
     *
     *    grading system:
     *         >2sd -> A+
     *         >1.6sd -> A
     *         >1sd -> A-
     *         >0.6sd -> B+
     *         >0sd -> B
     *         >-0.6sd -> B-
     *         >-1sd -> C+
     *         >-1.6sd -> C
     *         >-2sd -> C-
     *         below 2sd -> D
     */
    public void setGrade(double mean, double sd) {
        double diff = getDoubleScore()-mean;
        if(getDoubleScore()>0){
            if (diff>=2*sd){
                this.grade = "A+";
            } else if (diff>=1.6*sd){
                this.grade = "A";
            } else if (diff>=1*sd){
                this.grade = "A-";
            } else if (diff>=0.6*sd){
                this.grade = "B+";
            } else if (diff>=0){
                this.grade = "B";
            } else if (diff>=-0.6*sd){
                this.grade = "B-";
            } else if (diff>=-1*sd){
                this.grade = "C+";
            } else if (diff>=-1.6*sd){
                this.grade = "C";
            } else if (diff>=-2*sd){
                this.grade = "C-";
            } else if (diff>=-10*sd){
                this.grade = "D";
            }
        } else {
            System.out.println("no score");
        }
    }

    String getProperty(String property) {
        String propertyValue = new String();
        /*
            return the property value.
            use JAVA reflection.
         */
        return propertyValue;
    }
}
