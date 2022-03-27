package org.fastcampus;

// 서문지슬
public class ThreeSixNineGame2 {

    public static void main(String[] args) {

        for(int i = 1; i <= 100; i++) { // TODO i媛� 1遺��� 100源뚯� 諛섎났�섏뼱�쇳빀�덈떎.

            int secondNumber = i % 10; // TODO 1�� �먮━ �レ옄瑜� �섑��낅땲��
            int firstNumber = ( i / 10 ) % 10;  // TODO 10�� �먮━ �レ옄瑜� �섑��낅땲��.

            // fistNumber / secondNumber媛� 0�� 寃쎌슦 3�� 諛곗닔 �щ��� �곴��놁씠 %3�� 0�� �섎�濡� 0�� �꾨땲�쇰뒗 議곌굔 異붽�
            boolean is306090 = ((firstNumber != 0) && (firstNumber % 3 == 0)); // TODO �レ옄�� 10�� �먮━�섍� 3, 6, 9 �� �대떦 �섎뒗吏� �뺤씤�댁＜�몄슂
            boolean is369 = ((secondNumber != 0) && (secondNumber % 3 == 0));  // TODO �レ옄�� 1�� �먮━�섍� 3, 6, 9 �� �대떦 �섎뒗吏� �뺤씤�댁＜�몄슂

            // TODO �レ옄媛� 33, 36, 39, 63, 66, 69, 93, 96, 99�� �대떦�섎뒗 寃쎌슦 '**'�� 異쒕젰�⑸땲��. System.out.println("**")
            // TODO �レ옄�� 3, 6, 9媛� �쒕쾲 �ы븿�섎뒗 寃쎌슦 '*'�� 異쒕젰�⑸땲��. System.out.println("*")


            //1. 1�� �먮━ & 10�� �먮━ �� �� 3, 6, 9�� 寃쎌슦 **
            if(is306090 == true && is369 == true) {

                System.out.println("**");
            }

            //2. 1�� �먮━ & 10�� �먮━ 以� �섎굹留� 3, 6, 9�� 寃쎌슦 *
            else if (is306090 == true || is369 == true) {

                System.out.println("*");
            }

            //3. �レ옄�� 3, 6, 9 媛� �ㅼ뼱媛�吏� �딆쓣 寃쎌슦 �レ옄 異쒕젰
            else {

                System.out.println(i);
            }


        }
    }
}