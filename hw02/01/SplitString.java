/* 1. Создайте переменную типа String c любым текстом (не сильно короткое).
Далее выведите на экран количество символов в данной строке. Далее разделите
строку пополам (если ровно поделить не выходит то +­1 не страшно), в результате
у вас должно быть 2­е новых переменных типа String с частями из изначальной
строки. Полученные строки выведите на экран.*/

class SplitString{
  public static void main(String[] args) {
    String string = "the test string";
    int length = string.length();
    int halfLength = length / 2 + length % 2;
    /* added (length % 2) to ensure that firstHalf's length will always
    equals or greater (for string with odd length) than secondHalf's lenght */
    String firstHalf = string.substring(0,halfLength);
    String secondHalf = string.substring(halfLength, length);
    System.out.print("Стартовая строка: \"" + string + "\"\n" );
    System.out.print("Первая половина: \"" + firstHalf + "\"\n" );
    System.out.print("Вторая половина: \"" + secondHalf + "\"\n" );
  }
}
