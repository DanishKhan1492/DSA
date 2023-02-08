package algolab.warmup;

public class DefangIpAddr {

    public static void main(String[] args) {
        System.out.println(defangIPAddr("192.168.1.1"));
    }

    /**
     *  Solution1: Using replaceAll function replace . with [.]
     *  Solution2: First splitting the IP address by . (dot) and then joining the array back with [.]
     *  Solution3: In this solution we are simply splitting the ip address on . (dot)
     *  Then iterate over the array and append the every section by [.]
     *
     *  TimeComplexity: O(1) IP address is always in a length of 4 sections. e.g. 192.168.1.2.
     *  Space Complexity: O(1) As the splitting give us a static array length of 4.
     *
     *  Same and Time Complexity is same for all the below solutions.
     * */

    public static String defangIPAddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static String defangIPAddrSolution1(String address) {
        String[] addrArr = address.split("\\.");
        return String.join("[.]", addrArr);
    }
    public static String defangIPAddrSolution2(String address) {
        String[] addrArr = address.split("\\.");
        StringBuilder deFangedIp = new StringBuilder();
        for (int i = 0; i < addrArr.length; i++){
            if(i == addrArr.length - 1 ){
                deFangedIp.append(addrArr[i]);
            }else{
                deFangedIp.append(addrArr[i]).append("[.]");
            }
        }
        return deFangedIp.toString();
    }


}
