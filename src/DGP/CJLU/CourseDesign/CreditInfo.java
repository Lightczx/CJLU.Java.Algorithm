package DGP.CJLU.CourseDesign;

/**
 * @author 16861
 */
public class CreditInfo implements Comparable<CreditInfo> {
    public String number;
    public String name;
    public String address;
    public String phone;

    @Override
    public int compareTo(CreditInfo o) {
        return number.compareTo(o.number);
    }
}
