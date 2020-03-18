package interview.offer;

import java.util.ArrayList;
import java.util.List;

public class FirstNotRepeatCharInStream {

    List<Character> list = new ArrayList<>();
    public void Insert(char ch)
    {
        Character c = ch;
        if (list.contains(c)){
            list.remove(c);
        }else {
            list.add(c);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (list.isEmpty()){
            return '#';
        }
        return list.get(0);
    }

}
