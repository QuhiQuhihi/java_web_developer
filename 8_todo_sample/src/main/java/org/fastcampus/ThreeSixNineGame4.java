package org.fastcampus;

// 배상은
public class ThreeSixNineGame4 {

    public static void main(String[] args) {
        int i = 1;
        while(i <= 100) { // TODO i媛� 1遺��� 100源뚯� 諛섎났�섏뼱�쇳빀�덈떎.
            int secondNumber = i%10; // TODO 1�� �먮━ �レ옄瑜� �섑��낅땲��
            int firstNumber = i/10;  // TODO 10�� �먮━ �レ옄瑜� �섑��낅땲��.

            boolean is306090 = false; // TODO �レ옄�� 10�� �먮━�섍� 3, 6, 9 �� �대떦 �섎뒗吏� �뺤씤�댁＜�몄슂
            if (firstNumber%3==0 && firstNumber!=0) {
                is306090 = true;
            }

            boolean is369 = false;  // TODO �レ옄�� 1�� �먮━�섍� 3, 6, 9 �� �대떦 �섎뒗吏� �뺤씤�댁＜�몄슂
            if (secondNumber%3==0 && secondNumber!=0) {
                is369 = true;
            }

            // TODO �レ옄媛� 33, 36, 39, 63, 66, 69, 93, 96, 99�� �대떦�섎뒗 寃쎌슦 '**'�� 異쒕젰�⑸땲��.
            if (is369 && is306090) {
                System.out.println("**");
            }
            // TODO �レ옄�� 3, 6, 9媛� �쒕쾲 �ы븿�섎뒗 寃쎌슦 '*'�� 異쒕젰�⑸땲��.
            else if(is369 || is306090) {
                System.out.println("*");
            }
            // �レ옄�� 3, 6, 9 媛� �ㅼ뼱媛�吏� �딆쓣 寃쎌슦 �レ옄媛� 異쒕젰�⑸땲��.
            else {
                System.out.println(i);
            }
            i ++; // �レ옄瑜� 1 利앷��쒗궡
        }
    }
}