using System;
using System.Threading;

class Solution {
    public static void Main(string[] args) {
        Console.WriteLine(LongestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public static string LongestPalindrome(string s) {
        return LongestPalindromeLimit(s, 1);
    }

    public static string LongestPalindromeLimit(string s, int limit) {
        if (isPalindrome(s)) {
            return s;
        } else {
            if (s.Length < 3) {
                return "";
            }
            if (s.Length == limit + 1) {
                return "";
            }

            string p1 = LongestPalindromeLimit(s.Substring(0, s.Length - 1), limit);

            if (p1.Length == s.Length - 1) {
                return p1;
            }

            string p2 = LongestPalindromeLimit(s.Substring(1, s.Length - 1), p1.Length > limit ? p1.Length : limit);

            if (p1.Length > p2.Length) {
                return p1;
            } else {
                return p2;
            }
        }
    }

    public static Boolean isPalindrome(string s) {
        string first, second;
        int halfLength = Convert.ToInt32(s.Length / 2);

        if (s.Length % 2 == 1) {
            first = s.Substring(0, halfLength);
            second = s.Substring(halfLength + 1, halfLength);
        } else {
            first = s.Substring(0, halfLength);
            second = s.Substring(halfLength, halfLength);
        }

        char[] secondArr = second.ToCharArray();
        Array.Reverse(secondArr);

        if (first == new string(secondArr)) {
            return true;
        }
        return false;
    }
}