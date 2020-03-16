package interview.offer;

import java.util.Arrays;

public class PokerContinuousWithJoker {
    /**
     * 买了一副扑克牌,发现里面居然有2个大王,2个小王,随机从中抽出了5张牌,看看能不能抽到顺子,
     * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
     * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null||numbers.length!=5) {
            return false;
        }
        int dis = 0; //两张牌差值大于1的值的累加值
        int zero = 0;//大小王个数;
        Arrays.sort(numbers);
        for (int i = 0; i < 4; i++) {
            if (numbers[i]==0){
                zero++;
            }else {
                int sub = numbers[i + 1] - numbers[i];
                if (sub==0){
                    return false;
                }
                dis += sub-1;//sub-1为需要大小王弥补的中间牌的个数
            }
        }
        return zero>=dis;
    }
}
