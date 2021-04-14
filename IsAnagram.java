package niuke;

/**
 * 描述：  判断两个字符串是否是字母异位词
 * 因为字母的个数是有限的， 可以使用长度有限的数组来实现相应的字符次数的记录， 相当于一个hash映射的关系
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t){
        int[] record = new int[26];

        for(int i = 0; i<s.length(); i++){
            record[s.charAt(i) - 'a']++;  // 先从字符串S中加入对应的字符并进行统计
        }

        for(int i = 0; i< s.length(); i++){
            record[t.charAt(i) - 'a']--;  // 再从字符串t中进行相应字符串的删除操作
        }

        for(int i = 0; i < 26; i++){
            if(record[i] != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean anagram = isAnagram("aaad", "aaaa");
        if (anagram){
            System.out.println("success");
        }
        else{
            System.out.println("failed");
        }
    }
}
