import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));
        
        BigInteger b1 = BigInteger.valueOf(wl);
        BigInteger b2 = BigInteger.valueOf(hl);
        BigInteger gcd = b1.gcd(b2);
        
        answer = (wl * hl) - ((wl + hl) - gcd.longValue());
        
        return answer;
    }
}