public class LetterAdd {

    public static void main(String[] args) {
        System.out.println(getYcbhStr(53));
    }

    /**
     *
     * @param size > 0
     * @return
     */
    private static String getYcbhStr(int size){
        StringBuffer res = new StringBuffer();
        String info = "样车";
        for(int i = 0; i < size; i++){
            String toStr = to26Str(i);
            String removeToStr = removeStartA(toStr);
            if(i == size - 1){
                res.append(info + removeToStr);
            }else{
                res.append(info + removeToStr + ",");
            }
        }
        return res.toString();
    }

    private static String removeStartA(String toStr){
        if(toStr.startsWith("A")&& toStr.length() > 1){
            toStr = toStr.substring(1);
            return removeStartA(toStr);
        }else{
            return toStr;
        }

    }


    private static String to26Str(int l) {
        StringBuffer sb = new StringBuffer();
        int jinz = 26;
        boolean f = true;
        while (f) {
            sb.insert(0, ((char) (l % jinz  + 65)));
            l = l / jinz;
            if (l == 0)
                f = false;
        }
        for (int i = sb.length(); 4 - i > 0; i++) {
            sb = new StringBuffer("A" + sb);
        }
        return sb.toString();
    }
}
